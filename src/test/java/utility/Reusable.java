package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Reusable {

	private static WebDriverWait wait;
	final private static int seconds = 30;

	public static void waitClearAndSendKeys(WebDriver driver, By locator, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		element.clear();
		element.sendKeys(text);
	}

	public static List<WebElement> waitAndGetListOfElements(WebDriver driver, By locator, int timeUnit) {
		List<WebElement> list = null;
		try {
			wait = new WebDriverWait(driver, Duration.ofMillis(timeUnit));
			list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		} catch (Exception e) { System.out.println("Exception"); }

		return list;
	}
}
