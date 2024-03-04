package com.ait.qa31;

import com.ait.fw.DataProviders;
import com.ait.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


    @Test(dataProvider = "createNewAccountFromCSV", dataProviderClass = DataProviders.class)
    public void createNewAccountPositiveTestDataProviderWithFile(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isAccountCreatedByEmailLink());
    }

}
