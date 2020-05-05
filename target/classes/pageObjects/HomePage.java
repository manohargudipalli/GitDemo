package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='sign_in']")
	private WebElement signIn;

	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	private WebElement title;
	
	@FindBy(css="ul[class='nav navbar-nav navbar-right']")
	private WebElement navigationBar;

	@FindBy(css="ul[class='nav navbar-nav navbar-right'] li")
	private List<WebElement> navigations;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	private List<WebElement> popUp; 
	
	public WebElement getSignIn() {

		return signIn;
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	
	public WebElement getNavBar() {
		return navigationBar;
	}
	
	public List<WebElement> getNavigations() {
		return navigations;
	}

	public List<WebElement> getPopUp() {
		return popUp;
	}
}
