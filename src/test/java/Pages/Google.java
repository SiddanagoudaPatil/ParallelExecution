package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import Utility.ReUsable;

public class Google {
    final private WebDriver driver;
    final private String url = "https://www.google.com";
    final private By searchInput = By.name("q");
    final private By results = By.cssSelector("#search > div > div > div:last-child");

    public Google(WebDriver driver) {
        this.driver = driver;
    }

    public void launchUrl() {
        driver.get(url);
    }

    public void searchText(String textToBeSearched) {
        ReUsable.waitClearAndSendKeys(driver, searchInput, textToBeSearched);
    }

    public void pressReturnKey() {
        driver.findElement(searchInput).sendKeys(Keys.RETURN);
    }

    public void getResults(int timeUnit) {
        ReUsable.waitAndGetListOfElements(driver, results, timeUnit);
    }
}
