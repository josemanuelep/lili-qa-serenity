package co.com.webtest.certification.lili.userinterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    private LoginPage() {
    }

    public static final Target SIGNIN_BUTTON = Target.the("Button to login").located(By.cssSelector("div.c-login-button"));
    public static final Target INPUT_ORGANIZATION = Target.the("Input to enter organization").located(By.name("organizationName"));
    public static final Target BTN_SUBMIT_ORGANIZATION = Target.the("Button to send organization").located(By.xpath("//button[@type='submit']"));
    public static final Target INPUT_EMAIL = Target.the("Input to enter email").located(By.name("username"));
    public static final Target INPUT_PASSWORD = Target.the("Input to enter password").located(By.name("password"));
    public static final Target BTN_CONTINUE_TO_lOGIN = Target.the("Button to send credencials").located(By.name("action"));
}
