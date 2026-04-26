import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Inputs {
    @Test
    public void inputs() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        try {
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String y = "Hi";
        int q = 123;

        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement x = driver.findElement(By.tagName("input"));
        x.sendKeys(y);
        String c = x.getAttribute("value");
        softAssert.assertEquals(c,y);
        x.clear();

        WebElement xc = driver.findElement(By.tagName("input"));
        xc.sendKeys(String.valueOf(q));
        int cc = Integer.parseInt(xc.getAttribute("value"));
        softAssert.assertEquals(cc,q);
        xc.sendKeys(Keys.ARROW_DOWN);
        int ccNew = Integer.parseInt(xc.getAttribute("value"));
        softAssert.assertEquals(ccNew,q - 1);
        softAssert.assertAll();
        xc.sendKeys(Keys.ARROW_UP);
        int ccNew1 = Integer.parseInt(xc.getAttribute("value"));
        softAssert.assertEquals(ccNew1,q);
        softAssert.assertAll();
        } finally{
           driver.quit();
        }
    }
}
