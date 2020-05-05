package academy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
//import pageObjects.LandingPage;
import pageObjects.LoginPage;
import academy.Base;

public class LoginPageTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void LaunchURL() throws IOException {

		driver = initializeDriver();
		log.info("Browser is initialised");

		driver.get(baseURL);
		log.info("Navigated to the URL");
	}

	@Test
	public void loginPageNavigation() throws IOException, InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.getSignIn().click();
		Thread.sleep(5000L);
		log.info("Cliked on Login link to open the SignIn/Login Page");

	}

	@Test(dependsOnMethods = { "loginPageNavigation" })
	public void loginTest() throws IOException {

		LoginPage lp = new LoginPage(driver);
		if (driver.getTitle().contains("Rahul Shetty Academy")) {
			lp.getEmail().sendKeys(email);
			log.info("Entred the Email");
			lp.getPassword().sendKeys(password);
			log.info("Entred the Password");
			lp.getLogin().click();
			log.info("Cliked on Login button");

		} else {
			System.out.println("Not able to navigate to Login Page");
		}

	}

	@DataProvider

	public void loginDetails() {

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

}
