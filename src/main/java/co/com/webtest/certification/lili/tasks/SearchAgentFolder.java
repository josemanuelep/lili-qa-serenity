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

import static co.com.webtest.certification.lili.userinterface.AgentFolders.SEARCH_BOX_AGENT_FOLDER;
import static co.com.webtest.certification.lili.userinterface.AgentFolders.SEARCH_RESULT;
import static co.com.webtest.certification.lili.userinterface.GeneralDashboard.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SearchAgentFolder implements Task {

    private String folderName;

    public SearchAgentFolder(String folderName) {
        this.folderName = folderName;
    }

    public static SearchAgentFolder called(String folderName) {
        return Tasks.instrumented(SearchAgentFolder.class, folderName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Wait.oneMoment(1), WaitUntil.the(HEADER_MENU, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(HEADER_MENU), Click.on(BTN_MENU_AGENTS),
                WaitUntil.the(BTN_MENU_AGENTS_FOLDERS, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BTN_MENU_AGENTS_FOLDERS),
                WaitUntil.the(SEARCH_BOX_AGENT_FOLDER, isVisible()).forNoMoreThan(15).seconds(),
                MoveMouse.to(SEARCH_BOX_AGENT_FOLDER),
                WaitUntil.the(CIRLCE_LOADING, isNotVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(folderName).into(SEARCH_BOX_AGENT_FOLDER).thenHit(Keys.ENTER),
                Wait.oneMoment(1),
                WaitUntil.the(SEARCH_RESULT.of(folderName.trim()), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(SEARCH_RESULT.of(folderName))
        );
    }
}
