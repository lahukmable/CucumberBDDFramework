package StepDefination;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.AddNewCustomerPgae;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

/* Child class of base class */
public class StepDef extends BaseClass{


	@Before("@sanity")
	public void setup1() 
	
	{
		
		readconfig = new ReadConfig();
		
		//initialize logger
		
		Log = LogManager.getLogger(StepDef.class);		
		System.out.println("setup1 method excueted");
		
		String browser = readconfig.getBrowser();
		
		switch (browser.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
			default:
				driver = null;
				break;
		
		}
		
		
		Log.info("setup1 excuted..");
		
		
	}

	
//	@Before("@Regression")
//	public void setup2() 
//	
//	{
//		System.out.println("setup2 regression method excueted");
//	    WebDriverManager.firefoxdriver().setup();
////		WebDriverManager.chromedriver().setup();
////		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		Log.info("setup2 excuted..");
//	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginpage = new LoginPage(driver);
		addnewcustomerpage = new AddNewCustomerPgae(driver);
		searchcustomerpg = new SearchCustomerPage(driver);
		Log.info("Chrome browser launched..");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {

		driver.get(url);
		Log.info("URL Opened..");
	}

	@When("User Enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String emailadd, String password) throws InterruptedException {

		Thread.sleep(2000);
		loginpage.enterEmail(emailadd);

		loginpage.enterPassword(password);
		Log.info("entered email and password..");

	}

	@When("Click on Login")
	public void click_on_login() {

		loginpage.ClickOnLoginButton();
		Log.info("clicked on login button..");
	}

	@SuppressWarnings("deprecation")
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			
			Log.warn("Test Passed : Login Feature : Page title matched..");

			Assert.assertTrue(true);

		} else {
			Log.warn("Test failed : Login Feature : Page title not matched..");

			Assert.assertTrue(false);
		}

		System.out.println(actualTitle);
	}

	@When("User click on Logout link")
	public void user_click_on_log_out_link() throws InterruptedException {

		Thread.sleep(3000);
		loginpage.ClickOnLogoutButton();
		Log.info("Clicked on logout button");
	}


