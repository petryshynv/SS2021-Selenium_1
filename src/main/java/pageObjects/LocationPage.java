package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.logging.Logger;

public class LocationPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());

    private static final Logger LOG = Logger.getLogger(String.valueOf(LocationPage.class));

    private final By hrefToBlogPage = By.xpath("//ul[@class='main-nav__list']//a[@class='topNavItem news click hover'][normalize-space()='Blog']");

    private final By buttonNews = By.xpath("//a[*]//span[normalize-space()='NEWS']");
    private final By buttonRealStories = By.xpath("//span[normalize-space()='REAL STORIES']");
    private final By buttonMaterials = By.xpath("//a[*]//span[normalize-space()='MATERIALS']");
    private final By buttonHardSkills = By.xpath("//a[*]//span[normalize-space()='HARD SKILLS']");
    private final By buttonSoftSkills = By.xpath("//a[*]//span[normalize-space()='SOFT SKILLS']");
    private final By buttonEvents = By.xpath("//a[*]//span[normalize-space()='EVENTS']");


    public LocationPage proceedBlogPage() {
        getElement(hrefToBlogPage).click();
        LOG.info(String.format("Procceded to href 'Blog'"));
        return new LocationPage();
    }

    public void isLinksOfBlogIsDisplayed() {
        By[] blogsLocators = new By[6];
        blogsLocators[0] = buttonEvents;
        blogsLocators[1] = buttonSoftSkills;
        blogsLocators[2] = buttonHardSkills;
        blogsLocators[3] = buttonMaterials;
        blogsLocators[4] = buttonRealStories;
        blogsLocators[5] = buttonNews;
        for (By blogsLocator : blogsLocators) {
            boolean isDisplayed = isDisplayed(blogsLocator);
            Assert.assertTrue(isDisplayed, "Link is not visible");
            LOG.info(String.format("Link '%s'", isDisplayed));
        }
    }
}


