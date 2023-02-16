package utillties.driverutils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.ArrayList;

public final class SeleniumUtils {
    private WebDriver driver;
    public SeleniumUtils(WebDriver driverParam){
        this.driver = driverParam;
    }
    public void setCookie(String key,String value){
        Cookie cookie = new Cookie(key,value);
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
    public  void  setStorage(JavascriptExecutor js,String item,String value){
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])",item,value);
        driver.navigate().refresh();

    }

}
