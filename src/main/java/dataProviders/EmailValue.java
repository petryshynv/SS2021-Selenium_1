package dataProviders;

import org.testng.annotations.DataProvider;

public class EmailValue {

    @DataProvider(name = "notValidEmails")
    public static Object[][] notValidEmails() {
        return new Object[][]{
                {"qazwsx.net"},
                {"@qazwsx.net"},
                {"qaz@wsxnet"},
                {"qazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqa@wsxnet"},
                {"qazwsx@wsx.n"}
        };
    }

    @DataProvider(name = "validEmails")
    public static Object[][] validEmails() {
        return new Object[][]{
                {"qazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqaza@wsx.net"},
                {"azqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqazqazqazqqaza@wsx.net"},
                {"qazwsx@wsx.nt"},
                {"qazwsx@wsx.net"},
                {"qazwsx@wsx.netnetnet"},
                {"qazwsx@wsx.netnetnett"}
        };
    }
}

