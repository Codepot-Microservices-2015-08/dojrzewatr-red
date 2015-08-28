package pl.codepot.dojrzewatr.brewing
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import pl.codepot.dojrzewatr.BrewController
import spock.lang.Specification

abstract class BaseMockMvcSpec extends Specification {

    def setup() {
        RestAssuredMockMvc.standaloneSetup(new BrewController())

    }

}
