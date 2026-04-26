import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    @BeforeMethod
    public void options() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    public void CheckPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".example")));
        Assert.assertEquals(driver.findElement(By.tagName("h4")).getText(),"Dynamic Controls");
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
    driver.quit();
}
}
