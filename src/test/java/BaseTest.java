import driver.DriverFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public class BaseTest extends DriverFactory {
    private Logger LOG = Logger.getLogger(String.valueOf(BaseTest.class));
    private Test test;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        initDriver(Browsers.CHROME);

        LOG = Logger.getLogger(String.valueOf(method.getDeclaringClass()));
        test = method.getAnnotation(Test.class);
        LOG.info(String.format("Test '%s' started.", method.getName()));
        LOG.info(String.format("Description: '%s'.", test.description()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method){
        LOG.info(String.format("Test '%s' completed.", method.getName()));
        quitDriver();
    }

}
