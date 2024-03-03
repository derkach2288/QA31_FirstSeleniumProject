package com.ait.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductHelper extends BaseHelper{
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAddedToCart() {
        return isElementPresent(By.xpath("//td[@class='product']//a[.='14.1-inch Laptop']"));
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector(".ico-cart .cart-label"));
    }

    public void clickOnAddToCartButton() {
        click(By.xpath("//div[@class='product-grid home-page-product-grid']/div[3]//input[@type='button']"));
    }

    public void deleteProductInCart() {
        // click on the input quantity and enter "0"
        type(By.cssSelector(".qty-input"), "0");

        // press "Enter" key
        driver.findElement(By.cssSelector(".qty-input")).sendKeys(Keys.ENTER);
    }
}
