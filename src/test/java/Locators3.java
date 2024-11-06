import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import java.time.Duration;

public class Locators3 {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //sibling - parent to child traverse

        //relative xpath:- //header/div/button[1]/following-sibling::button[1]
        String str1 = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();//parent to child and sibling to sibling
        Assert.assertEquals(str1,"Login");

        //parent to child and back to parent
        String str2 = driver.findElement(By.xpath("//header/div/button[1]/parent::div")).getText();
        Assert.assertEquals(str2,"Home Practice Login Signup");

        // traversing element to different element
        String str3 = driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[2]")).getText();
        Assert.assertEquals(str3,"Free Access to InterviewQues/ResumeAssistance/Material");

        driver.close();
        System.out.println("All Test cases passed");
    }
}
