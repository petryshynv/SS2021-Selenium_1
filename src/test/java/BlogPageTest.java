import org.testng.annotations.Test;
import pageObjects.BlogPage;
import pageObjects.HomePage;

import static consts.Constants.*;


public class BlogPageTest extends BaseTest {

    @Test(description = "Verify links on ‘Blog’ Page")
    public void verifyLinksOnBlogPageAreVisible() {

        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL)
                .clickContinueButton()
                .enterPassword(PASSWORD)
                .proceedToHomePagePortal();
        new BlogPage()
                .proceedBlogPage()
                .areLinksDisplayedSoftAssert();
    }
}
