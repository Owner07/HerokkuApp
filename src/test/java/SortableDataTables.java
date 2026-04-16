import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SortableDataTables {

    @Test
    public void tables(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/tables");
        SoftAssert softAssert =new SoftAssert();

        WebElement element = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        softAssert.assertEquals(element.getText(),"Smith", "Проверка 1");

        WebElement element1 = driver.findElement(By.xpath("//table//tr[2]//td[2]"));
        softAssert.assertEquals(element1.getText(),"Frank", "Проверка 1");

        WebElement element2 = driver.findElement(By.xpath("//table//tr[3]//td[3]"));
        softAssert.assertEquals(element2.getText(),"jdoe@hotmail.com", "Проверка 1");

        WebElement element3 = driver.findElement(By.xpath("//table//tr[4]//td[4]"));
        softAssert.assertEquals(element3.getText(),"$50.00", "Проверка 1");
        softAssert.assertAll();
        driver.quit();
    }
}
