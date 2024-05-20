package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	//constructor
	
	public LoginPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//button[@class = 'button-1 login-button']")
	WebElement loginbtn;

	@FindBy(partialLinkText = "Logout")
	WebElement logout;

	public void enterEmail(String emailadd) {

		email.clear();
		email.sendKeys(emailadd);
	}

	public void enterPassword(String pwd) {

		password.clear();

		password.sendKeys(pwd);

	}

	public void ClickOnLoginButton() {

		loginbtn.click();
	}

	public void ClickOnLogoutButton() {

		logout.click();
	}
}
