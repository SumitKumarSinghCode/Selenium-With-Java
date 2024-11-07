import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DropDownList {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(2000);

        //Running loop for adding 4 adult
        for (int i=1;i<4;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        //validating
        Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(), "4 Adult");

        driver.close();
        System.out.println("All test cases passed");
    }
}
