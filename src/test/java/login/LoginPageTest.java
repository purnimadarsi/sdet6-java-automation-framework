package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;
    private LoginPageTest(){

    }
    @BeforeMethod
    void preValidation(){
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPge();
        boolean isDisplayed = loginPage.isRobotImageVisible();
        Assert.assertTrue(isDisplayed);
    }
    @Test
    public void verifyLogoAndRobotImageVisibility(){
        boolean isLogoVisible = loginPage.isLogoVisible();
        boolean isRobotImageVisible =loginPage.isRobotImageVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isLogoVisible);
        softAssert.assertTrue(isRobotImageVisible);
        softAssert.assertAll();
    }
    @Test(groups={"sanity"})
    public void verifyUserIsAbleToLoginSuccessfullyUsingValidCredentials(String username, String password){
        boolean productTitleVisible = loginPage.loginASUser(username,password).isProductTitleVisible();
        Assert.assertTrue(productTitleVisible);

    }
    @Test(groups={"sanity"})
    public void verifyValidErrorMessageIsDisplayedForInvalidCredentials(String username,String password){
        loginPage.loginASUser(username,password);
        String expectedValidationErrorMessage = "";
        String ActualValidationErrorMessage = loginPage.getValidationErrorMessage();
        Assert.assertEquals(expectedValidationErrorMessage,ActualValidationErrorMessage);



    }
}
