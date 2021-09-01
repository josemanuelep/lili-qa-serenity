package co.com.webtest.certification.lili.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.webtest.certification.lili.userinterface.AgentDetail.DESING_ITEMS_TAB;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenDesingItems implements Interaction {

    public static OpenDesingItems ofAgent(){
        return new  OpenDesingItems();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(
                DESING_ITEMS_TAB, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(DESING_ITEMS_TAB));
    }
}
