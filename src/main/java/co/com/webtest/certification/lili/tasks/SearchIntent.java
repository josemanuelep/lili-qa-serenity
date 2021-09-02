package co.com.webtest.certification.lili.tasks;

import co.com.webtest.certification.lili.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.webtest.certification.lili.userinterface.AgentDetail.SEARCH_BOX_INTENTS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchIntent implements Task {

    private String intentName;

    public SearchIntent(String intentName) {
        this.intentName = intentName;
    }

    public static SearchIntent intoDesigItems(String intentName) {
        return Tasks.instrumented(SearchIntent.class, intentName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(SEARCH_BOX_INTENTS, isVisible()).forNoMoreThan(15).seconds(),
                Wait.oneMoment(1),
                Click.on(SEARCH_BOX_INTENTS),
                MoveMouse.to(SEARCH_BOX_INTENTS),
                Enter.theValue(intentName.trim()).into(SEARCH_BOX_INTENTS).thenHit(Keys.ENTER).thenHit(Keys.SPACE).thenHit(Keys.BACK_SPACE),
                Wait.oneMoment(2));
    }
}
