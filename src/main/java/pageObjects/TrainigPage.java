package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Collection;
import java.util.logging.Logger;

public class TrainigPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());

    private static final Logger LOG = Logger.getLogger(String.valueOf(TrainigPage.class));

    private final By searchFieldElement = By.name("training-filter-input");
    private final By trainingAreaElement = By.xpath("//h1[@class='section-ui__title ng-binding']");
    private final By trainingListElement = By.xpath("//nav[@class='main-nav']//a[@class='topNavItem training click hover']");

    private final By checkBoxJavaElement =
            By.xpath("//label[@class='location__not-active-label ng-binding'][normalize-space()='Java']//span[@class='checkmark']");
    private final By unChekBoxJavaButton =
            By.xpath("//label[@class='location__not-active-label ng-binding location__location-active-label'][normalize-space()='Java']//span[@class='checkmark']");
    private final By checkBoxRubyElement =
            By.xpath("//label[@class='location__not-active-label ng-binding'][normalize-space()='Ruby']//span[@class='checkmark']");

    private final By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding'][normalize-space()='By skills']");
    private final By directionsOfTrainingsElement = By.xpath("//div[@class='section-ui__title ng-binding']");
    private final By allJavaElements = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), 'Java')]");
    private final By messageNoAvailableTraining = By.xpath("//span[text()='No training are available.']");

    public TrainigPage proceedTrainingPage() {
        getElement(trainingListElement).click();
        LOG.info(String.format("Procceded to href 'Training List'"));
        return new TrainigPage();
    }

    public void isDirectionsOfTrainingIsDisplayed() {
        boolean isDisplayed = isDisplayed(directionsOfTrainingsElement);
        Assert.assertTrue(isDisplayed, "'Directions of trainings' is not visible");
        LOG.info(String.format("UDirections of trainings '%s'", isDisplayed));
    }

    public TrainigPage scrollSearchField() {
        actions.moveToElement(getElement(trainingAreaElement));
        LOG.info("to 'Search' field scrolled");
        return new TrainigPage();
    }

    public TrainigPage unClickCheckBoxJava() {
        actions.moveToElement(getElement(unChekBoxJavaButton));
        getElement(unChekBoxJavaButton).click();
        LOG.info("checkbox 'Java' field unClicked");
        return new TrainigPage();
    }

    public TrainigPage clickCheckBoxJava() {
        getElement(checkBoxJavaElement).click();
        LOG.info("checkbox 'Java' field clicked");
        return new TrainigPage();
    }

    public TrainigPage clickCheckBoxJRuby() {
        getElement(checkBoxRubyElement).click();
        LOG.info("checkbox 'Java' field clicked");
        return new TrainigPage();
    }

    public TrainigPage clickSearchFieldAndClickBySkillsButton() {
        getElement(searchFieldElement).click();
        getElement(bySkillsButton).click();
        LOG.info("'Search' field clicked");
        return new TrainigPage();
    }

    public TrainigPage checkCoursesWithWordJava() {
        getElements(allJavaElements);
        LOG.info("Found all courses with 'Java'");
        Assert.assertTrue(getElements(allJavaElements).size() > 0, "Java courses not found");
        return new TrainigPage();
    }

    public void checkNoAvailableMessage() {
        String getMessage = getElement(messageNoAvailableTraining).getText();
       Assert.assertEquals(getMessage, "No training are available.");
    }
}