/////// Add new Customer //////

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		

		String actualtiltle = addnewcustomerpage.getpagetitle();

		String expectedtitle = "Dashboard / nopCommerce administration";

		if (actualtiltle.equals(expectedtitle)) {
			
			Log.info("User can view Dashboard :Passed");

			Assert.assertTrue(true);
		} else

		{
			Log.info("User can view Dashboard :Failed");
			Assert.assertTrue(false);
			
		}

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		
		Thread.sleep(2000);

		addnewcustomerpage.clcikoncustomersmenu();
		
		Log.info("User clicked on customers Menu");

	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		
		Thread.sleep(3000);

		addnewcustomerpage.clickoncustomersmenuitem();
		Log.info("User clicked on customers Menu item");
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {

		Thread.sleep(1000);
		addnewcustomerpage.clickonAddnew();
		Log.info("Clicked on Add new button");
	}

	@Then("User can view add new customers page")
	public void user_can_view_add_new_customers_page() {

		String actualtiltle = addnewcustomerpage.getpagetitle();

		String expectedtitle = "Add a new customer / nopCommerce administration";

		if (actualtiltle.equals(expectedtitle)) {
			
			
			Log.info("User can view add new customers page:Passed");
			
			Assert.assertTrue(true);
		} else

		{
			Log.info("User can view add new customers page:Failed");
			Assert.assertTrue(false);
			
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		//addnewcustomerpage.enteremail("somesgkamble000@gmail.com");
		addnewcustomerpage.enteremail(genrateemailid() + "@gmail.com");
		addnewcustomerpage.enterpassword("test1");
		addnewcustomerpage.enterfirstname("lahudas");
		addnewcustomerpage.enterlastname("kamble");
		addnewcustomerpage.entergender("Male");
		addnewcustomerpage.enterdob("7/13/1988");
		addnewcustomerpage.entercompanyname("codestudio");
		addnewcustomerpage.enteradmincontent("Admincontent");
		addnewcustomerpage.entermanagerofvendor("Vendor 1");
		
		Log.info("User entered customer info");

	}

	@When("Click on saave button")
	public void click_on_saave_button() {

		addnewcustomerpage.clickonsave();
		Log.info("Clicked on save button");
	}

	@Then("User can view confirmation meassage {string}")
	public void user_can_view_confirmation_meassage(String Excpectedconfirmationmsg) throws InterruptedException {
		
		Thread.sleep(3000);

		String bodytext = driver.findElement(By.tagName("Body")).getText();

		if (bodytext.contains(Excpectedconfirmationmsg)) 
		{
			Log.info("User can view confirmation meassage");

			Assert.assertTrue(true);//pass
		} 
		
		else

		{
			Log.warn("User can view confirmation meassage:failed");
			Assert.assertTrue(false);//fail
		}
	}
	
	/// search customer  //
	
	@When("Enter Customer email")
	public void enter_customer_email() throws InterruptedException {
		
		Thread.sleep(2000);
	   
		searchcustomerpg.enteremailadd("victoria_victoria@nopCommerce.com");
		Log.info("Entered customer email");
	}
	@When("Click on search button")
	public void click_on_search_button() {
	  
		searchcustomerpg.clickonsearchbtn();
	}

	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() throws InterruptedException {
		
		Thread.sleep(2000);
	   
		String expectedemail = "victoria_victoria@nopCommerce.com";
		
		Assert.assertTrue(searchcustomerpg.searchcustomerbyemail(expectedemail));
	}
	
	// search customer by name//
	
	@When("Enter Customer Firstname")
	public void enter_customer_firstname() throws InterruptedException {
		
		Thread.sleep(2000);
		
		searchcustomerpg.enterfirstname("Victoria");
	   
	}

	@When("Enter Customer Lastname")
	public void enter_customer_lastname() {
	  
		searchcustomerpg.enterlastname("Terces");
	}

	@Then("User should found name in search table")
	public void user_should_found_name_in_search_table() throws InterruptedException {
		
		Thread.sleep(2000);
	   
		String expectedname= "Victoria Terces";
		
		//Assert.assertTrue(searchcustomerpg.searchcustomerbyname(expectedname));
		
		if(searchcustomerpg.searchcustomerbyname(expectedname) ==true) 
		{
			Assert.assertTrue(true);
			
		}else 
		{
			Assert.assertTrue(false);	
		}
	}


	//@After
	public void teardown1(Scenario sc)  
	
	{
		System.out.println("Tear down method executed");
		
		if(sc.isFailed()==true) {
			
			//covert webdriver object to Takescreenshot
			
			String Filewithpath = "C:\\Users\\User\\eclipse-workspace\\DemoProject\\Screenshot\\test.png";
			TakesScreenshot scrshot = ((TakesScreenshot)driver);
			
			//call getscreenshot method to create img file
			
			File Scrfile = scrshot.getScreenshotAs(OutputType.FILE);
			
			//Move img file to new distination
			
			File destfile = new File (Filewithpath);
			
			//copy file at destination
			
			try {
				FileUtils.copyFile(Scrfile, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		//driver.quit();
		
			
		}
	@AfterStep
	public void addScreenshot(Scenario scenario){
		
		if(scenario.isFailed()) {
			
		
		final byte[] scrennshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
		//attach image file report( date , media type , name of the attachment
		
		scenario.attach(scrennshot, "image/png", scenario.getName());
		}
	}
	
//	@After
//	public void teardown2() 
//	
//	{
//		System.out.println("Tear down method executed");
//		
//		driver.quit();
//		
//	}

	/*@BeforeStep
	public void Beforesetpmethoddemo() 
	{
		System.out.println("This is before step...");
	}
	
	@AfterStep
	public void aftersetpmethoddemo() 
	{
		System.out.println("This is after step...");
	}*/
}
