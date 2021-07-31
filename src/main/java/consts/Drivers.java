package consts;

public enum Drivers {
    CHROME_NAME
            ("webdriver.chrome.driver",
                    "D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe",
                    10);
//    CHROME_DRIVER_LOCATION("D:\\EpamTestAutomtion1\\src\\main\\resources\\chromedriver.exe"),
//    IMPLICITY_WAIT_VALUE(10);

    private String driverAdress;
    private String driverLocation;
    private int imlicityWaitValue;

    Drivers(String driver, String adress, int time) {
        this.driverAdress=driver;
        this.driverLocation=adress;
        this.imlicityWaitValue=time;

    }
}
