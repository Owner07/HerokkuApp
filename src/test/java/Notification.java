import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Notification {

    WebDriver webDriver;
    @Test
    public void notification() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
//        SoftAssert softAssert = new SoftAssert();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a")).click();
        WebElement notify = webDriver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String noty = notify.getText();
        Assert.assertTrue(noty.contains("Action successful"),"123");

    }
    @AfterMethod
    public void quit(){
        if(webDriver != null){
            webDriver.quit();
        }
    }
}
