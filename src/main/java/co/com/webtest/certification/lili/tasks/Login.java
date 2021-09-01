package co.com.webtest.certification.lili.tasks;

import co.com.webtest.certification.lili.model.Credencials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.webtest.certification.lili.userinterface.LoginPage.*;

public class Login implements Task {

    private Credencials credencials;
    private String organization;

    public Login(Credencials credencials, String organization) {
        this.credencials = credencials;
        this.organization = organization;
    }

    public static Login withUser(Credencials credencials, String organization) {
        return Tasks.instrumented(Login.class, credencials, organization);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        enterOrganization();
        enterCredencials();
    }

    private void enterOrganization() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(SIGNIN_BUTTON), Enter.theValue(organization).into(INPUT_ORGANIZATION),
                Click.on(BTN_SUBMIT_ORGANIZATION));
    }

    private void enterCredencials() {
        OnStage.theActorInTheSpotlight().attemptsTo(Enter.theValue(credencials.getUser()).into(INPUT_EMAIL),
                Enter.theValue(credencials.getPassword()).into(INPUT_PASSWORD),
                Click.on(BTN_CONTINUE_TO_lOGIN));
    }
}
