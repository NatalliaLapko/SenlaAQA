package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

import static com.JUnitTest.Locators.LOGIN_EMAIL;
import static com.JUnitTest.Locators.LOGIN_PASSWORD;

public class Test {

    WebDriver driver = Driver.getChromeDriver();




    protected void logIn (String email, String password) {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(LOGIN_EMAIL).sendKeys(email);
        driver.findElement(LOGIN_PASSWORD).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    public void CreateNewAddress() {
//Create new address
        driver.findElement(By.linkText("Addresses")).click();
        String adressUrl = "http://a.testaddressbook.com/addresses";
        driver.get(adressUrl);
        driver.findElement(By.xpath("//a[@href = '/addresses/new']")).click();
        driver.get(driver.getCurrentUrl());
        WebElement firstName = driver.findElement(By.id("address_first_name"));
        firstName.sendKeys("Test");
        driver.findElement(By.id("address_last_name")).sendKeys("User");
        driver.findElement(By.id("address_street_address")).sendKeys("st.Pushkin, 15 ");
        driver.findElement(By.id("address_secondary_address")).sendKeys("st.Green 25");
        driver.findElement(By.id("address_city")).sendKeys("Nashville");
        Select drpState = new Select(driver.findElement(By.id("address_state")));
        drpState.selectByVisibleText("Tennessee");
        driver.findElement(By.id("address_zip_code")).sendKeys("123456");
        WebElement radioUSA = driver.findElement(By.id("address_country_us"));
        WebElement radioCanada = driver.findElement(By.id("address_country_canada"));
        radioUSA.click();
        driver.findElement(By.id("address_birthday")).sendKeys("07.07.1997");
        driver.findElement(By.id("address_age")).sendKeys("23");
        driver.findElement(By.id("address_website")).sendKeys("https://www.youtube.com/");
        WebElement uploadFileButton = driver.findElement(By.id("address_picture"));
        uploadFileButton.sendKeys("C:\\Users\\USER\\Desktop\\cat.jpg"); //bug. The file doesn't uploaded.
        driver.findElement(By.id("address_phone")).sendKeys("+375293526987");
        WebElement chbClimbing = driver.findElement(By.id("address_interest_climb"));
        WebElement chbDancing = driver.findElement(By.id("address_interest_dance"));
        WebElement chbReading = driver.findElement(By.id("address_interest_read"));
        chbDancing.click();
        chbReading.click();
        driver.findElement(By.id("address_note")).sendKeys("Hello World!");
        WebElement createAddressButton = driver.findElement(By.xpath("//input [@value ='Create Address']"));
        createAddressButton.click();

    }

    //Editing Address
    public void EditAddress () {
        String AddressesListURL = "http://a.testaddressbook.com/addresses";
        driver.get(AddressesListURL);
        driver.findElement(By.cssSelector("a[href$='edit']")).click();
        driver.get(driver.getCurrentUrl());


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

    public void DeleteAddress(){
// Deleting

        String AddressesListURL = "http://a.testaddressbook.com/addresses";
        driver.get(AddressesListURL);
        driver.findElement(By.linkText("Destroy")).click();
        driver.switchTo().alert().accept();

    }

    public void LogOut(){
        //Log out
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.linkText("Sign out")).click();
        driver.quit();
    }
}
