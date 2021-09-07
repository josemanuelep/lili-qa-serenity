package co.com.webtest.certification.lili.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class GeneralDashboard {

    private GeneralDashboard() {
    }

    public static final Target HEADER_MENU = Target.the("Image in menu").located(By.cssSelector(".header-menu"));
    public static final Target BTN_MENU_AGENTS = Target.the("Agents button").located(By.xpath("//div[contains(text(),'Agents')]"));
    public static final Target BTN_MENU_AGENTS_FOLDERS = Target.the("Agents folders").located(By.xpath("//div[@class='item-menu pl-4'][1]"));
    public static final Target CIRLCE_LOADING = Target.the("Loading image").located(By.xpath("//body/div[@id='root']/div[2]"));
}
