package po;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class SignInPage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(SignInPage.class);
    private By mailInput = By.id("");
    private By passwordInput = By.id("");
    private By signInButton = By.className("");
    private By loginFailedErrorMessage = By.xpath("");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered");
        return this;
    }

    public SignInPage enterPassword(String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered");
        return this;
    }

    public HomePage clickSignInButton(){
        getElement(passwordInput).sendKeys(password);
        LOG.info("'Sign in' button clicked");
        return new HomePage();
    }



    public boolean verifyFailedLoginErrorMessageDisplayed(){
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed: '%s'", isDisplayed));
       return isDisplayed;
    }
}
