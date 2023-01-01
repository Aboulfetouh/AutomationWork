package Cucumber_StepDefinitions;

import static Readerclass.directorySourceReader.*;
import java.io.IOException;
import org.testng.Assert;

import OrangehrmLive_Pageclass.baseclass;
import OrangehrmLive_Pageclass.dashboardPage;
import OrangehrmLive_Pageclass.landingPage;
import UtilitiesClass.CookiesManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CookiesSteps {

	baseclass base = new baseclass();
	landingPage landing = new landingPage();
	dashboardPage dash = new dashboardPage();
	CookiesManager manager = new CookiesManager();
	
	@Given("^User Opens the home page (.*)$")
	public void user_opens_the_home_page(String url) throws IOException, Exception  {
		base.getURL(url);
	}
	
	@When("^User login using valid (.*) and (.*)$")
	public void user_login_using_Valid_username_and_password(String user, String pass) {
		landing.fillUsername(user);
		landing.fillPassword(pass);
		landing.clickLogin();
	}

	@Then("Was directed to the DashBoard page {int}")
	public void was_directed_to_the_dash_board_page(int size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("DashBoard Assertion Before Cookies Passed");
	}

	@And("^Stores the session (.*)$")
	public void stores_the_session_cookies(String Cookies) throws IOException {
		manager.storeCookiesToText(getCookiesDirectory(), Cookies);
	}

	@And("^User opens the (.*)$")
	public void user_opens_the_dashurl(String DashURL) throws Exception {
		base.getURL(DashURL);
	}
	
	@When("^User loads the session (.*)$")
	public void user_loads_the_session_cookies(String Cookies) throws IOException {
		manager.loadCookies(getCookiesDirectory(), Cookies);
	}

	@Then("User should be able to see the DashBoard page {int}")
	public void user_should_be_able_to_see_the_dash_board_page(Integer size) {
		Assert.assertEquals(dash.dashboardElementsSize(), size);
		System.out.println("DashBoard Assertion After Cookies Passed");
	}
}