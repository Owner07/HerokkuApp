import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicControlTest extends BaseTest{

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        CheckPage();
        driver.findElement(By.xpath("//*[text() = 'Remove']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
    }

    @Test
    public void checkInput() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        CheckPage();
        softAssert.assertEquals(driver.findElement(By.cssSelector("input[disabled]")).getText(),"");
        driver.findElement(By.xpath("//button[text() = 'Enable']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        softAssert.assertTrue(driver.findElement(By.cssSelector("Input")).isEnabled());
        softAssert.assertAll();
    }
}
