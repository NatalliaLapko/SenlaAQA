package test.java;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class AddressEditing {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Log in
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys("test_user@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Abc123qwe*");
        driver.findElement(By.name("commit")).click();


//Editing Address

            String AddressesListURL = "http://a.testaddressbook.com/addresses";
            driver.get(AddressesListURL);
            driver.findElement(By.cssSelector("a[href$='edit']")).click();
            driver.get(driver.getCurrentUrl());

            // WebElement firstName = driver.findElement(By.xpath("//input[@id='address_first_name']"));
            WebElement firstName = driver.findElement(By.cssSelector("input#address_first_name"));
            firstName.clear();
            firstName.sendKeys("User");

            WebElement lastName = driver.findElement(By.cssSelector("input#address_last_name"));
            lastName.clear();
            lastName.sendKeys("Default");

            WebElement city = driver.findElement(By.cssSelector("input#address_city"));
            city.clear();
            city.sendKeys("Provo");

            Select drpState = new Select(driver.findElement(By.id("address_state")));
            drpState.selectByVisibleText("Utah");

            driver.findElement(By.id("address_birthday")).sendKeys("08.08.2000");

            WebElement chbReading = driver.findElement(By.id("address_interest_read"));
            chbReading.click();

            WebElement chbClimbing = driver.findElement(By.id("address_interest_climb"));
            chbClimbing.click();

            driver.findElement(By.xpath("//input[@name = 'commit']")).click();
        }









    }

