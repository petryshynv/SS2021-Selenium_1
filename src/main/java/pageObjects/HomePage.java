package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

import static consts.Constants.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));
    private final By signInButton = By.className("header-auth__signin");
    private final By topRightCornerUserNameElement = By.className("user-info__name");

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Procceded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public HomePage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign In' button clicked");
        return new HomePage();
    }

    public void isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        Assert.assertTrue(isDisplayed, "User name in top right corner is not visible");
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
    }
}
