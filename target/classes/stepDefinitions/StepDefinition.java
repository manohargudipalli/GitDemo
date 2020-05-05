package stepDefinitions;

import org.junit.Assert;

import academy.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;

public class StepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String url) throws Throwable {

		driver.get(url);
	}

	@Given("^Click on Login link in home page to land on secure sign in page$")
	public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getSignIn().click();
	}

	@When("^User enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String email, String password) throws Throwable {

		LoginPage lp = new LoginPage(driver);

		if (driver.getTitle().contains("Rahul Shetty Academy")) {

			lp.getEmail().sendKeys(email);
			lp.getPassword().sendKeys(password);
			lp.getLogin().click();
		}

		else {
			System.out.println("Not able to navigate to Login Page");
		}
	}

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {

		PortalHomePage ph = new PortalHomePage(driver);

		Assert.assertTrue(ph.getSearchBox().isDisplayed());
	}

	@Then("^Verify that login status is (.+)$")
	public void verify_that_login_status_is(String status) throws Throwable {

		if (status.equalsIgnoreCase("successful")) {
			PortalHomePage ph = new PortalHomePage(driver);

			Assert.assertTrue(ph.getSearchBox().isDisplayed());
		} else if (status.equalsIgnoreCase("failed")) {
			LoginPage lp = new LoginPage(driver);
			Assert.assertTrue(lp.getLoginError().isDisplayed());
		}
	}

	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

}
