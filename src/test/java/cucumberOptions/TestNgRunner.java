package cucumberOptions;

import Utility.WebDriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@CucumberOptions(features="src/test/java/features",
                 glue="stepDefinitions",
                 monochrome=true,
        plugin={"pretty", "html:target/cucumber-reports.html"},
        tags="@BasicTest"
)
public class TestNgRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser)
    {
      driver = WebDriverFactory.getDriver(browser);
      driver= WebDriverFactory.getdriverinstance();
        System.out.println("Before Setup");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quitDriver();  // Quit WebDriver instance after the test
    }

}
