import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void frames() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tox-notification__dismiss.tox-button.tox-button--naked.tox-button--icon")));
        driver.findElement(By.cssSelector(".tox-notification__dismiss.tox-button.tox-button--naked.tox-button--icon")).click();
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }
}
