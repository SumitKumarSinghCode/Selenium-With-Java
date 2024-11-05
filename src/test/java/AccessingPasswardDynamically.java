import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class AccessingPasswardDynamically {
    public static void main(String[] args) throws InterruptedException {
        String userName="rahul";

        WebDriver driver=new EdgeDriver();
        String userPassward = getPassward(driver);

        System.out.println("User Passward= "+userPassward); // printed password

        driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(userPassward);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+userName+",");

        //log Out
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        Thread.sleep(2000);
        driver.close();
        System.out.println("All Test Case Passed");
    }

    public static String getPassward(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        String passwardString= driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
        String[] pwdStr1 = passwardString.split("'");

        //pwdStr1[0] = Please use temporary password
        //pwdStr1[1] = rahulshettyacademy
        //pwdString1[3] =   to Login.

        return pwdStr1[1];
    }
}
