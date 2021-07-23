import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAdress {


    public static void main(String[] args) throws InterruptedException {
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "http://a.testaddressbook.com/sign_in";
            driver.get(baseUrl);
            driver.findElement(By.id("session_email")).sendKeys("test_user@gmail.com");
            driver.findElement(By.id("session_password")).sendKeys("Abc123qwe*");
            driver.findElement(By.name("commit")).click();

//Create new address
            driver.findElement(By.linkText("Addresses")).click();
            String adressUrl = "http://a.testaddressbook.com/addresses";
            driver.get(adressUrl);
            driver.findElement(By.xpath("//a[@href = '/addresses/new']")).click();
            //      String newAdressForm = "http://a.testaddressbook.com/addresses/new";
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


    }
}





