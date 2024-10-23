package stepDefinitions;

import Utility.WebDriverFactory;
import cucumberOptions.TestNgRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MainSteps extends TestNgRunner {
    WebElement searchBox;
    WebDriverWait wait;

    @Given("User is on the google homepage with browser")
    public void userIsOnTheGoogleHomepageWithBrowser()  {
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
    }

    @When("User lands on the google homepage")
    public void userlandsonthegooglehomepage() {
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.sendKeys(Keys.RETURN);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @Then("User should get the list of elements which are loaded in One second")
    public void usershouldgetthelistofelementswhichareloadedinonesecond() {
        List<WebElement> searchResults = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("h3")));
        for (WebElement result : searchResults) {
            System.out.println("Search result: " + result.getText());
            Assert.assertTrue(result.getText().contains("WebDriver"));
        }
    }

}
