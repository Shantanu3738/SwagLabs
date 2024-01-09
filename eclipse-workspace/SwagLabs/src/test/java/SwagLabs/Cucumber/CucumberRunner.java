package SwagLabs.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/SwagLabs/Cucumber", glue="SwagLabs.StepDefinitions",
monochrome=true, plugin="html:target/index.html")
public class CucumberRunner extends AbstractTestNGCucumberTests{

}
