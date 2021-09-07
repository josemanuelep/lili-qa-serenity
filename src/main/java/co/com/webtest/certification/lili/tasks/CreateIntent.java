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
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static co.com.webtest.certification.lili.userinterface.AgentIntents.*;
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

        actor.attemptsTo(WaitUntil.the(BUTTON_CREATE_NEW_INTENT, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(BUTTON_CREATE_NEW_INTENT),
                WaitUntil.the(INPUT_NAME_INTENT, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(this.intentName).into(INPUT_NAME_INTENT)
        );
        actor.attemptsTo(WaitUntil.the(INPUT_UTTERANCE_NAME, isVisible()).forNoMoreThan(15).seconds());
        WebElement element = INPUT_UTTERANCE_NAME.resolveFor(actor);
        element.sendKeys("Testing");

//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        intentsToCreate.forEach((Intent intent) -> {
//
//            WebElement element = CURRENT_INPUT_UTTERRANCE.resolveFor(actor);
//            element.sendKeys("Testing");
//            js.executeScript("document.querySelector('.utterance_adder>div>a>div').innerHTML= '"+intent.getUttercanceName()+"'");
//            SendKeys.of(Keys.ENTER);
//            getDriver().findElement(By.cssSelector(".utterance_adder>div")).sendKeys(Keys.ENTER);
//        });

//        actor.attemptsTo(WaitUntil.the(BUTTON_SAVE_CHANGES, isVisible()).forNoMoreThan(15).seconds(),
//                Click.on(BUTTON_SAVE_CHANGES),
//                WaitUntil.the(ALERT_MESSAGE_AFTER_SAVE, isVisible()).forNoMoreThan(15).seconds(),
//                Click.on(BUTTON_CLOSE_ALERT)
//        );

    }
}
