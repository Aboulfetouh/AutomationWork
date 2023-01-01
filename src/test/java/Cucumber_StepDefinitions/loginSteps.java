package Cucumber_StepDefinitions;

import static Readerclass.directorySourceReader.*;
//import static Readerclass.configReader.*;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;

import OrangehrmLive_Pageclass.baseclass;
import OrangehrmLive_Pageclass.dashboardPage;
import OrangehrmLive_Pageclass.landingPage;
import UtilitiesClass.TakeScreenShot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	baseclass base = new baseclass();
	landingPage landing = new landingPage();
	dashboardPage dash = new dashboardPage();
	TakeScreenShot screenshot = new TakeScreenShot();

	@Given("^User opened the Home (.*)$")
	public void user_opened_the_home_url(String URL) throws IOException, Exception {
		base.getURL(URL);
	}

	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String user, String pass) {
		landing.fillUsername(user);
		landing.fillPassword(pass);
	}

	@When("Clicks on the login button")
	public void clicks_on_the_login_button() throws InterruptedException {
		landing.clickLogin();
	}

	@Then("User is directed to the DashBoard page and its {int} are present")
	public void user_is_at_the_dash_board_page(int size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("Assertion Passed");
	}

	@Then("Takes a screenshot after login")
	public void takes_a_screenshot_after_login() throws Exception {
		screenshot.takeFullScreenshot(baseclass.getDriver(), getScreeshotsDirectory(), "PositiveLoginFunctionality");
	}

	@Then("^User gets the validation (.*)$")
	public void user_gets_the_validation_ErrorMessage(String errormessage) {
		switch (errormessage) {
		case "Required":
			if (landing.usernameErrorMessageIsDisplayed()) {
				Assert.assertEquals(landing.getUsernameErrorMessage(), errormessage);
				Reporter.log("All fields error message were displayed and has been asserted || Test case passed", true);
			} else {
				System.out.println("Fields error message were not displayed || Test case failed");
			}
			break;
		case "Invalid credentials":
			if (landing.invalidCredentialsIsDisplayed()) {
				Assert.assertEquals(landing.getInvalidCredentialsErrorMessage(), errormessage);
				Reporter.log(
						"The invalid credentials error message was displayed and has been asserted || Test case passed",
						true);
			} else {
				System.out.println("The invalid credentials error message was not displayed || Test case failed");
			}
			break;
		}
	}
}
