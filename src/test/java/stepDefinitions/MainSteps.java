package stepDefinitions;

import Pages.Google;
import Utility.WebDriverFactory;
import configuration.Browser;
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

public class MainSteps{
    final private Google google = new Google(Browser.getDriverInstance());
    private long startTime, endTime, elapsedTime;

    @Given("user is on the google page")
    public void userIsOnTheGooglePage() {
        google.launchUrl();
    }

    @When("user enters {string} into search text field")
    public void userEntersSearchTextIntoSearchTextField(String searchText) {
        google.searchText(searchText);
    }

    @When("user press the return key")
    public void userPressTheReturnKey() {
        startTime = System.currentTimeMillis();
        google.pressReturnKey();
    }

    @Then("user get the results displayed within {int} milliseconds")
    public void userGetTheResultsDisplayedWithin1Second(int timeUnit) {
        google.getResults(timeUnit);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        Assert.assertTrue(elapsedTime <= timeUnit);
    }
}
