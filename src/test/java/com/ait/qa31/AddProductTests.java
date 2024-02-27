package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnLogOutButton();
        }

        clickOnLoginLink();
        fillLoginForm("derkach@gmail.com", "Qwerty1234$");
        clickOnLoginButton();

        // assert link with email is present
//        Assert.assertTrue(isElementPresent(By.xpath("//a[.='derkach@gmail.com']")));
    }

    @Test
    public  void addProductPositiveTest() {
        // click on the Add to cart button
        clickOnAddToCartButton();

        // click on Shopping cart link
        clickOnShoppingCartLink();

//        Assert.assertTrue(isProductAddedToCart("14.1-inch Laptop"));
//        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='product']//a[.='14.1-inch Laptop']")).getText(), "14.1-inch Laptop");
        Assert.assertTrue(isProductAddedToCart());


    }

    @AfterMethod
    public void postCondition() {
        deleteProductInCart();
    }

    //    public boolean isProductAddedToCart(String text) {
//        List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
//        for (WebElement element : products) {
//            if (element.getText().contains(text)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
