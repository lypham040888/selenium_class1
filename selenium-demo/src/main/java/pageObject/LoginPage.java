package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	//public WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// locators
	By txtUser = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");

	// Action methods

	public void setUserName(String username) {
		getDriver().findElement(txtUser).sendKeys(username);
	}

	public void setPassword(String password) {
		getDriver().findElement(txtPassword).sendKeys(password);
	}

	public void clickLogin() {
		getDriver().findElement(btnLogin).click();
	}

}
