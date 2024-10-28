package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsAmazonDemo {

    public static void main(String[] args) {
        WebDriver driver = null;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();
    }
}
