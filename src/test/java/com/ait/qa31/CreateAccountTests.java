package com.ait.qa31;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isRegisterLinkPresent()) {
            clickOnLogOutButton();
        }
    }

    @Test
    public void createNewAccountPositiveTest() {
        clickOnRegisterLink();
        fillRegisterForm("Ivan", "Ivanenko", "derkach@gmail.com", "Qwerty1234$");
        clickOnRegisterButton();
        Assert.assertTrue(isAccountCreatedByEmailLink());
    }

}
