package academy;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import academy.Base;

public class HomePageTest extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void LaunchURL() throws IOException {

		driver = initializeDriver();
		log.info("Browser is initialised");

		driver.get(baseURL);
		log.info("Navigated to the URL");
	}

	@Test
	public void validateNavigationBar() {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getNavBar().isDisplayed());
		log.info("Validated the NavigationBar display");
		System.out.println("This text is to practice on GitHub commands");
		System.out.println("This text is to practice to commit the code in GitHub ");
		
	}
	
	@Test
	public void validateNavigationBar2() {
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getNavBar().isDisplayed());
		log.info("Validated the NavigationBar display");
		System.out.println("This text is to practice on GitHub commands");
		System.out.println("This text is to practice to commit the code in GitHub ");
		
	}
	
	

	@Test
	public void validateNavigations() {
		HomePage hp = new HomePage(driver);
		List<WebElement> navigations = hp.getNavigations();
		// System.out.println(navigations);
		Assert.assertTrue(navigations.get(1).getText().contains("COURSES"));
		log.info("Validated the navigation bar contains COURSES option");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
