package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static consts.Constants.*;

public class DriverFactory {

    private static WebDriver driver;

    public enum Browsers {
        FIREFOX, CHROME
    }

    private WebDriver createDriver(Browsers browser) {
        switch (browser) {
            case CHROME:
                System.setProperty(CHROME_PROPERTY, CHROME_PATH);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(FIREFOX_PROPERTY, FIREFOX_PATH);
                driver = new FirefoxDriver();
                break;
            default:
                this.driver = null;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT_VALUE, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void initDriver(Browsers browser) {
        if (this.driver == null) {
            createDriver(browser);
        }
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
