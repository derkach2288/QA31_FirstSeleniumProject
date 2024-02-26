package com.ait.qa31;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void createNewAccountPositiveTest() {

        // click on Register link
        click(By.cssSelector("[href='/register']"));

        //enter First Name
        type(By.id("FirstName"), "Ivan");

        //enter Last Name
        type(By.id("LastName"), "Ivanenko");

        //enter email
        type(By.id("Email"), "derkach@gmail.com");

        //enter password
        type(By.id("Password"), "Qwerty1234$");

        //enter Confirm Password
        type(By.id("ConfirmPassword"), "Qwerty1234$");

        //click on the Registration button
        click(By.id("register-button"));

        // assert link with email is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='derkach@gmail.com']")));

    }

}
