import dataProviders.EmailValue;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;

import static consts.BusinessConfigs.userInputs.*;


public class SignInPageTest extends BaseTest {

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL.getInput())
                .clickContinueButton()
                .enterPassword(PASSWORD.getInput())
                .proceedToHomePagePortal();
        new HomePage()
                .isUserNameDisplayed();
    }

    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPassword() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL.getInput())
                .clickContinueButton()
                .enterPassword(INCORRECT_PASSWORD.getInput())
                .proceedToHomePagePortal()
                .isFailedLoginErrorMessageDisplayed();
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

    //TODO ASK AND DELETE
    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPasswordWithBo() {
        new HomeBO()
                .proceedToSignPage();
        new SignInBO()
                .login(EMAIL.getInput(), INCORRECT_PASSWORD.getInput());
        new SignInBO()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedInWithBo() {
        new HomeBO()
                .proceedToSignPage();
        new SignInBO()
                .login(EMAIL.getInput(), PASSWORD.getInput());
        new HomeBO()
                .verifyUserNameDisplayed();
    }

    @Test(dataProvider = "notValidEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is disable")
    public void verifyLoginWithIncorrectEmailWithBo(String value) {
        new HomeBO()
                .proceedToSignPage()
                .enterEmail(value)
                .verifyContinueButtonIsDisable();
    }

    @Test(dataProvider = "validEmails", dataProviderClass = EmailValue.class, description = "Verify Continue button on ‘Sign In’ window is enable")
    public void verifyLoginWithValidEmailWithBo(String value) {
        new HomeBO()
                .proceedToSignPage()
                .enterEmail(value)
                .verifyContinueButtonIsEnable();
    }
}
