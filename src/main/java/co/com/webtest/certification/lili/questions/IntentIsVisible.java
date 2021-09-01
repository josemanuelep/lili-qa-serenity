package co.com.webtest.certification.lili.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.webtest.certification.lili.userinterface.AgentDetail.RESULT_OF_SEARCH_INTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IntentIsVisible implements Question<String> {

    private String intentName;

    public IntentIsVisible(String intentName) {
        this.intentName = intentName;
    }

    public static IntentIsVisible inTheTable(String intentName) {
        return new IntentIsVisible(intentName);
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(RESULT_OF_SEARCH_INTENT.of(intentName.trim()), isVisible()).forNoMoreThan(15).seconds(),
                Click.on(RESULT_OF_SEARCH_INTENT.of(intentName.trim())));
        return Text.of(RESULT_OF_SEARCH_INTENT.of(intentName.trim())).viewedBy(actor).asString();
    }
}
