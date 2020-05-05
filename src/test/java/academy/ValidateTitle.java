package academy;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import academy.Base;

public class ValidateTitle extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void LaunchURL() throws IOException {

		driver = initializeDriver();
		driver.get(baseURL);
	}

	@Test
	public void validateTitle() {

		HomePage hp = new HomePage(driver);
		String title = hp.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES");
		log.info("Validated the Title: FEATURED COURSES");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}
