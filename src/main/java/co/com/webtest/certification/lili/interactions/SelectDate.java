package co.com.webtest.certification.lili.interactions;

import co.com.webtest.certification.lili.util.CustomDate;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.interactions.Actions;

import java.text.ParseException;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.*;
import static co.com.webtest.certification.lili.util.Constants.*;
import static co.com.webtest.certification.lili.util.CustomDate.getDateToMonthAndYear;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDate implements Interaction {

    private String dateString;

    public SelectDate(String dateString) {
        this.dateString = dateString;
    }

    public static SelectDate by(String dateString) {
        return new SelectDate(dateString);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            switch (this.dateString) {
                case TODAY:
                    filterSpecificNotDateTime(TODAY);
                    break;
                case YESTERDAY:
                    filterSpecificNotDateTime(YESTERDAY);
                    break;
                case THIS_WEEK:
                    filterSpecificNotDateTime(THIS_WEEK);
                    break;
                case ALL_TIME:
                    filterSpecificNotDateTime(ALL_TIME);
                    break;
                default:
                    filterByDate();
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void filterByDate() throws ParseException {
        while (IsGivenDate())
            theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_FILTER_BY_DATE_PREVIOUS_MONTH));
        Target dayInCalendar = BUTTON_DAY_OF_MONTH.of(CustomDate.getDateToSearchElement(this.dateString));
        theActorInTheSpotlight().attemptsTo(MoveMouse.to(dayInCalendar).andThen(Actions::doubleClick), Click.on(BUTTON_APPLY_FILTER));
    }

    private void filterSpecificNotDateTime(String type) {
        Target button = BUTTON_FILTER_BY_DATE_SPECIFIC.of(type);
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(button, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(button));
    }

    private boolean IsGivenDate() throws ParseException {
        WebElementFacade elementFacade = TEXT_OF_CURRENT_MONTH.of(getDateToMonthAndYear(this.dateString)).resolveFor(theActorInTheSpotlight());
        return !(elementFacade.isCurrentlyVisible() && elementFacade.isCurrentlyEnabled());
    }
}
