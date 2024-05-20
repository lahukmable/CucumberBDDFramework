package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPgae {

	public WebDriver ldriver;

	// Constructor

	public AddNewCustomerPgae(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	// Find Web elements on the web page

	@FindBy(xpath = "//a[@href = '#' ] //p[contains(text( ) , 'Customers')]")

	WebElement incustomers_menu;

	@FindBy(xpath = "//a[@href = '/Admin/Customer/List'] //p[contains(text( ) , 'Customers')]")

	WebElement incustomers_menuitems;

	@FindBy(xpath = "//a [@class = 'btn btn-primary']")

	WebElement btnaddnew;

	@FindBy(xpath = "//input[@id = 'Email']")

	WebElement txtEmail;

	@FindBy(xpath = "//input[@id = 'Password']")

	WebElement txtpassword;

	@FindBy(xpath = "//div [@class = 'k-multiselect-wrap k-floatwrap']")

	WebElement txtCUstomersRoles;

	@FindBy(xpath = "//li[contains ( text( ) , 'Administrators')]")

	WebElement listitemAdministrators;

	@FindBy(xpath = "//li[contains ( text( ) , 'Registered')]")

	WebElement listitemRegistered;

	@FindBy(xpath = "//li[contains ( text( ) , 'Guests')]")

	WebElement listitemGuests;

	@FindBy(xpath = "//li[contains ( text( ) , 'Guests')]")

	WebElement listitemVendors;

	@FindBy(xpath = "//*[@id = 'VendorId']")

	WebElement dropdownvendormgr;

	@FindBy(id = "Gender_Male")
	WebElement MaleGender;

	@FindBy(id = "Gender_Female")
	WebElement FemaleGender;

	@FindBy(xpath = "// input[@id = 'FirstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "// input[@id = 'LastName']")
	WebElement txtLastName;

	@FindBy(xpath = "// input[@id = 'DateOfBirth']")
	WebElement txtDOB;

	@FindBy(xpath = "// input[@id = 'Company']")
	WebElement txtCompanyname;

	@FindBy(xpath = "// textarea[@id = 'AdminComment']")
	WebElement txtAdminComment;

	@FindBy(xpath = "//button[@name = 'save']")
	WebElement txtbuttonsave;

	// Action Methods for web element

	public String getpagetitle() {

		return ldriver.getTitle();

	}

	public void clcikoncustomersmenu() {

		incustomers_menu.click();

	}

	public void clickoncustomersmenuitem() {

		incustomers_menuitems.click();
	}

	public void clickonAddnew() {

		btnaddnew.click();
	}

	public void enteremail(String email) {

		txtEmail.sendKeys(email);
		
	}

	public void enterpassword(String password) {

		txtpassword.sendKeys(password);
	}

	public void enterfirstname(String firstname) {

		txtFirstName.sendKeys(firstname);
	}

	public void enterlastname(String lastname) {

		txtLastName.sendKeys(lastname);
	}

	public void enterdob(String DOB) {

		txtDOB.sendKeys(DOB);
	}

	public void entercompanyname(String companyname) {

		txtCompanyname.sendKeys(companyname);
	}

	public void enteradmincontent(String content) {

		txtAdminComment.sendKeys(content);
	}

	public void entermanagerofvendor(String value) {
     	
     	Select drp = new Select(dropdownvendormgr);
     			
     			drp.selectByVisibleText(value);
     }

	public void entergender(String gender) {

		if (gender.equals("Male")) {

			MaleGender.click();
		} else {

			if (gender.equals("Female")) {

				FemaleGender.click();
			} else// default set male gender
			{
				MaleGender.click();
			}
		}
	}

	public void clickonsave() {

		txtbuttonsave.click();
	}
}
