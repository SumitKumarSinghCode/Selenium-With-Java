import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.co.in/"); // in this case selenium will wait for the page to get fully loaded.
        Thread.sleep(5000);
        driver.navigate().to("https://rahulshettyacademy.com/"); //in this case selenium will not wait for the page to get fully loaded.
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().forward();

        Thread.sleep(5000);
        driver.close();
        System.out.println("All Test Case Passed");
    }
}
