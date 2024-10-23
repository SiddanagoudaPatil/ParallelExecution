package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    // ThreadLocal to manage WebDriver instances
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get WebDriver instance based on browser type
    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver.get();
    }

    // get Webdriver Instance
    public static WebDriver getdriverinstance() {
        return driver.get();
    }

    // Quit WebDriver instance
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();  // Remove WebDriver instance from ThreadLocal
        }
    }

}
