import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropDown {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //DropDown with select tag (it only works when option have select tag)
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        //selecting based on the index (index starts from 0 ).
        dropdown.selectByIndex(3);
        String selectedByIndex = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedByIndex,"USD");//validating test case

        //selecting based on the visible text
        dropdown.selectByVisibleText("INR");
        String selectedByText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedByText,"INR");//validating test case

        //selecting by value attribute of html
        dropdown.selectByValue("AED");
        String selectedByValue = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedByValue,"AED");//validating test case


        System.out.println("All test cases passed");
    }
}
