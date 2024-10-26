package runner;

import config.Browser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

@CucumberOptions(
	features="src/test/java/features",
	glue = "stepDefinitions",
	monochrome = true,
	plugin = {
			"pretty",
			"html:target/cucumber-reports.html"
	},
	tags = ""
)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		Browser.getDriver(browser);
	}

	@AfterTest
	public void tearDown() {
		Browser.getDriverInstance().quit();
	}
}
