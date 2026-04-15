import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class Typos {
    @Test
    public void TyposTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/typos");
        SoftAssert softAssert = new SoftAssert();
        String name2 = "Sometimes you'll see a typo, other times you won't.";
        for(int i = 0; i < 10; i++){
            String name = driver.findElement(By.xpath("(//p[2])")).getText();
            System.out.println(name);
            softAssert.assertEquals(name, name2);
            driver.navigate().refresh();
        }
        driver.quit();
        softAssert.assertAll();
    }
}
