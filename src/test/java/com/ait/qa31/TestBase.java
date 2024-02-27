package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    protected void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isRegisterLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/register']"));
    }

    public boolean isAccountCreatedByEmailLink() {
        return isElementPresent(By.xpath("//a[.='derkach@gmail.com']"));
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegisterForm(String name, String lastName, String email, String password) {
        type(By.id("FirstName"), name);
        type(By.id("LastName"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[value='Log in']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#Email"), email);
        type(By.cssSelector("#Password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
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
