package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

public class TrainingPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());
    SoftAssert softAssert = new SoftAssert();

    private static final Logger LOG = Logger.getLogger(String.valueOf(TrainingPage.class));

    private final String unClickCheckBoxCourse =
            "//label[@class='location__not-active-label ng-binding location__location-active-label'][normalize-space()='%s']//span[@class='checkmark']";
    private final String chekBoxCoursesButton =
            "//label[@class='location__not-active-label ng-binding'][normalize-space()='%s']//span[@class='checkmark']";
    private final String buttonCheckBoxLviv =
            "//label[@class='location__not-active-label ng-binding'][normalize-space()='%s']//span[@class='checkmark']";

    private final By searchFieldElement = By.name("training-filter-input");
    private final By trainingAreaElement = By.xpath("//h1[@class='section-ui__title ng-binding']");
    private final By trainingListElement = By.xpath("//nav[@class='main-nav']//a[@class='topNavItem training click hover']");
    private final By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding'][normalize-space()='By skills']");
    private final By directionsOfTrainingsElement = By.xpath("//div[@class='section-ui__title ng-binding']");
    private final By allJavaCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[contains(text(), 'Java')]");
    private final By messageNoAvailableTraining = By.xpath("//span[text()='No training are available.']");
    private final By pageTrainingElement = By.xpath("//h1[@class='section-ui__title ng-binding']");
    private final By buttonClearAllLocations = By.xpath("//span[@class='filter-field__input-item-close-icon filter-field__input-item-close-icon--common']");
    private final By buttonLocationUkraine = By.xpath("//div[contains(text(),'Ukraine')]");
    private final By multiLocationElement = By.xpath
            ("//div[@class='training-list__container training-list__desktop']//div[@class='rd-tooltip-text training-item__location--text'][normalize-space()='Multi-location']");
    private final By ukraineLocationElement = By.xpath
            ("//div[@class='training-list__container training-list__desktop']//span[@class='training-item__location--text ng-binding ng-scope']");


    public TrainingPage proceedTrainingPage() {
        getElement(trainingListElement).click();
        LOG.info("Procceded to link 'Training List'");
        return new TrainingPage();
    }

    public void isDirectionsOfTrainingIsDisplayed() {
        boolean isDisplayed = isDisplayed(directionsOfTrainingsElement);
        Assert.assertTrue(isDisplayed, "'Directions of trainings' is not visible");
        LOG.info(String.format("UDirections of trainings '%s'", isDisplayed));
    }

    public TrainingPage scrollSearchField() {
        actions.moveToElement(getElement(trainingAreaElement));
        LOG.info("to 'Search' field scrolled");
        return new TrainingPage();
    }

    public TrainingPage clickCheckBoxJava(String course) {
        getElement(By.xpath(String.format(chekBoxCoursesButton, course))).click();
        LOG.info(String.format("checkbox '%s' field clicked", course));
        return new TrainingPage();
    }

    public TrainingPage clickCheckBoxRuby(String course) {
        getElement(By.xpath(String.format(chekBoxCoursesButton, course))).click();
        LOG.info(String.format("checkbox '%s' field clicked", course));
        return new TrainingPage();
    }

    public TrainingPage unClickCheckBoxByNameOfCourse(String course) {
        WebElement element = getElement(By.xpath(String.format(unClickCheckBoxCourse, course)));
        actions.moveToElement(element);
        element.click();
        LOG.info(String.format("checkbox '%s' field unClicked", course));
        return new TrainingPage();
    }

    public TrainingPage clickSearchFieldsButton() {
        getElement(searchFieldElement).click();
        LOG.info("'Search' field clicked");
        return new TrainingPage();
    }

    public TrainingPage clickBySkillsButton() {
        getElement(bySkillsButton).click();
        LOG.info("'Search' field clicked");
        return new TrainingPage();
    }

    public TrainingPage checkCoursesWithWordJava() {
        getElements(allJavaCourses);
        LOG.info("Found all courses with 'Java'");
        Assert.assertTrue
                (getElements(allJavaCourses).size() > 0, "Java courses not found");
        return new TrainingPage();
    }

    public void checkNoAvailableMessage() {
        String getMessage = getElement(messageNoAvailableTraining).getText();
        Assert.assertEquals(getMessage, "No training are available.");
    }

    public TrainingPage verifyTrainingPageDisplayed() {
        boolean isDisplayed = isDisplayed(pageTrainingElement);
        Assert.assertTrue(isDisplayed, "Training page is not displayed");
        LOG.info(String.format("Training page: '%s'", isDisplayed));
        return this;
    }

    public TrainingPage clickIfButtonClearAllLocationsActive() {
        WebElement checkIfButtonActive = getElement(buttonClearAllLocations);
        if (checkIfButtonActive.isEnabled()) {
            checkIfButtonActive.click();
        }
        LOG.info("'Selected locations' button is disable");
        return this;
    }

    public TrainingPage clickButtonLocationUkraine() {
        getElement(buttonLocationUkraine).click();
        LOG.info("'Ukraine' button is clicked");
        return this;
    }

    public TrainingPage clickCheckBoxLocationLviv(String city) {
        getElement(By.xpath(String.format(buttonCheckBoxLviv, city))).click();
        LOG.info(String.format("Checkbox '%s' is clicked", city));
        return this;
    }

    public TrainingPage verifyLocationUkraineDisplayed() {
        List<WebElement> ukraineLocation = getElements(ukraineLocationElement);
        softAssert.assertTrue
                (ukraineLocation.size() > 0, "Java courses not found");
        LOG.info(String.format("MultiLocation  is '%s'", ukraineLocation));
        return this;
    }

    public TrainingPage verifyMultiLocationDisplayed() {
        List<WebElement> multiLocation = getElements(multiLocationElement);
        softAssert.assertTrue
                (multiLocation.size() > 0, "Java courses not found");
        LOG.info(String.format("MultiLocation  is '%s'", multiLocation));
        return this;
    }

    public TrainingPage areUkraineAndMultiLocationDisplayedSoftAssert() {
        verifyMultiLocationDisplayed();
        verifyLocationUkraineDisplayed();
        softAssert.assertAll("Locations are not visible");
        return this;
    }


}


