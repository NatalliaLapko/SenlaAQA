import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOut {
    public static void main(String[]args) throws InterruptedException {
// public static void main (String[]args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Log in
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys("test_user@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("Abc123qwe*");
        driver.findElement(By.name("commit")).click();

        //Log out
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.linkText("Sign out")).click();

    }
}
