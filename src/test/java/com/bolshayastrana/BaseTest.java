package com.bolshayastrana;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ResourceBundle;

public class BaseTest {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    public static final String URL = "https://bolshayastrana.com/";
    public static ResourceBundle resource = ResourceBundle.getBundle("text_ru_RU");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
