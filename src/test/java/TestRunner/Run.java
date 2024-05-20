package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(

		//features = {".//Features/Customers.feature",".//Features/OpenPage.feature"},
		//features = ".//Features/",
		features = {".//Features/OpenPage.feature"},
		//features = {".//Features/Customers.feature",".//Features/OpenPage.feature"},
		glue = "StepDefination",
		dryRun = false,
		monochrome = true,
		tags = "@sanity", // scenarios will be execute under sanity and regression
		//plugin = {"pretty","html:target/cucumberReports/reports_html.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

		)
//"json:target/cucumberReports/reports_json.json",
//"junit:target/cucumberReports/reports_xml.xml"

public class Run extends AbstractTestNGCucumberTests {

}
