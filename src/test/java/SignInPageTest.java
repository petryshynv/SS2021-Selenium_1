import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import po.HomePage;
import po.SignInPage;

import java.util.concurrent.TimeUnit;

public class SignInPageTest extends BaseTest {
    private SignInPage signInPage;
    String email = null;
    String password = null;
    String name = null;


    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserSuccessfullyLoggedIn() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .login(email, password)
                .verifyRightUserNameDisplayed(name);


        System.setProperty("webdriver.chrome.driver", "D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua/#!/Home?City=4,5,639,2,655,3,675,682,276,1,644,626&lang=en");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("vitaliypetr84@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Sambir_Test_12");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(), "Username is NOT displayed");

        driver.quit();
    }

    @Test(description = "Verify user is NOT successfully logged in with incorrect password")
    public void verifyUserNotLoggedWithInvalidPassword() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .login(email, password);
        Assert.assertTrue
                (signInPage.verifyFailedLoginErrorMessageDisplayed(),
                        "'Login failed' error message is not displayed");
               // .verifyFailedLoginErrorMessageDisplayed();

        System.setProperty("webdriver.chrome.driver", "D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.epam.ua/#!/Home?City=4,5,639,2,655,3,675,682,276,1,644,626&lang=en");
        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys("vitaliypetr84@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("11111111");
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        boolean checkMessage = driver.getPageSource().contains("We can't find user with such credentials.");
        Assert.assertTrue(checkMessage, "Text not found!");

        driver.quit();
    }
}
