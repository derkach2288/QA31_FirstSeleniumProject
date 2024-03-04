package com.ait.qa31;

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

    @DataProvider
    public Iterator<Object[]> createNewAccountFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");
            list.add(new Object[]{new User().setName(split[0]).setLastName(split[1]).setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();

        }

        return list.iterator();
    }

    @Test(dataProvider = "createNewAccountFromCSV")
    public void createNewAccountPositiveTestDataProviderWithFile(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isAccountCreatedByEmailLink());
    }

}
