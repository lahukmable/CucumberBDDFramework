package StepDefination;



import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPgae;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;


/* Parent Class */
public class BaseClass {


	public static  WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPgae addnewcustomerpage;
	public SearchCustomerPage searchcustomerpg;
	public static Logger Log;
	public ReadConfig readconfig;

	// generate unique email id //
	public String genrateemailid() 

	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
