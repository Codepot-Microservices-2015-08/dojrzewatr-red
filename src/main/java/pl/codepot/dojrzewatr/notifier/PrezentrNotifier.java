package pl.codepot.dojrzewatr.notifier;

import com.google.common.util.concurrent.ListenableFuture;
import com.nurkiewicz.asyncretry.RetryExecutor;
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import static com.netflix.hystrix.HystrixCommand.Setter.withGroupKey;
import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;



public class PrezentrNotifier {
    private final ServiceRestClient serviceRestClient;
    private final RetryExecutor retryExecutor;

    @Autowired
    public PrezentrNotifier(ServiceRestClient serviceRestClient, RetryExecutor retryExecutor) {
        this.serviceRestClient = serviceRestClient;
        this.retryExecutor = retryExecutor;
    }


    public void notifyPresenter() {
        serviceRestClient.forService("prezentatr-red")
                .retryUsing(retryExecutor)
                .put()
                .withCircuitBreaker(withGroupKey(asKey("hystrix_group")))
                .onUrl("/feed/dojrzewatr")
                .withoutBody()
                .withHeaders().contentType("application/vnd.pl.codepot.prezentatr.v1+json")
                .andExecuteFor()
                .ignoringResponseAsync();
    }
}
