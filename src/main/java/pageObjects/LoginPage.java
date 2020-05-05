package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	private WebElement Email;

	@FindBy(id = "user_password")
	private WebElement password;

	@FindBy(name = "commit")
	private WebElement login;

	@FindBy(css = "div[class='alert alert-danger']")
	private WebElement loginError;

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getLoginError() {
		return loginError;
	}

}
