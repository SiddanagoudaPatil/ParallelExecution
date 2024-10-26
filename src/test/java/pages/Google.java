package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Reusable;

import java.util.List;

public class Google {
	private WebDriver driver;
	private String url = "https://www.google.com";
	private By searchInput = By.name("q");
	private By results = By.cssSelector("#search > div > div > div:last-child");

	public Google(WebDriver driver) {
		this.driver = driver;
	}

	public void launchUrl() {
		driver.get(url);
	}

	public void searchText(String textToBeSearched) {
		Reusable.waitClearAndSendKeys(driver, searchInput, textToBeSearched);
	}

	public void pressReturnKey() {
		driver.findElement(searchInput).sendKeys(Keys.RETURN);
	}

	public List<WebElement> getResults(int timeUnit) {
		return Reusable.waitAndGetListOfElements(driver, results, timeUnit);
	}
}
