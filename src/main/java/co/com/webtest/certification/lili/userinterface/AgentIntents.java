package co.com.webtest.certification.lili.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgentIntents {

    private AgentIntents() {
    }

    public static final Target BUTTON_MORE_OF_INTENT = Target.the("Button to see more oprions of intens").locatedBy("//button[@class='a-dropdown-toggle btn']");
    public static final Target BUTTON_DELETE_INTENT = Target.the("Button to delete current intent").locatedBy("//a[contains(text(),'Delete')]");
    public static final Target BUTTON_EDIT_INTENT = Target.the("Button to edit current intent").locatedBy("//a[contains(text(),'Edit')]");
    public static final Target BUTTON_IN_ALERT_CONFIRM_DELETE = Target.the("Button to confirm delete").locatedBy("//button[contains(text(),'Yes, delete it')]");
    public static final Target ALERT_MESSAGE_SUCCESS_DELETED = Target.the("Success deleted intent").locatedBy("//div[@id='swal2-html-container']");
    public static final Target BUTTON_OK_DELETED = Target.the("Button to close alert").locatedBy("//button[contains(text(),'OK')]");
    public static final Target BUTTON_CREATE_NEW_INTENT = Target.the("Button to create intent").located(By.xpath("(//div[contains(text(),'Create new Intent')])[1]"));
    public static final Target INPUT_NAME_INTENT = Target.the("Input text to enter intent name").locatedBy("//input[@name='name' and @class='input-text w-75']");
    public static final Target INPUT_UTTERRANCE_NAME = Target.the("Input text to enter utterance").locatedBy("(//a[@class='rendered_view']/div)[1]");
    public static final Target BUTTON_SAVE_CHANGES = Target.the("Button to save changes").locatedBy("//div[@id='#edit_intent_action']");
    public static final Target ALERT_MESSAGE_AFTER_SAVE = Target.the("Message confirmation of saved intent").locatedBy("//div[@id='swal2-html-container']");
    public static final Target BUTTON_CLOSE_ALERT = Target.the("Button to close alert").locatedBy("//div[@id='swal2-html-container']");
}
