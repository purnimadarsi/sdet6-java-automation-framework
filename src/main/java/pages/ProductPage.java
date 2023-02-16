package pages;

import utillties.driverutils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductPage {
    private  final WebDriver DRIVER ;


    public ProductPage(WebDriver driverParam) {
        DRIVER = driverParam;
    }
    private final By logoImage = By.cssSelector(".app_logo");
    private final By productHeaderText = By.xpath("//div[@class='header_secondary_container']/span");
    private final By burgerMenuButton = By.id("react-burger-menu-btn");

    private final By cartButton = By.cssSelector(".shopping_cart_link");
    private final By robotImage = By.cssSelector(".peek");
    private final By sortingDropDown = By.cssSelector(".product_sort_container");
    private final By addToCartButtonBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private final By ProductPriceBackPack = By.xpath("//div[@class='pricebar']//child::div[normalize-space()='$29.99']");

     public ProductPage navigateToProductsPage(){
            System.out.println("navigate to product page");
            String productPageUrl = "https://www.saucedemo.com/inventory.html";
            DRIVER.get(productPageUrl);
            return this;

    }
    public boolean isProductTitleVisible(){
        System.out.println("check for product title visibility");
        return DRIVER.findElement(productHeaderText).isDisplayed();
    }
    public boolean isLogoVisible(){
        System.out.println("check for logo visibility");
        return DRIVER.findElement(logoImage).isDisplayed();
    }
    public boolean isRobotImageVisible(){
        System.out.println("check for robot image visibility");
        return DRIVER.findElement(robotImage).isDisplayed();
    }
    public boolean isMenuButtonVisible(){
        System.out.println("check for menu button");
        return DRIVER.findElement(burgerMenuButton).isDisplayed();
    }
    public boolean isSortingDropDownVisible(){
         return DRIVER.findElement(sortingDropDown).isDisplayed();
    }
    public boolean isCartButtonVisible()
    {
        return DRIVER.findElement(cartButton).isDisplayed();

    }
    public void addProductsToTheCart(ArrayList<Integer> productList) {
        HashMap<Integer, Integer> product_Index = new HashMap<>();
        product_Index.put(1, 4);
        product_Index.put(2, 0);
        product_Index.put(3, 1);
        product_Index.put(4, 5);
        product_Index.put(5, 2);
        product_Index.put(6, 3);

        String item = "cart-contents";
        String value = "[";
        int productList_Size = productList.size();
        for (int i = 0; i < productList.size(); i++) {
            if (productList_Size == i + 1) {
                value += product_Index.get(productList.get(i));

            } else {
                value += product_Index.get(productList.get(i)) + ",";
            }
        }

        value += "]";
        System.out.println("Value= " + value);
        JavascriptExecutor js = (JavascriptExecutor) (DRIVER);
        SeleniumUtils seleniumUtils = new SeleniumUtils(DRIVER);
        seleniumUtils.setStorage(js, item, value);
    }
        //js.executeScript("localStorage.setItem(arguments[0],arguments[1])",item,value);




}
