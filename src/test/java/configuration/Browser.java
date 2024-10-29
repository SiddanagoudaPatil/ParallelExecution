package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

    final private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void getDriver(String browser) {
        if (driver.get() == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
    }

    public static WebDriver getDriverInstance() {
        return driver.get();
    }

}
