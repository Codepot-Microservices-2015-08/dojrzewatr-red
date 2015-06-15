package pl.devoxx.dojrzewatr.brewing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.devoxx.dojrzewatr.brewing.model.Version;

@RestController
@RequestMapping(value = "/brew", consumes = Version.DOJRZEWATR_V1)
public class BrewController {

    private final ButelkatrUpdater butelkatrUpdater;

    @Autowired
    public BrewController(ButelkatrUpdater butelkatrUpdater) {
        this.butelkatrUpdater = butelkatrUpdater;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void distributeIngredients() {
          butelkatrUpdater.updateButelkatrAboutBrewedBeer();
    }
}
