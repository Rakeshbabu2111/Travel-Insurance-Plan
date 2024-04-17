package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	// static variables to hold Webdriver instance and properties
	static WebDriver driver;
	static Properties p;

	

	// This method runs before all scenarios
	@Before
	public void setup() throws IOException {

		driver = BaseClass.initilizeBrowser();
		p = BaseClass.getProperties();
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();

	}
	
	

	// This method runs after all scenarios
	@After
	public void teardown() throws IOException, InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	

	// This method runs after each step in a scenario
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// This is for cucumber junit report
		if (!scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); // attach the screenshot to the scenario

		}else {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); // attach the screenshot to the scenario
		}

	}
}
