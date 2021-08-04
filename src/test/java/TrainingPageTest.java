import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingPage;

import static consts.Constants.*;


public class TrainingPageTest extends BaseTest {

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’.")
    public void verifySearchOnTrainingsPageBySkills() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL)
                .clickContinueButton()
                .enterPassword(PASSWORD)
                .proceedToHomePagePortal();
        new TrainingPage()
                .proceedTrainingPage()
                .isTrainingPageDisplayed()
                .scrollSearchField()
                .clickSearchFieldsButton()
                .clickBySkillsButton()
                .clickCheckBoxJava()
                .checkCoursesWithWordJava()
                .clickCheckBoxRuby()
                .unClickCheckBoxByNameOfCourse()
                .checkNoAvailableMessage();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifySearchOnTrainingsPageByLocations() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL)
                .clickContinueButton()
                .enterPassword(PASSWORD)
                .proceedToHomePagePortal();
        new TrainingPage()
                .proceedTrainingPage()
                .isTrainingPageDisplayed()
                .scrollSearchField()
                .clickIfButtonClearAllLocationsActive()
                .clickSearchFieldsButton()
                .clickButtonLocationUkraine()
                .clickCheckBoxLocationLviv()
                .areUkraineAndMultiLocationDisplayedSoftAssert()
        ;
    }
}
