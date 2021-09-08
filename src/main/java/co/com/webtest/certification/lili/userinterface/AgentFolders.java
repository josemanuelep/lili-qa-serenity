package co.com.webtest.certification.lili.userinterface;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AgentFolders {
    private AgentFolders() {
    }
    public static final Target SEARCH_BOX_AGENT_FOLDER = Target.the("Search box agent folders").located(By.xpath("//input[@type='text' and @placeholder='Type to start browsing']"));
    public static final Target SEARCH_BOX_AGENT = Target.the("Search box agents").located(By.xpath("//input[@type='text' and @placeholder='Type to start browsing']"));
    public static final Target SEARCH_RESULT = Target.the("Result of search").locatedBy("//td[text()='{0}']");
}



