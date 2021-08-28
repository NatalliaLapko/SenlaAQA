package com.JUnitTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import static com.JUnitTest.Locators.*;

public class Tests {

    WebDriver driver = Driver.getChromeDriver();


    @BeforeEach
    public void logIn(){
        String email = "test_user@gmail.com";
        String password = "Abc123qwe*";
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(LOGIN_EMAIL).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }


    @Test
    @Disabled
    @DisplayName("URL chacking")
    public  void chackAddressesList(){
        driver.get("http://a.testaddressbook.com/addresses");
        String accountName =  driver.findElement(ACCOUNT_NAME).getText();
        Assertions.assertEquals("test_user@gmail.com",accountName, "Wrong account!");



    }

    @Test
   // @Disabled
    @DisplayName("First Name and Last Name of the Address account = Test User")
    public void firstAddressName(){
        driver.get("http://a.testaddressbook.com/addresses");
        WebElement firstShowButton = driver.findElement(By.xpath("//a[contains(text(),'Show')]"));
        firstShowButton.click();
        String firstNameUser = driver.findElement(By.xpath("//span[@data-test = 'first_name' ]")).getText();
        String lastNameUser = driver.findElement(By.xpath("//span[@data-test = 'last_name' ]")).getText();

        Assertions.assertEquals("Test"+ " " + "User",firstNameUser+ " " + lastNameUser,"Wrong Address name!");

    }

    @AfterEach
    public void TearDown(){
        driver.quit();
    }

}
