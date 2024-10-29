package cucumberOptions;

import configuration.Browser;
import Utility.WebDriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@CucumberOptions(features="src/test/java/features",
                 glue="stepDefinitions",
                 monochrome=true,
        plugin={"pretty",
                "html:target/cucumber-reports.html"},
        tags="@BasicTest"
)
public class TestNgRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser)
    {
        Browser.getDriver(browser);
        System.out.println("Before Setup");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        Browser.getDriverInstance().quit();  // Quit WebDriver instance after the test
    }

}
