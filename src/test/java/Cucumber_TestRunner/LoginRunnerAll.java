package Cucumber_TestRunner;

import OrangehrmLive_Pageclass.baseclass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/Cucumber_Features", glue = {
		"Cucumber_StepDefinitions" }, tags = "@LoginFunctionality", plugin = { "pretty",
				"html:target/cucumber-reports" })
public class LoginRunnerAll extends baseclass {
}