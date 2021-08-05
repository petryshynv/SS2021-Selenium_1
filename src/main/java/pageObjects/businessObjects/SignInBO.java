package pageObjects.businessObjects;

import consts.BusinessConfigs;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static consts.BusinessConfigs.userInputs.*;

public class SignInBO {
    private SignInPage signInPage;

    public SignInBO() {
        signInPage = new SignInPage();
    }

    public HomePage login(String mail, String password) {
        signInPage.enterEmail(mail)
                .clickContinueButton()
                .enterPassword(password)
                .proceedToHomePagePortal();
        return new HomePage();
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(signInPage.isFailedLoginErrorMessageDisplayed(),
                "'Login Failed' error message is not displayed");

    }


}
