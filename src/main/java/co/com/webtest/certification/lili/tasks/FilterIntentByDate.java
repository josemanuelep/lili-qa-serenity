package co.com.webtest.certification.lili.tasks;

import co.com.webtest.certification.lili.interactions.SelectDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.BUTTON_FILTER_BY_DATE;
import static co.com.webtest.certification.lili.userinterface.AgentIntents.LOADING_SPINNER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class FilterIntentByDate implements Task {

    private String stringDate;

    public FilterIntentByDate(String stringDate) {
        this.stringDate = stringDate;
    }

    public static FilterIntentByDate of(String stringDate) {
        return Tasks.instrumented(FilterIntentByDate.class, stringDate);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BUTTON_FILTER_BY_DATE, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(LOADING_SPINNER, isNotVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_FILTER_BY_DATE), SelectDate.by(this.stringDate));
    }

}
