package base;

import utillties.driverutils.BrowserName;
import utillties.driverutils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    @BeforeMethod
    public void setUpDriver(){
        driver = DriverManager.getDriver();
    }
    @AfterMethod
    public void cleanUp(){
        //driver.quit();
    }

}
