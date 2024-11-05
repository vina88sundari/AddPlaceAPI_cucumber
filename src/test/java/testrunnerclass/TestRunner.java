package testrunnerclass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/java/features"
		,plugin="json:target/jsonReports/cucumber-report.json"
		,glue={"stepDefinations"}
		,tags="@Addplace or @DeletePlace" 
		)

public class TestRunner {

}
