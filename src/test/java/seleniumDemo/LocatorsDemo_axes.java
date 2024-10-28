package seleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsDemo_axes {

    public static void main(String[] args) {
        WebDriver driver = null;

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        // self node
        String stockSelfname = driver.findElement(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/self::a")).getText();
        System.out.println(stockSelfname);

        // parent
        String stockSelfname2 = driver.findElement(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/parent::td")).getText();
        System.out.println(stockSelfname);

        // child
        //   (//h2[contains(text(), 'Deals on Toys & games')]//ancestor::div)[6]/child::div[2]/child::div[1]
        List<WebElement> childs = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/child::td"));
        System.out.println("Number of child = " + childs.size());

        // ancestor
        String ancestorText = driver.findElement(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr")).getText();
        System.out.println(ancestorText);

        // descendent
        List<WebElement> descendents = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/descendant::*"));
        System.out.println("Number of descendent = " + descendents.size());

        // following
        List<WebElement> followingElements = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/following::tr"));
        System.out.println("Number of following elements = " + followingElements.size());

        // following-sibling
        List<WebElement> followingSibling = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/following-sibling::tr"));
        System.out.println("Number of following elements = " + followingSibling.size());

        // preceding
        List<WebElement> preceding = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/preceding::tr"));
        System.out.println("Number of following elements = " + preceding.size());

        // preceding-sibling
        List<WebElement> precedingSibling = driver.findElements(By.xpath("//a[contains(text(), 'Indian Hotels Co')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Number of following elements = " + precedingSibling.size());

        driver.close();
    }
}
