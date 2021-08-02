import consts.Constants;
import dataProviders.EmailValue;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainigPage;

import static consts.Constants.email;
import static consts.Constants.incorrecrPassword;


public class TrainingPageTest extends BaseTest {

    @Test(description = "Verify proceed to 'Trainings' page.")
    public void verifyUserProceedTrainingsPage() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(Constants.password)
                .clickSignInButton();
        new TrainigPage()
                .proceedTrainingPage()
                .isDirectionsOfTrainingIsDisplayed();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills’.")
    public void verifySearchOnTrainingsPage() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(Constants.password)
                .clickSignInButton();
        new TrainigPage()
                .proceedTrainingPage()
                .scrollSearchField()
                .clickSearchFieldAndClickBySkillsButton()
                .clickCheckBoxJava()
                .checkCoursesWithWordJava()
                .clickCheckBoxJRuby()
                .unClickCheckBoxJava()
                .checkNoAvailableMessage();

    }
}
