import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        String userName="rahul";
        String loginPassward="rahulshettyacademy";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// waiting for the element to appear in the same page till 5 second
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(loginPassward);
        driver.findElement(By.cssSelector("input[name='chkboxOne']")).click();
        driver.findElement(By.cssSelector("input[name='chkboxTwo']")).click();
        driver.findElement(By.cssSelector("button[class*='signInBtn']")).click();

        Thread.sleep(2000); // Waiting for the page to load.
        //System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+userName+",");

        //Logout
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();

        //Closing all the windows
        driver.close();
        System.out.println("All Passed");
    }
}
