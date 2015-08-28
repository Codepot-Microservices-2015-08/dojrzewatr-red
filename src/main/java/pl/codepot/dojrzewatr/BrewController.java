package pl.codepot.dojrzewatr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.codepot.dojrzewatr.brewing.model.BrewService;
import pl.codepot.dojrzewatr.brewing.model.IngredientList;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/brew", consumes = "application/vnd.pl.codepot.dojrzewatr.v1+json", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrewController {
    public static Logger log = LoggerFactory.getLogger(BrewController.class);

    private BrewService service;

    @Autowired
    public BrewController(BrewService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addIngredients(@RequestBody IngredientList list, HttpServletResponse response) {
        log.info("addIngredients() ivoked with " + list.toString());
        service.addIngredients(list);

        response.setStatus(HttpServletResponse.SC_OK);
    }
}
