package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	public WebDriver ldriver;

	// Constructor

	public SearchCustomerPage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "SearchEmail")

	WebElement emailid;

	@FindBy(id = "search-customers")

	WebElement searchbtn;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchresult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tablerows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tablecoloumns;
	
	@FindBy(id= "SearchFirstName")
	WebElement firstname;
	
	@FindBy(id= "SearchLastName")
	WebElement lastname;

	// action methods click on enter email address

	public void enteremailadd(String email) {

		emailid.sendKeys(email);
	}

	public void clickonsearchbtn() {

		searchbtn.click();
	}

	public boolean searchcustomerbyemail(String email) {

		boolean found = false;

		// total no of rows

		int totalrows = tablerows.size();

		// total no of columns

		//int totalcolumns = tablecoloumns.size();

		for (int i = 1; i<= totalrows; i++) // to iterate all the rows of the grid

		{
			WebElement webelementemail = ldriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));

			String actualemaild = webelementemail.getText();

			if (actualemaild.equals(email)) {
				
				found = true;

			}

		}
		return found;
	}
	
	public void enterfirstname(String firstnametext) {

		firstname.sendKeys(firstnametext);
	}
	
	public void enterlastname(String lastnametext) {

		lastname.sendKeys(lastnametext);
	}
	
	public boolean searchcustomerbyname(String name) {

		boolean found = false;

		// total no of rows

		int totalrows = tablerows.size();

		// total no of columns

		//int totalcolumns = tablecoloumns.size();

		for (int i = 1; i<= totalrows; i++) // to iterate all the rows of the grid

		{
			WebElement webelementname = ldriver
					.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));

			String actulaname = webelementname.getText();

			if (actulaname.equals(name)) {
				
				found = true;

			}

		}
		return found;
}
}