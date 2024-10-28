package seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Collections;

public class FetchAllLinks {

    public static void main(String[] args) {
        // Set up ChromeDriver
        System.setProperty("webdriver.chrome.driver", "D://server files//latest/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver =  new ChromeDriver(options);

        // Open the webpage
        String url = "https://accounts.google.com/signin";
        driver.get(url);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("atharva.hiwase07@gmail.com");
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();

        // Close the browser
        //driver.quit();
    }
}
