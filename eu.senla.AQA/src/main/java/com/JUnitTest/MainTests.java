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

    WebDriver driver = Driver.getChromeDriver();


    @BeforeEach
    public void LogIn() {
      String email = "test_user@gmail.com";
      String password = "Abc123qwe*";
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(LOGIN_EMAIL).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    @Test
    @Order(1)
    @DisplayName("Создание нового адреса")
    public void CreateNewAddress() {

//Create new address
            driver.findElement(LINK_ADDRESS).click();
//            String adressUrl = "http://a.testaddressbook.com/addresses";
//            driver.get(adressUrl);
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
            uploadFileButton.sendKeys("C:\\Users\\USER\\Desktop\\cat.jpg"); //bug. The file doesn't uploaded.
            driver.findElement(PHONE).sendKeys("+375293526987");
            WebElement chbClimbing = driver.findElement(By.id("address_interest_climb"));
            WebElement chbDancing = driver.findElement(By.id("address_interest_dance"));
            WebElement chbReading = driver.findElement(By.id("address_interest_read"));
            chbDancing.click();
            chbReading.click();
            driver.findElement(NOTE).sendKeys("Hello World!");
            WebElement createAddressButton = driver.findElement(CREATE_ADDRESS_BUTTON);
            createAddressButton.click();

        }

//        @Test
//        public void firstAddressName(){
//        driver.get("http://a.testaddressbook.com/addresses");
//        WebElement firstShowButton = driver.findElement(By.xpath("//a[contains(text(),'Show')]"));
//        firstShowButton.click();
//        String firstNameUser = driver.findElement(By.xpath("//span[@data-test = 'first_name' ]")).getText();
//        String lastNameUser = driver.findElement(By.xpath("//span[@data-test = 'last_name' ]")).getText();
//
//            Assertions.assertEquals("Test"+ " " + "User",firstNameUser+ " " + lastNameUser,"Wrong Address name!");
//
//        }


    @Test
    @Order(3)
    @DisplayName("Удаление адреса")
    public void DeleteAddress () {
        String AddressesListURL = "http://a.testaddressbook.com/addresses";
        driver.get(AddressesListURL);
        driver.findElement(DESTROY).click();
        driver.switchTo().alert().accept();
    }


        @Test
        @Order(2)
        @DisplayName("Редактирование адреса")
        public void EditAddress () {
            String AddressesListURL = "http://a.testaddressbook.com/addresses";
            driver.get(AddressesListURL);
            driver.findElement(By.cssSelector("a[href$='edit']")).click();
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

            driver.findElement(By.xpath("//input[@name = 'commit']")).click();
        }





        @AfterEach
    public void LogOut(){
            driver.get("http://a.testaddressbook.com/addresses");
            driver.findElement(By.linkText("Sign out")).click();
            driver.quit();
        }





}
