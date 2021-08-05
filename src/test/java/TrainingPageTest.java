import consts.NamesOfCourses;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.TrainingPage;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.SignInBO;
import pageObjects.businessObjects.TrainingListBO;

import static consts.BusinessConfigs.userInputs.*;
import static consts.LocationsCities.*;


public class TrainingPageTest extends BaseTest {

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’.")
    public void verifySearchOnTrainingsPageBySkills() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL.getInput())
                .clickContinueButton()
                .enterPassword(PASSWORD.getInput())
                .proceedToHomePagePortal();
        new TrainingPage()
                .proceedTrainingPage()
                .verifyTrainingPageDisplayed()
                .scrollSearchField()
                .clickSearchFieldsButton()
                .clickBySkillsButton()
                .clickCheckBoxJava(NamesOfCourses.JAVA.getCourse())
                .checkCoursesWithWordJava()
                .clickCheckBoxRuby(NamesOfCourses.RUBY.getCourse())
                .unClickCheckBoxByNameOfCourse(NamesOfCourses.JAVA.getCourse())
                .checkNoAvailableMessage();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifySearchOnTrainingsPageByLocations() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(EMAIL.getInput())
                .clickContinueButton()
                .enterPassword(PASSWORD.getInput())
                .proceedToHomePagePortal();
        new TrainingPage()
                .proceedTrainingPage()
                .verifyTrainingPageDisplayed()
                .scrollSearchField()
                .clickIfButtonClearAllLocationsActive()
                .clickSearchFieldsButton()
                .clickButtonLocationUkraine()
                .clickCheckBoxLocationLviv(LVIV.getCity())
                .areUkraineAndMultiLocationDisplayedSoftAssert();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’.")
    public void verifySearchOnTrainingsPageBySkillsWithBo() {
        new HomeBO()
                .proceedToSignPage();
        new SignInBO()
                .login(EMAIL.getInput(), PASSWORD.getInput());
        new TrainingListBO()
                .proceedToSearchgField()
                .clickBySkillsButton()
                .clickCheckBoxJava(NamesOfCourses.JAVA.getCourse())
                .checkCoursesWithWordJava()
                .clickCheckBoxRuby(NamesOfCourses.RUBY.getCourse())
                .unClickCheckBoxByNameOfCourse(NamesOfCourses.JAVA.getCourse())
                .checkNoAvailableMessage();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifySearchOnTrainingsPageByLocationsWithBo() {
        new HomeBO()
                .proceedToSignPage();
        new SignInBO()
                .login(EMAIL.getInput(), PASSWORD.getInput());
        new TrainingListBO()
                .proceedToSearchgField()
                .clickButtonLocationUkraine()
                .clickCheckBoxLocationLviv(LVIV.getCity())
                .areUkraineAndMultiLocationDisplayedSoftAssert();
    }
}
