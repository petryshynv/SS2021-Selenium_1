import consts.Constants;
import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainigPage;

import static consts.Constants.email;


public class BlogPageTest extends BaseTest {

    @Test(description = "Verify links on ‘Blog’ Page")
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
