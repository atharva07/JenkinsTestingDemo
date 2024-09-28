package seleniumDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    void setup(String browser, String app) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D://server files//latest/chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("Please enter chrome browser as parameter");
        }
        driver.get(app);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void fillData() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Atharva Hiwase");
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    void alertMethod() throws InterruptedException {
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
