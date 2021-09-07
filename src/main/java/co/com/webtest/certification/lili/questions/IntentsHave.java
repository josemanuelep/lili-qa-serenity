package co.com.webtest.certification.lili.questions;

import co.com.webtest.certification.lili.interactions.Wait;
import co.com.webtest.certification.lili.util.CustomDate;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.text.ParseException;
import java.util.List;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.*;
import static co.com.webtest.certification.lili.util.Constants.*;
import static co.com.webtest.certification.lili.util.CustomDate.getDaysOfThisWeek;
import static co.com.webtest.certification.lili.util.CustomDate.getYesterdayAsTableFormat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class IntentsHave implements Question<Boolean> {

    private String dateAsString;

    public IntentsHave(String dateAsString) {
        this.dateAsString = dateAsString;
    }

    public static IntentsHave correctDate(String dateAsString) {
        return new IntentsHave(dateAsString);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(LOADING_SPINNER, isNotVisible()).forNoMoreThan(15).seconds(), Wait.oneMoment(1));
        switch (this.dateAsString) {
            case TODAY:
                validateResultsToday(actor);
                break;
            case YESTERDAY:
                validateResultsYesterday(actor);
                break;
            case THIS_WEEK:
                validateResultsThisWeek(actor);
                break;
            case ALL_TIME:
                validateResultsAllTime(actor);
                break;
            default:
                try {
                    validateResultsSpecificDate(actor);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
        return true;
    }

    private void validateResultsToday(Actor actor) {

        if (!thereAreNoItems(actor)) {
            String todayString = CustomDate.getTodayAsTableFormat();
            List<WebElementFacade> listResults = SEARCH_DATE_FIELDS.resolveAllFor(actor);
            listResults.forEach((WebElementFacade webElementFacade) -> {
                String dateOfFront = webElementFacade.getTextValue();
                actor.attemptsTo(Ensure.that(dateOfFront).isNotEmpty(), Ensure.that(todayString).isEqualTo(dateOfFront));
            });
        }
    }

    private void validateResultsYesterday(Actor actor) {
        if (!thereAreNoItems(actor)) {
            List<WebElementFacade> listResults = SEARCH_DATE_FIELDS.resolveAllFor(actor);
            String yesterday = getYesterdayAsTableFormat();

            listResults.forEach((WebElementFacade webElementFacade) -> {
                String dateOfFront = webElementFacade.getTextValue();
                actor.attemptsTo(Ensure.that(dateOfFront).isNotEmpty(), Ensure.that(dateOfFront).isEqualTo(yesterday));
            });
        }
    }

    private void validateResultsThisWeek(Actor actor) {
        if (!thereAreNoItems(actor)) {
            List<WebElementFacade> listResults = SEARCH_DATE_FIELDS.resolveAllFor(actor);
            List<String> dateWeek = getDaysOfThisWeek();
            listResults.forEach((WebElementFacade webElementFacade) -> {
                String dateOfFront = webElementFacade.getTextValue();
                actor.attemptsTo(Ensure.that(dateOfFront).isNotEmpty(), Ensure.that(dateWeek).contains(dateOfFront));
            });
        }
    }

    private void validateResultsAllTime(Actor actor) {
        if (!thereAreNoItems(actor)) {
            List<WebElementFacade> listResults = SEARCH_DATE_FIELDS.resolveAllFor(actor);
            actor.attemptsTo(Ensure.that(listResults).hasSizeGreaterThanOrEqualTo(1));
        }
    }

    private void validateResultsSpecificDate(Actor actor) throws ParseException {
        String customDate = CustomDate.getDateAsTableFormat(dateAsString);
        if (!thereAreNoItems(actor)) {
            List<WebElementFacade> listResults = SEARCH_DATE_FIELDS.resolveAllFor(actor);
            listResults.forEach((WebElementFacade webElementFacade) -> {
                String dateOfFront = webElementFacade.getTextValue();
                actor.attemptsTo(Ensure.that(dateOfFront).isEqualTo(customDate));
            });
        }
    }

    private boolean thereAreNoItems(Actor actor) {
        WebElementFacade elementFacade = NO_ITEMS_MESSAGE.resolveFor(actor);
        return elementFacade.isPresent();
    }
}
