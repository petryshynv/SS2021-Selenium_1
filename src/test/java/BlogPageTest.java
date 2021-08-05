import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;

import static consts.BusinessConfigs.userInputs.*;


public class BlogPageTest extends BaseTest {

    @Test(description = "Verify links on ‘Blog’ Page")
    public void verifyLinksOnBlogPageAreVisible() {

        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL.getInput())
                .clickContinueButton()
                .enterPassword(PASSWORD.getInput())
                .proceedToHomePagePortal();
        new BlogPage()
                .proceedBlogPage()
                .areLinksDisplayedSoftAssert();
    }
}
