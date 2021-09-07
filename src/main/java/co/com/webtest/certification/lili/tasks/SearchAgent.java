package co.com.webtest.certification.lili.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.webtest.certification.lili.userinterface.AgentFolders.SEARCH_BOX_AGENT;
import static co.com.webtest.certification.lili.userinterface.AgentFolders.SEARCH_RESULT;
import static co.com.webtest.certification.lili.userinterface.GeneralDashboard.CIRLCE_LOADING;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchAgent implements Task {

    private String agentName;

    public SearchAgent(String agentName) {
        this.agentName = agentName;
    }

    public static SearchAgent called(String agentName){
        return Tasks.instrumented(SearchAgent.class, agentName);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(CIRLCE_LOADING, isNotVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SEARCH_BOX_AGENT, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(agentName.trim()).into(SEARCH_BOX_AGENT).thenHit(Keys.ENTER),
                WaitUntil.the(SEARCH_RESULT.of(agentName.trim()), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(SEARCH_RESULT.of(agentName)));
    }
}
