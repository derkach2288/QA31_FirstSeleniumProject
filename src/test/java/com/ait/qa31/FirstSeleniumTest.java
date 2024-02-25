package com.ait.qa31;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    // before - setUp, init
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com"); // открывает новый браузер
        driver.navigate().to("https://www.google.com"); // с историей
        driver.navigate().back(); // вернуться на шаг назад
        driver.navigate().forward(); // шаг вперед
        driver.navigate().refresh(); // страница обновляется
    }

    // tests
    @Test
    public void openGoogleTest() {
        System.out.println("Google opened!");
    }
    // after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown() {
//        driver.quit(); // закрывает весь хром
        driver.close(); // закрывает только одну вкладку
    }
}
