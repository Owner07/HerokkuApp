import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBoxes {

    @Test
    public void Check(){

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        boolean isCheck = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertFalse(isCheck);
        WebElement element = driver.findElements(By.cssSelector("[type=checkbox]")).get(0);
        element.click();
        isCheck = element.isSelected();
        Assert.assertTrue(isCheck);

        boolean isCheck2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(0).isSelected();
        Assert.assertTrue(isCheck2);
        WebElement element2 = driver.findElements(By.cssSelector("[type=checkbox]")).get(1);
        element2.click();
        isCheck2 = element2.isSelected();
        Assert.assertFalse(isCheck2);
        driver.quit();
    }
}
