package utillties.driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utillties.ConfigurationManager;

public class DriverManager {

    private DriverManager(){}
    private static final String BROWSER_NAME= ConfigurationManager.BROWSER_NAME;

    public static WebDriver getDriver(){
        WebDriver driver = null;
        if(BROWSER_NAME.toString().equalsIgnoreCase(BrowserName.CHROME.toString())){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if(BROWSER_NAME.toString().equalsIgnoreCase(BrowserName.EDGE.toString())){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(BROWSER_NAME.toString().equalsIgnoreCase(BrowserName.FIREFOX.toString())){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else{
            System.out.println("Invalid browser name selected");
        }

        return driver;


    }
}
