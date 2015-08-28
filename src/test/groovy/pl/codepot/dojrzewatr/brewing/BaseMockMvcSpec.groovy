package pl.codepot.dojrzewatr.brewing
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc
import org.mockito.Mockito
import org.mockito.stubbing.DeprecatedOngoingStubbing
import pl.codepot.dojrzewatr.BrewController
import pl.codepot.dojrzewatr.brewing.model.BrewService
import spock.lang.Specification

abstract class BaseMockMvcSpec extends Specification {

    def setup() {
        BrewService brewServiceStub = Mockito.mock(BrewService)
        RestAssuredMockMvc.standaloneSetup(new BrewController(brewServiceStub))

    }

}
