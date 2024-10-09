package seleniumDemo;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingMethod {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D://server files//latest/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        String parent = driver.getWindowHandle();
        driver.findElement(By.xpath("//span[@class='acceptance-btn-text']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//span[contains(text(), 'MNC')])[1]")).click();

        Thread.sleep(5000);
        Set<String> s = driver.getWindowHandles();
        System.out.println(parent);

        Iterator<String> i1 = s.iterator();
        while(i1.hasNext()) {
            String child_window = i1.next();

            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                //driver.close();
            }
        }
    }
}
