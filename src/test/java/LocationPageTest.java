import consts.Constants;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import static consts.Constants.email;


public class LocationPageTest extends BaseTest {

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’")
    public void verifyUserProceedBlogPage() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(Constants.password)
                .clickSignInButton();
        new BlogPage()
                .proceedBlogPage()
                .isLinksOfBlogIsDisplayed();
    }
}
