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
    public static final Target INPUT_UTTERANCE_NAME = Target.the("Input text to enter utterance").locatedBy("//input[@name='utterance_creator_input']");
    public static final Target TAG_A_PREVIEW = Target.the("Input text to enter utterance and send click").locatedBy("//a[@name='utterance_creator_preview']");
    public static final Target TOGGLE_SLOT_PREVIEW = Target.the("Toggle button to active slots").locatedBy(".indicator");
    public static final Target CURRENT_INPUT_UTTERANCES = Target.the("Input text with current utterance").locatedBy(".utterance_adder>div>div");
    public static final Target BUTTON_SAVE_CHANGES = Target.the("Button to save changes").locatedBy("//div[contains(text(),'Save changes')]");
    public static final Target ALERT_MESSAGE_AFTER_SAVE = Target.the("Message confirmation of saved intent").locatedBy("//div[@id='swal2-html-container']");
    public static final Target BUTTON_CLOSE_ALERT = Target.the("Button to close alert").locatedBy("//div[@id='swal2-html-container']");
    public static final Target BUTTON_FILTER_BY_DATE = Target.the("Button to filter by date").locatedBy(".btn-date-filter");
    public static final Target BUTTON_FILTER_BY_DATE_SPECIFIC = Target.the("Button filter date by speccific day , Today, Yerterday, All Time or this week").locatedBy("//div[contains(text(),'{0}')]");
    public static final Target BUTTON_FILTER_BY_DATE_PREVIOUS_MONTH = Target.the("Button filter date previous month").locatedBy("//div[@aria-label='Move backward to switch to the previous month.']");
    public static final Target TEXT_OF_CURRENT_MONTH = Target.the("Current month").locatedBy("//strong[contains(text(),'{0}')]");
    public static final Target BUTTON_DAY_OF_MONTH = Target.the("Button day fo month").locatedBy("//td[contains(@aria-label,'{0}')]");
    public static final Target BUTTON_APPLY_FILTER = Target.the("Button apply filter").locatedBy("//div[contains(text(),'Apply filter')]");
    public static final Target LOADING_SPINNER = Target.the("Loading spinner").locatedBy("//div[@aria-label='Loading']");
    public static final Target SEARCH_DATE_FIELDS = Target.the("List of created date of intents").locatedBy("//tbody/tr/td[2]");
    public static final Target NO_ITEMS_MESSAGE = Target.the("H2 when search is empty").locatedBy("//tbody/tr[1]/td[1]/div[1]");
}
