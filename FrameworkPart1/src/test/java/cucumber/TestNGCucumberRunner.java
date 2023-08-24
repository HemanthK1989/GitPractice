package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="stepDefinition",monochrome=true,tags="@Regression",plugin="html:target/Cucumber.html")
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests{

}
