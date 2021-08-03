package com.JUnitTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import static com.JUnitTest.Locators.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainTests {

 private    WebDriver driver = Driver.getChromeDriver();

    static final String EMAIL = "test_user@gmail.com";
    static final String PASSWORD = "Abc123qwe*";
    @BeforeEach
    public void logIn() {

        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(LOGIN_EMAIL).sendKeys(EMAIL);
        driver.findElement(LOGIN_PASSWORD).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Test
    @Order(1)
    @DisplayName("Создание нового адреса")
    public void CreateNewAddress() {

//Create new address
            driver.findElement(LINK_ADDRESS).click();
            driver.findElement(LINK_NEW_ADDRESS).click();
            driver.get(driver.getCurrentUrl());
            WebElement firstName = driver.findElement(FIRST_NAME);
            firstName.sendKeys("Test");
            driver.findElement(LAST_NAME).sendKeys("User");
            driver.findElement(ADDRESS_1).sendKeys("st.Pushkin, 15 ");
            driver.findElement(ADDRESS_2).sendKeys("st.Green 25");
            driver.findElement(CITY).sendKeys("Nashville");
            Select drpState = new Select(driver.findElement(STATE));
            drpState.selectByVisibleText("Tennessee");
            driver.findElement(ZIP_CODE).sendKeys("123456");
            WebElement radioUSA = driver.findElement(RADIO_USA);
            WebElement radioCanada = driver.findElement(RADIO_CANADA);
            radioUSA.click();
            driver.findElement(BIRTHDAY).sendKeys("07.07.1997");
            driver.findElement(AGE).sendKeys("23");
            driver.findElement(WEBSITE).sendKeys("https://www.youtube.com/");
            WebElement uploadFileButton = driver.findElement(By.id("address_picture"));
            uploadFileButton.sendKeys("C:/Users/USER/Desktop/cat.jpg"); //bug. The file doesn't uploaded.
            driver.findElement(PHONE).sendKeys("+375293526987");

            driver.findElement(By.id("address_interest_dance")).click();
            driver.findElement(By.id("address_interest_read")).click();

            driver.findElement(NOTE).sendKeys("Hello World!");
            driver.findElement(CREATE_ADDRESS_BUTTON).click();


        }


    @Test
    @Order(3)
    @DisplayName("Удаление адреса")
    public void DeleteAddress () {
        driver.get("http://a.testaddressbook.com/");
        driver.findElement(LINK_ADDRESS).click();
        driver.findElement(DESTROY).click();
        driver.switchTo().alert().accept();
    }


        @Test
        @Order(2)
        @DisplayName("Редактирование адреса")
        public void EditAddress () {
            driver.get("http://a.testaddressbook.com/");
            driver.findElement(LINK_ADDRESS).click();
            driver.findElement(EDIT_BUTTON).click();
            driver.get(driver.getCurrentUrl());


            WebElement firstName = driver.findElement(FIRST_NAME);
            firstName.clear();
            firstName.sendKeys("User");

            WebElement lastName = driver.findElement(LAST_NAME);
            lastName.clear();
            lastName.sendKeys("Default");

            WebElement city = driver.findElement(CITY);
            city.clear();
            city.sendKeys("Provo");

            Select drpState = new Select(driver.findElement(STATE));
            drpState.selectByVisibleText("Utah");

            driver.findElement(BIRTHDAY).sendKeys("08.08.2000");

            WebElement chbReading = driver.findElement(By.id("address_interest_read"));
            chbReading.click();

            WebElement chbClimbing = driver.findElement(By.id("address_interest_climb"));
            chbClimbing.click();

            driver.findElement(EDIT_ADDRESS_BUTTON).click();
        }





        @AfterEach
    public void LogOut(){
            driver.get("http://a.testaddressbook.com/addresses");
            driver.findElement(By.linkText("Sign out")).click();
            driver.quit();
        }





}
