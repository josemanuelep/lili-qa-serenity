package co.com.webtest.certification.lili.stepsdefinitions;

import co.com.webtest.certification.lili.exceptions.SearchIntentException;
import co.com.webtest.certification.lili.interactions.DeleteIntent;
import co.com.webtest.certification.lili.interactions.OpenDesingItems;
import co.com.webtest.certification.lili.model.FeatureData;
import co.com.webtest.certification.lili.questions.IntentIsVisible;
import co.com.webtest.certification.lili.questions.IntentsHave;
import co.com.webtest.certification.lili.tasks.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static co.com.webtest.certification.lili.exceptions.SearchIntentException.ALERT_MESSAGE_INTENT_NOT_FOUND;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class AgentIntentsSteps {

    @Given("^Go to agent folders and search folder (.*)$")
    public void goToAgentFoldersAndSearchFolder(String folderName) {
        theActorInTheSpotlight().wasAbleTo(SearchAgentFolder.called(folderName));
    }

    @When("^Search and open agent (.*)$")
    public void searchAndOpenAgent(String agentName) {
        theActorInTheSpotlight().attemptsTo(SearchAgent.called(agentName));
    }

    @And("^Open design items$")
    public void openDesingItems() {
        theActorInTheSpotlight().attemptsTo(OpenDesingItems.ofAgent());
    }

    @Then("^Search intent called (.*)$")
    public void searchIntentCalled(String intentName) {
        theActorInTheSpotlight().attemptsTo(SearchIntent.intoDesignItems(intentName));
    }

    @Then("^The inten should be visible (.*)$")
    public void theIntenShouldBeVisible(String intentName) {
        theActorInTheSpotlight().should(seeThat("Be visible", IntentIsVisible.inTheTable(intentName), containsString(intentName))
                .orComplainWith(SearchIntentException.class, ALERT_MESSAGE_INTENT_NOT_FOUND));
    }

    @When("^Intent is deleted should see confirmation alert message$")
    public void intentIsDeletedShouldSeeConfimationAlertMessage() {
        theActorInTheSpotlight().attemptsTo(DeleteIntent.fromCurrentAgent());
    }

    @Then("^create intent called (.*) with these utterances$")
    public void createIntentCalledWithTheseUtterances(String intentName, List<FeatureData> featureData) {
        theActorInTheSpotlight().attemptsTo(CreateIntent.withgivenIntensList(intentName, featureData));
    }

    @Given("^Filter by date (.*)$")
    public void filterByDate(String date) {
        theActorInTheSpotlight().attemptsTo(FilterIntentByDate.of(date));
    }

    @Then("^the results should have correct date (.*) field$")
    public void theResultsShouldHaveCorrectDateField(String date) {
        theActorInTheSpotlight().should(seeThat(IntentsHave.correctDate(date)));
    }

    @Then("^edit intent called addressIntent adding these new utterances$")
    public void editIntentCalledAddressIntentAddingTheseNewUtterances(List<FeatureData> featureData) {

    }


    @Then("^delete (\\d+) utterances$")
    public void deleteUtterances(int numberOfIntentsToDelete) {

    }
}
