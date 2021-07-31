package po;

import org.openqa.selenium.By;

import java.util.logging.Logger;

public class HomePage extends AbstractPage {
    private static final Logger LOG = Logger.getLogger(HomePage.class);
    private By signInButton = By.xpath("");
    private By topRightCornerUserNameElement = By.xpath("");

    public HomePage clickSignInButton(){
        getElement(signInButton).click;
        LOG.info("'Sign In' button clicked")
        return new SignInPage();

    }

    public HomePage proceedToHomePage(){
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Procceded to '%s' URL.", HOME_PAGE_URL));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getLoggedInUserName(){return getElement(topRightCornerUserNameElement).getText();}

    //public TrainingListPage openTrain



    public HomePage login(String email, String password){

        return this;
    }

    public HomePage verifyRightUserNameDisplayed(String name){
        return this;
    }

}
