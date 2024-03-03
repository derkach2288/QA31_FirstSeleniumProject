package com.ait.qa31;

import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void createNewAccountPositiveTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setName("Ivan")
                .setLastName("Ivanenko")
                .setEmail("derkach8@gmail.com")
                .setPassword("Qwerty1234$"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isAccountCreatedByEmailLink());
    }

}
