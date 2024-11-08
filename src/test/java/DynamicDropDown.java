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
        //Method->1 using the Relative XPath.
        //driver.findElement(By.xpath("//a[@value='BLR']")).click();

        //Method->2 using parent child combined xpath.(By selecting parent tag and will search child inside the same parent tag)
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();



        //clicking on to option and selecting from dynamic dropdown
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        Thread.sleep(1000);
        //Method->1 using the Relative XPath and giving index to it.
        //here we have to select the 2nd element because firstly it is available in from dropdown.
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //Method->2 using parent child combined xpath.(By selecting parent tag and will search child inside the same parent tag)
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();


        System.out.println("All test case passed");
    }
}
