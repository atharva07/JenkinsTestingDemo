package seleniumDemo;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class DifferentMethodsExample {

    private static final Logger log = LoggerFactory.getLogger(DifferentMethodsExample.class);

    public static void main(String[] args) {
        // first two lines are used to disable the notifications
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "D://server files//latest/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();

        // isEnabled method
        WebElement cookiesButton = driver.findElement(By.xpath("//span[contains(text(), 'Got it')]"));
        if (cookiesButton.isEnabled()) {
            cookiesButton.click();
        }

        // isDisplayed method
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(), 'Login')]"));
        if (loginButton.isDisplayed()) {
            loginButton.click();
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File("path//to//screenshot"));

    }
}