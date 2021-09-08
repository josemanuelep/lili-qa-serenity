package co.com.webtest.certification.lili.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        dryRun = true,
        tags = "@EditIntent",
        features = "src/test/resources/features/agent_intents.feature",
        glue = "co.com.webtest.certification.lili.stepsdefinitions",
        snippets = CAMELCASE
)
public class AgentIntentsRunner {
}
