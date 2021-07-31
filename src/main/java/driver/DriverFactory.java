package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private WebDriver driver;

    private static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";

    private static final String FIREFOX_PATH = "D:\\EpamTestAutomtion1\\src\\main\\resources\\geckodriver.exe";
    private static final String CHROME_PATH = "D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe";

    public enum Browsers {
        FIREFOX, CHROME
    }

    private WebDriver createDriver(Browsers browser) {

        switch (browser) {
            case CHROME:
                System.setProperty(CHROME_PROPERTY, CHROME_PATH);
                return driver = new ChromeDriver();
            break;
            case FIREFOX:
                System.setProperty(FIREFOX_PROPERTY, FIREFOX_PATH);
                return driver = new FirefoxDriver();
            break;
            default:
                return this.driver = null;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
