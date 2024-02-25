package com.ait.qa31.hw4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewAccountPositiveTest() {

        // click on Register link
        driver.findElement(By.cssSelector("[href='/register']")).click();

        //enter First Name
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Ivan");

        //enter Last Name
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Ivanenko");

        //enter email
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("derkach@gmail.com");

        //enter password
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Qwerty1234$");

        //enter Confirm Password
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Qwerty1234$");

        //click on the Registration button
        driver.findElement(By.id("register-button")).click();

        // assert link with email is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='derkach@gmail.com']")));

    }

}
