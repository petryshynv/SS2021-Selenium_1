import dataProviders.EmailValue;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static consts.Constants.*;


public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL)
                .clickContinueButton()
                .enterPassword(PASSWORD)
                .proceedToHomePagePortal();
        new HomePage()
                .isUserNameDisplayed();
    }

    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPassword() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL)
                .clickContinueButton()
                .enterPassword(INCORRECT_PASSWORD)
                .proceedToHomePagePortal()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(dataProvider = "notValidEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is disable")
    public void verifyLoginWithIncorrectEmail(String value) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(value)
                .verifyContinueButtonIsDisable();
    }

    @Test(dataProvider = "validEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is enable")
    public void verifyLoginWithValidEmail(String value) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(value)
                .verifyContinueButtonIsEnable();
    }
}
