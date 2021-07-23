import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class DeleteAddress {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Log in
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys("test_user@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Abc123qwe*");
        driver.findElement(By.name("commit")).click();


// Deleting

        String AddressesListURL = "http://a.testaddressbook.com/addresses";
        driver.get(AddressesListURL);
        driver.findElement(By.linkText("Destroy")).click();
        driver.switchTo().alert().accept();

    }

    }
