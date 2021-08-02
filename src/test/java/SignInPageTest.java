import consts.Constants;
import dataProviders.EmailValue;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static consts.Constants.email;
import static consts.Constants.incorrecrPassword;


public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(Constants.password)
                .clickSignInButton();
        new HomePage()
                .isUserNameDisplayed();
    }

    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPassword() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(incorrecrPassword)
                .clickSignInButton()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(dataProvider = "notValidEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is disable")
    public void verifyLoginWithIncorrectEmail(String value) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(value)
                .verifyContinueButtonIsDisable();
    }

    @Test(dataProvider = "validEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is enable")
    public void verifyLoginWithValidEmail(String value) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(value)
                .verifyContinueButtonIsEnable();
    }

}
