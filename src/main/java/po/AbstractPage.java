package po;

import driver.DriverFactory;
import org.openqa.selenium.*;


public class AbstractPage {

    // private static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        //TODO LOG
        //WebElement webElement.wait.
        return (WebElement) this;
    }

    // ask really need try/catch
    public boolean isDisplayed(By locator) {
        try {
            return DriverFactory
                    .getDriver()
                    .findElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
//
//    void proceedToPage(final String url)(DriverFactory.getDriver().findElements(locator));
//        }
