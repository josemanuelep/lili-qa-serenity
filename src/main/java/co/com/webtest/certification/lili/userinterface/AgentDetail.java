package co.com.webtest.certification.lili.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AgentDetail {
    private AgentDetail() {
    }

    public static final Target DESING_ITEMS_TAB = Target.the("Desing items tab").located(By.xpath("//div[@id='rc-tabs-1-tab-1']"));
    public static final Target SEARCH_BOX_INTENTS = Target.the("Intents search box").located(By.xpath("//input[@type='text' and @placeholder='Type to start browsing']"));
    public static final Target RESULT_OF_SEARCH_INTENT = Target.the("Result of search intent").locatedBy("//td[contains(text(),'{0}')]");
}
