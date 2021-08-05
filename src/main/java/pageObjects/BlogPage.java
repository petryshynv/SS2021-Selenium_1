package pageObjects;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class BlogPage extends AbstractPage {

    SoftAssert softAssert = new SoftAssert();


    private static final Logger LOG = Logger.getLogger(String.valueOf(BlogPage.class));

    private final By hrefToBlogPage = By.xpath("//ul[@class='main-nav__list']//a[@href='/#!/News']");

    private final By buttonNews = By.xpath("//a[@href='#!/News/Category/news']");
    private final By buttonRealStories = By.xpath("//a[@href='#!/News/Category/real-stories']");
    private final By buttonMaterials = By.xpath("//a[@href='#!/News/Category/materials']");
    private final By buttonHardSkills = By.xpath("//a[@href='#!/News/Category/hard-skills']");
    private final By buttonSoftSkills = By.xpath("//a[@href='#!/News/Category/soft-skills']");
    private final By buttonEvents = By.xpath("//a[@href='#!/News/Category/events']");


    public BlogPage proceedBlogPage() {
        getElement(hrefToBlogPage).click();
        LOG.info("Proceeded to link 'Blog'");
        return new BlogPage();
    }

    public BlogPage verifyLinkNewsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonNews);
        softAssert.assertTrue(isDisplayed, "Link 'News' is not visible");
        LOG.info(String.format("Link 'News''%s'", isDisplayed));
        return this;
    }

    public BlogPage verifyLinkRealStoriesIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonRealStories);
        softAssert.assertTrue(isDisplayed, "Link 'Real Stories' is not visible");
        LOG.info(String.format("Link 'Real Stories' '%s'", isDisplayed));
        return this;
    }

    public BlogPage verifyLinkMaterialsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonMaterials);
        softAssert.assertTrue(isDisplayed, "Link 'Materials' is not visible");
        LOG.info(String.format("Link 'Materials' '%s'", isDisplayed));
        return this;
    }

    public BlogPage verifyLinkHardSkillsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonHardSkills);
        softAssert.assertTrue(isDisplayed, "Link 'HardSkills' is not visible");
        LOG.info(String.format("Link 'HardSkills' '%s'", isDisplayed));
        return this;
    }

    public BlogPage verifyLinkSoftSkillsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonSoftSkills);
        softAssert.assertTrue(isDisplayed, "Link 'SoftSkills' is not visible");
        LOG.info(String.format("Link 'SoftSkills' '%s'", isDisplayed));
        return this;
    }

    public BlogPage verifyLinkEventsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonEvents);
        softAssert.assertTrue(isDisplayed, "Link 'Events' is not visible");
        LOG.info(String.format("Link 'Events' '%s'", isDisplayed));
        return this;
    }

    public BlogPage areLinksDisplayedSoftAssert() {
        verifyLinkEventsIsDisplayed();
        verifyLinkNewsIsDisplayed();
        verifyLinkMaterialsIsDisplayed();
        verifyLinkHardSkillsIsDisplayed();
        verifyLinkSoftSkillsIsDisplayed();
        verifyLinkRealStoriesIsDisplayed();
        softAssert.assertAll("All links are visible");
        return this;
    }
}


