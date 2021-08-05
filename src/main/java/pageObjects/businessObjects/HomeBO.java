package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class HomeBO {
    private HomePage homePage;

    public HomeBO() {
        homePage = new HomePage();
    }

    public SignInPage proceedToSignPage() {
        homePage.proceedToHomePage()
                .clickSignInButton();
        return new SignInPage();
    }

    public void verifyUserNameDisplayed() {
        Assert.assertTrue(homePage.isUserNameDisplayed(),
                "User name in top right corner is not visible");

    }

}
