package com.ait.qa31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementHW {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelectorTest() {
        driver.findElements(By.cssSelector("head"));
        driver.findElement(By.cssSelector(".header-logo"));
        driver.findElement(By.cssSelector("#small-searchterms"));
        driver.findElement(By.cssSelector("[href='/register']"));
        driver.findElement(By.cssSelector("[href='https://academy.tricentis.com']"));
        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#topcartlink"));
        driver.findElement(By.cssSelector(".search-box"));
        driver.findElement(By.cssSelector(".header-menu"));
        driver.findElement(By.cssSelector(".top-menu"));
    }

    @Test
    public void findElementByXpathTest() {
        driver.findElements(By.xpath("//head"));
        driver.findElement(By.xpath("//*[@class='header-logo']"));
        driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        driver.findElement(By.xpath("//*[@href='/register']"));
        driver.findElement(By.xpath("//*[@href='https://academy.tricentis.com']"));
        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        driver.findElement(By.xpath("//*[@id='topcartlink']"));
        driver.findElement(By.xpath("//*[@class='search-box']"));
        driver.findElement(By.xpath("//*[@class='header-menu']"));
        driver.findElement(By.xpath("//*[@class='top-menu']"));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
