package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm("derkach@gmail.com", "Qwerty1234$");
        app.getUser().clickOnLoginButton();
    }

    @Test
    public  void addProductPositiveTest() {
        // click on the Add to cart button
        app.getProduct().clickOnAddToCartButton();

        // click on Shopping cart link
        app.getProduct().clickOnShoppingCartLink();

//        Assert.assertTrue(isProductAddedToCart("14.1-inch Laptop"));
//        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='product']//a[.='14.1-inch Laptop']")).getText(), "14.1-inch Laptop");
        Assert.assertTrue(app.getProduct().isProductAddedToCart());


    }

    @AfterMethod
    public void postCondition() {
        app.getProduct().deleteProductInCart();
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
