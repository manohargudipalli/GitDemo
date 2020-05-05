package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalHomePage {

	public WebDriver driver;

	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search-courses")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
}
