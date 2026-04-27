import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class FileDownload {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\downloads");
        prefs.put("download.prompt_for_download", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("div.example a")).click();
        Thread.sleep(5000);

        File folder = new File(System.getProperty("user.dir") + "\\downloads");
        Assert.assertTrue(folder.listFiles().length > 0);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
