package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

import static consts.BusinessConfigs.page.HOME_PAGE_URL;
import static driver.DriverFactory.getDriver;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(HomePage.class));
    private final By signInButton = By.className("header-auth__signin");
    private final By topRightCornerUserNameElement = By.className("user-info__name");

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getUrl());
        Assert.assertTrue(isDisplayed(signInButton));
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign In' button clicked");
        return new SignInPage();
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        Assert.assertTrue(isDisplayed, "User name in top right corner is not visible");
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public HomePage isFailedLoginErrorMessageDisplayed() {
        boolean checkMessage = getDriver().getPageSource().contains("We can't find user with such credentials.");
        LOG.info(String.format("Is 'Login Failed' error message displayed: '%s'", checkMessage));
        Assert.assertTrue(checkMessage, "'Login Failed' error message is not displayed");
        return new HomePage();
    }
}
