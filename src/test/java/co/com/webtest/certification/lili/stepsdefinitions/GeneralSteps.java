package co.com.webtest.certification.lili.stepsdefinitions;

import co.com.webtest.certification.lili.tasks.Login;
import co.com.webtest.certification.lili.tasks.OpenThe;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.webtest.certification.lili.model.Builders.CredencialsBuilder.getCredencials;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class GeneralSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^User wants go to login in vozy page as (.*) in (.*) organization$")
    public void userWantsGoToLoginInVozyPage(String user, String organization) {
        theActorCalled(user).wasAbleTo(OpenThe.page(), Login.withUser(getCredencials(user), organization));
    }
}
