package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static consts.Constants.*;

public class DriverFactory {

    private static WebDriver driver;

//    private static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
//    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
//
//    private static final String FIREFOX_PATH = "D:\\EpamTestAutomtion1\\src\\main\\resources\\geckodriver.exe";
//    private static final String CHROME_PATH = "D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe";
//
//    private static final int IMPLICITY_WAIT_VALUE = 10;

//    private static final String BASE_URL = "https://training.by";
//    private static final String HOME_PAGE_URL = BASE_URL + "/#/Home";

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
