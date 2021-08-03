package com.JUnitTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import static com.JUnitTest.Locators.*;

public class Tests {

   private WebDriver driver = Driver.getChromeDriver();


    @BeforeEach
    public void logIn(){
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(LOGIN_EMAIL).sendKeys(MainTests.EMAIL);
        driver.findElement(LOGIN_PASSWORD).sendKeys(MainTests.PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }


    @Test
    @Disabled
    @DisplayName("URL chacking")
    public  void chackAddressesList(){
        driver.get("http://a.testaddressbook.com/");

        String accountName =  driver.findElement(ACCOUNT_NAME).getText();
        Assertions.assertEquals("test_user@gmail.com",accountName, "Wrong account!");



    }

    @Test
   // @Disabled
    @DisplayName("First Name and Last Name of the Address account = Test User")
    public void firstAddressName(){
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(LINK_ADDRESS).click();
        driver.findElement(SHOW_LINK).click();
        String firstNameUser = driver.findElement(FIRST_NAME_TEXT).getText();
        String lastNameUser = driver.findElement(LAST_NAME_TEXT).getText();

        Assertions.assertEquals("Test"+ " " + "User",firstNameUser+ " " + lastNameUser,"Wrong Address name!");

    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }

}
