package pl.codepot.dojrzewatr.brewing.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codepot.dojrzewatr.notifier.BootlerNotifier;
import pl.codepot.dojrzewatr.notifier.PrezentrNotifier;

@Service
public class BrewService {
    private static final Logger log = LoggerFactory.getLogger(BrewService.class);
    @Autowired
    private BootlerNotifier bootlerNotifier;

    @Autowired
    private PrezentrNotifier prezentrNotifier;


    public void addIngredients(IngredientList list) {
        sleep();

        Integer sum = 0;
        for (Ingredient ing : list.getIngredients()) {
            sum += ing.getQuantity();
        }

        bootlerNotifier.notify(new Wort(sum));
        log.info("bootler notified");
        prezentrNotifier.notifyPresenter();
        log.info("presenter notified");
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
