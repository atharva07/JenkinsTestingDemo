package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowSwitchingExample {

    public static void main(String[] args) {

        WebDriver driver = null;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://example.com");

        // Store the main window handle
        String mainWindowHandle = driver.getWindowHandle();

        // click on the button that opens the new window
        driver.findElement(By.xpath("")).click();

        // Get all window handles
        Set<String> newWindows = driver.getWindowHandles();

        for (String windoHandle : newWindows) {
            if(!windoHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windoHandle);
                break;
            }
        }

        // perform operation in this stage

        // switch back to main window
        driver.switchTo().window(mainWindowHandle);
    }
}
