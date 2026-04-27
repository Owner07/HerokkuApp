import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseTest{

    @Test
    public void checkFile () {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/main/resources/name.txt");
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String fileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName.substring(0,fileName.lastIndexOf(".")),"name");
    }
}
