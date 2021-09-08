package co.com.webtest.certification.lili.tasks;

import co.com.webtest.certification.lili.model.FeatureData;
import co.com.webtest.certification.lili.model.Intent;
import co.com.webtest.certification.lili.model.builders.IntentBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateIntent implements Task {

    private List<Intent> intentsToCreate;
    private String intentName;

    public static CreateIntent withgivenIntensList(String intentName, List<FeatureData> featureData) {

        return Tasks.instrumented(CreateIntent.class, intentName, inicializateIntentList(featureData));
    }


    public CreateIntent(String intentName, List<Intent> intentsToCreate) {
        this.intentsToCreate = intentsToCreate;
        this.intentName = intentName;
    }

    private static List<Intent> inicializateIntentList(List<FeatureData> featureData) {
        List<Intent> listToReturn = new ArrayList<>();
        featureData.forEach((FeatureData data) -> {
            Intent intent = IntentBuilder.withData(data);
            listToReturn.add(intent);
        });
        return listToReturn;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        fillIntentName();
        fillUtterances();
        saveChanges();
    }

    private void fillUtterances() {
        theActorInTheSpotlight().wasAbleTo(WaitUntil.the(TAG_A_PREVIEW, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(TAG_A_PREVIEW));
        intentsToCreate.forEach((Intent intent) -> {
            theActorInTheSpotlight().attemptsTo(
                    Enter.theValue(intent.getUttercanceName()).into(INPUT_UTTERANCE_NAME).thenHit(Keys.ENTER));
        });
    }

    private void fillIntentName() {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(BUTTON_CREATE_NEW_INTENT, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_CREATE_NEW_INTENT),
                WaitUntil.the(INPUT_NAME_INTENT, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(this.intentName).into(INPUT_NAME_INTENT)
        );
    }

    private void saveChanges() {
        theActorInTheSpotlight().attemptsTo(WaitUntil.the(BUTTON_SAVE_CHANGES, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_SAVE_CHANGES),
                WaitUntil.the(ALERT_MESSAGE_AFTER_SAVE, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_CLOSE_ALERT));
    }
}
