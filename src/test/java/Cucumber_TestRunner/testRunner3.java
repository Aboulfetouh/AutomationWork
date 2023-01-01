package Cucumber_TestRunner;

import OrangehrmLive_Pageclass.baseclass;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/test/java/Cucumber_Features", glue = {"Cucumber_StepDefinitions"}, plugin = {
//		"pretty", "html:target/cucumber-reports" })
@CucumberOptions(features = "src/test/java/Cucumber_Features/login.feature:39", glue = {"Cucumber_StepDefinitions"}, plugin = {
		"pretty", "html:target/cucumber-reports" })
public class testRunner3 extends baseclass {

}