import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"autotests.Steps"},
        plugin = {"autotests.Utils.AllureReporter"}
)
public class CucumberRunner {
}