package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.logging.Logger;

import static driver.DriverFactory.getDriver;

public class SignInPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(SignInPage.class));
    private final By mailInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("kc-login");
    private final By continueButton = By.id("kc-login-next");
    private final By loginFailedErrorMessage = By.xpath("//span[text()='We can't find user with such credentials.\"]");

    public SignInPage enterEmail(String email) {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered");
        return this;
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("'Continue' button clicked");
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered");
        return this;
    }

    public HomePage proceedToHomePagePortal() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new HomePage();
    }

    public void verifyContinueButtonIsEnable() {
        boolean enable = getElement(continueButton).isEnabled();
        LOG.info("'Continue' button is enable");
        Assert.assertTrue(enable, "'Continue' button is disable");
    }

    public void verifyContinueButtonIsDisable() {
        boolean enable = getElement(continueButton).isEnabled();
        LOG.info("'Continue' button is disable");
        Assert.assertFalse(enable, "'Continue' button is enable");
    }
}
