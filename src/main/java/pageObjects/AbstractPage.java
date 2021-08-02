package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AbstractPage {

    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        return DriverFactory.getDriver().findElement(locator);
    }

    List<WebElement> getElements(By locator){
        return DriverFactory.getDriver().findElements(locator);
    }

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
