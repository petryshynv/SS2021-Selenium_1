import consts.Constants;
import driver.DriverFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class BaseTest extends DriverFactory {
    private Logger LOG = Logger.getLogger(BaseTest.class);
    private Test test;
    //todo what is it
    @Parameters({"broswerName"})
    @BeforeMethod(alwaysRun = true)
    public void bedoreMethod(@Optional(value = Constants.DriverConfigs.safsa) final String browserName, Method method){
        initDriver(browserName);
        LOG = Logger.getLogger(method.getDeclaringClass());
        test = method.getAnnotation(Test.class);
        LOG.info(String.format("Test '%s' started.", method.getName()));
        LOG.info(String.format("Description: '%s'.", test.description());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method){
        LOG.info(String.format("Test '%s' completed.", method.getName()));
        quitDriver();
    }

}
