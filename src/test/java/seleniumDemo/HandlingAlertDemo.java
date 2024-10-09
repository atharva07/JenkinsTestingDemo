package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HandlingAlertDemo {

    @Parameters("Browser")
    @Test
    public void handlingAlert(String browserName) throws InterruptedException {

        System.out.println("Parameter value is = " + browserName);
        WebDriver driver = null;

        if (browserName.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.contains("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Atharva Hiwase");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

        Thread.sleep(5000);

        // Alert example
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();

        System.out.println(alertMessage);
        Thread.sleep(4000);
        alert.accept();

        // mouse hover example
        WebElement element = driver.findElement(By.xpath("//button[@id='mousehover']"));

        // create an object of action class
        Actions action = new Actions(driver);

        // performing the mouse hover action
        action.moveToElement(element).perform();

        System.out.println("Mouse hover successfull");
        Thread.sleep(4000);
        driver.quit();
    }
}