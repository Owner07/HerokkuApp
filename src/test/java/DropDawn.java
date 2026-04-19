import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DropDawn {
    WebDriver webDriver;
    @Test
    public void dropDawn(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--incognito");
    options.addArguments("--disable-notifications");
    WebDriver webDriver = new ChromeDriver();
    SoftAssert softAssert = new SoftAssert();
    webDriver.get("https://the-internet.herokuapp.com/dropdown");
    webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    Select select = new Select(webDriver.findElement(By.id("dropdown")));
    select.selectByIndex(2);
    softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    select.selectByIndex(1);
    softAssert.assertEquals(select.getFirstSelectedOption().getText(),"Option 1");
    softAssert.assertAll();
    }
    @AfterMethod
    public void quit(){
        if(webDriver != null)
            webDriver.quit();
    }

}
