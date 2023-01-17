package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P06_Actions extends TestBase {

    @Test
    public void test01(){


//     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);//iframe e gecis yaptik

//     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız.

        WebElement greenSlider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement blueSlider=driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(greenSlider,-175,0).perform();//Genellikle slider lar icin bu method kullanilir.
        actions.dragAndDropBy(blueSlider,-90,0).build().perform();
        actions.dragAndDropBy(greenSlider,301,0).build().perform();


//     -Sarı olduğunu test edelim
        WebElement yellow = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        Assert.assertTrue(yellow.isDisplayed());
        //assert yellow.isDisplayed();

    }
}
