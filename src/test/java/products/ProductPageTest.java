package products;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class ProductPageTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeMethod
    void preValidation(){
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPge();
        productPage = loginPage.loginAsStandardUser();
        productPage.navigateToProductsPage();
        boolean isDisplayed = productPage.isRobotImageVisible();
        Assert.assertTrue(isDisplayed);

    }
    @Test
    void VerifyIfAllElementsArePresentInPrimaryHeader(){
        boolean logoVisible = productPage.isLogoVisible();
        boolean menuButtonVisible = productPage.isMenuButtonVisible();
        boolean cartButtonVisible = productPage.isMenuButtonVisible();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(logoVisible);
        softAssert.assertTrue(menuButtonVisible);
        softAssert.assertTrue(cartButtonVisible);
        softAssert.assertAll();
    }
    @Test
    void verifyIfAllElementsArePresentInSecondaryHeader(){
        boolean productTitleVisible = productPage.isProductTitleVisible();
        boolean robotImageVisible =  productPage.isRobotImageVisible();
        boolean sortingDropdownVisible = productPage.isSortingDropDownVisible();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(productTitleVisible);
        softAssert.assertTrue(robotImageVisible);
        softAssert.assertTrue(sortingDropdownVisible);
        softAssert.assertAll();
    }
    @Test
    void verifyIfCartIsUpdatedWithPassingNumbers() throws InterruptedException {
        ArrayList<Integer> productsToBeAddedToCart = new ArrayList<Integer>();
        productsToBeAddedToCart.add(1);
        productsToBeAddedToCart.add(2);
        productsToBeAddedToCart.add(6);
        productsToBeAddedToCart.add(3);
        productPage.addProductsToTheCart(productsToBeAddedToCart);


    }
}
