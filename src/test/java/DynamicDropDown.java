import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //clicking on from option and selecting from dynamic dropdown
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        //clicking on to option and selecting from dynamic dropdown
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(1000);
        //here we have to select the 2nd element because firstly it is available in from dropdown.
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();


        System.out.println("All test case passed");
    }
}
