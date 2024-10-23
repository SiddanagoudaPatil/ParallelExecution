package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public WebDriverWait Webdriverwait(WebDriver driver)
    {
        WebDriverWait wait;
        return wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


}
