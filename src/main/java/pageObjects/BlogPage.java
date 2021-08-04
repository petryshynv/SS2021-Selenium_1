package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class BlogPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());
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
        LOG.info(String.format("Procceded to href 'Blog'"));
        return new BlogPage();
    }

    public BlogPage isLinkNewsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonNews);
        softAssert.assertTrue(isDisplayed, "Link 'News' is not visible");
        LOG.info(String.format("Link 'News''%s'", isDisplayed));
        return this;
    }

    public BlogPage isLinkRealStoriesIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonRealStories);
        softAssert.assertTrue(isDisplayed, "Link 'Real Stories' is not visible");
        LOG.info(String.format("Link 'Real Stories' '%s'", isDisplayed));
        return this;
    }

    public BlogPage isLinkMaterialsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonMaterials);
        softAssert.assertTrue(isDisplayed, "Link 'Materials' is not visible");
        LOG.info(String.format("Link 'Materials' '%s'", isDisplayed));
        return this;
    }

    public BlogPage isLinkHardSkillsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonHardSkills);
        softAssert.assertTrue(isDisplayed, "Link 'HardSkills' is not visible");
        LOG.info(String.format("Link 'HardSkills' '%s'", isDisplayed));
        return this;
    }

    public BlogPage isLinkSoftSkillsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonSoftSkills);
        softAssert.assertTrue(isDisplayed, "Link 'SoftSkills' is not visible");
        LOG.info(String.format("Link 'SoftSkills' '%s'", isDisplayed));
        return this;
    }

    public BlogPage isLinkEventsIsDisplayed() {
        boolean isDisplayed = isDisplayed(buttonEvents);
        softAssert.assertTrue(isDisplayed, "Link 'Events' is not visible");
        LOG.info(String.format("Link 'Events' '%s'", isDisplayed));
        return this;
    }

    public BlogPage areLinksDisplayedSoftAssert() {
        softAssert.assertAll("All links are visible");
        return this;
    }


}


