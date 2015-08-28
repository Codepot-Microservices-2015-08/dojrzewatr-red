package pl.codepot.dojrzewatr;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.codepot.dojrzewatr.brewing.model.IngredientList;

import javax.servlet.http.HttpServletResponse;

@RestController

@RequestMapping(value = "/brew", consumes = "application/vnd.pl.codepot.dojrzewatr.v1+json", produces = MediaType.APPLICATION_JSON_VALUE)
public class BrewController {


    @RequestMapping(method = RequestMethod.POST)
    public void doSomeFancyStuff(@RequestBody IngredientList list, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
