package co.com.webtest.certification.lili.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.webtest.certification.lili.userinterface.AgentDetail.SEARCH_BOX_INTENTS;
import static co.com.webtest.certification.lili.userinterface.AgentIntents.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DeleteIntent implements Interaction {

    public DeleteIntent() {
    }

    public static DeleteIntent fromCurrentAgent() {
        return Tasks.instrumented(DeleteIntent.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo((WaitUntil.the(BUTTON_MORE_OF_INTENT, isVisible()).forNoMoreThan(15).seconds()),
                Click.on(BUTTON_MORE_OF_INTENT),
                Click.on(BUTTON_DELETE_INTENT), WaitUntil.the(BUTTON_IN_ALERT_CONFIRM_DELETE, isVisible()),
                Click.on(BUTTON_IN_ALERT_CONFIRM_DELETE),
                WaitUntil.the(ALERT_MESSAGE_SUCCESS_DELETED, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_OK_DELETED));
    }
}
