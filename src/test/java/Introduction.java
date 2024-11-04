import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class Introduction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // it will wait till 5 seconds for the response.

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


        driver.findElement(By.id("inputUsername")).sendKeys("sumitsingh@gmail.com");
        driver.findElement(By.name("inputPassword")).sendKeys("1234");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();
        String logginErrorMessage = driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(logginErrorMessage);

        // for resetting the password
        String ResetErrorMessage=null;
        if (logginErrorMessage.equalsIgnoreCase("* incorrect username or password")){
            driver.findElement(By.linkText("Forgot your password?")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Sumit Kumar Singh");
            driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Sumit@gmail.com");
            driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys(("7428956203"));
            driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
            ResetErrorMessage = driver.findElement(By.cssSelector("p.infoMsg")).getText();
            System.out.println(ResetErrorMessage);
        }

        driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.cssSelector("#chkboxTwo")).click();
        driver.findElement(By.cssSelector("button[class*='submit']")).click();

    }
}
