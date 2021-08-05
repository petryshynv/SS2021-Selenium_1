package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingPage;

public class TrainingListBO {
    private TrainingPage trainingPage;

    public TrainingListBO() {
        trainingPage = new TrainingPage();
    }

    public TrainingPage proceedToSearchgField() {
        trainingPage
                .proceedTrainingPage()
                .verifyTrainingPageDisplayed()
                .scrollSearchField()
                .clickIfButtonClearAllLocationsActive()
                .clickSearchFieldsButton();
        return new TrainingPage();
    }


}
