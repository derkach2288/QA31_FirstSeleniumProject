package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        // if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            // click on Log Out button
            click(By.cssSelector("[href='/logout']"));
        }

        // click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.cssSelector("#Email"), "derkach@gmail.com");

        // enter password
        type(By.cssSelector("#Password"), "Qwerty1234$");

        // click on the login button
        click(By.cssSelector("[value='Log in']"));

        // assert link with email is present
//        Assert.assertTrue(isElementPresent(By.xpath("//a[.='derkach@gmail.com']")));
    }

    @Test
    public  void addProductPositiveTest() {
        // click on the Add to cart button
        click(By.xpath("//div[@class='product-grid home-page-product-grid']/div[3]//input[@type='button']"));

        // click on Shopping cart link
        click(By.cssSelector(".ico-cart .cart-label"));

//        Assert.assertTrue(isProductAddedToCart("14.1-inch Laptop"));
        Assert.assertEquals(driver.findElement(By.xpath("//td[@class='product']//a[.='14.1-inch Laptop']")).getText(), "14.1-inch Laptop");


    }

    @AfterMethod
    public void postCondition() {
        // click on the input quantity and enter "0"
        type(By.cssSelector(".qty-input"), "0");

        // press "Enter" key
        driver.findElement(By.cssSelector(".qty-input")).sendKeys(Keys.ENTER);
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
