package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class HandlingAlertDemo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D://server files//latest/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
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
        driver.close();
    }
}