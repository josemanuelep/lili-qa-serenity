package co.com.webtest.certification.lili.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ChangeToDefault implements Interaction {
    public static ChangeToDefault window(){
        return new ChangeToDefault();
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        getDriver().switchTo().window(getDriver().getWindowHandle());
    }
}
