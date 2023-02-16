package pages;

import utillties.driverutils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver DRIVER;

    public LoginPage(WebDriver driverParam) {
       this.DRIVER = driverParam;
    }
    //Locators

    private final By USERNAME_TEXTBOX = By.id("user-name");
    private final By PASSWORD_TEXTBOX = By.id("password");
    private final By Login_BUTTON = By.id("login-button");
    private final By LOGO_IMAGE  = By.cssSelector(".bot_column");
    private final By ROBOT_IMAGE = By.cssSelector(".login_logo");

    private final By VALIDATION_Error_MSG = By.xpath("//h3[@data-test='error']");

    public LoginPage navigateToLoginPge(){
        String loginUrl= "https://www.saucedemo.com/";
        System.out.println("navigate to login page");
        DRIVER.get(loginUrl);
        return this;
    }
    public ProductPage loginASUser(String userRole){

       // Date date = new Date("2022-11-17T20:00:42.000Z");
      //  Cookie cookie = new Cookie("session-username",userRole);
       // DRIVER.manage().addCookie(cookie);
        SeleniumUtils seleniumUtils = new SeleniumUtils(DRIVER);
        seleniumUtils.setCookie("session-username",userRole);
        return new ProductPage(DRIVER);
    }
    public ProductPage loginAsStandardUser(){
         loginASUser("standard_user");
        return new ProductPage(DRIVER);
    }
    public String getValidationErrorMessage(){
        return DRIVER.findElement(VALIDATION_Error_MSG).getText();
    }
    public LoginPage enterUsername(String username){
        System.out.println("Enter username");
        DRIVER.findElement(USERNAME_TEXTBOX).sendKeys(username);
        return this;
    }
    public LoginPage enterPassword(String password){
        System.out.println("Enter Password");
        DRIVER.findElement(PASSWORD_TEXTBOX).sendKeys(password);
        return this;
    }
    public ProductPage clickLoginButton(){
        System.out.println("Click on login button");
        DRIVER.findElement(Login_BUTTON).click();
        return new ProductPage(DRIVER);
    }
    public ProductPage loginASUser(String username,String password){
        enterUsername(username);
        enterPassword(password);
        ProductPage proPage = clickLoginButton();
        return proPage;
    }
    public boolean isLogoVisible(){
        System.out.println("check for logo visibility");
        return DRIVER.findElement(LOGO_IMAGE).isDisplayed();
    }
    public boolean isRobotImageVisible(){
        System.out.println("check for robot image visibility");
        return DRIVER.findElement(ROBOT_IMAGE).isDisplayed();
    }






}
