package co.com.webtest.certification.lili.tasks;

import co.com.webtest.certification.lili.model.FeatureData;
import co.com.webtest.certification.lili.model.Intent;
import co.com.webtest.certification.lili.model.builders.IntentBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.BUTTON_MORE_OF_INTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EditIntent implements Task {
    private List<Intent> intentsToCreate;
    private String intentName;

    public EditIntent(List<Intent> intentsToCreate, String intentName) {
        this.intentsToCreate = intentsToCreate;
        this.intentName = intentName;
    }

    public static EditIntent withgivenIntensList(String intentName, List<FeatureData> featureData) {

        return Tasks.instrumented(EditIntent.class, intentName, inicializateIntentList(featureData));
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
        actor.attemptsTo(WaitUntil.the(BUTTON_MORE_OF_INTENT, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_MORE_OF_INTENT));
    }
}
