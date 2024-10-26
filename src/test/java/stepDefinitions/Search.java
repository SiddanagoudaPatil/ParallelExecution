package stepDefinitions;

import config.Browser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Google;
import utility.Reusable;

public class Search {

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
