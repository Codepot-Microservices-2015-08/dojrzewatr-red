package pl.codepot.dojrzewatr.notifier;

import com.nurkiewicz.asyncretry.RetryExecutor;
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import pl.codepot.dojrzewatr.brewing.model.Wort;

import static com.netflix.hystrix.HystrixCommand.Setter.withGroupKey;
import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * Created by kedzior on 28.08.15.
 */
public class BootlerNotifier {
    private final ServiceRestClient serviceRestClient;
    private final RetryExecutor retryExecutor;

    @Autowired
    public BootlerNotifier(ServiceRestClient serviceRestClient, RetryExecutor retryExecutor) {
        this.serviceRestClient = serviceRestClient;
        this.retryExecutor = retryExecutor;
    }


    public void notify(Wort wort) {
        serviceRestClient.forService("butelkatr-red")
                .retryUsing(retryExecutor)
                .post()
                .withCircuitBreaker(withGroupKey(asKey("hystrix_group")))
                .onUrl("/bottle")
                .body(wort)
                .withHeaders().contentType("application/vnd.pl.codepot.butelkatr.v1+json")
                .andExecuteFor()
                .ignoringResponseAsync();
    }
}
