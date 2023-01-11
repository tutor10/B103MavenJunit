package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_iframe extends TestBase {

    @Test
    public void iframeTest(){

//        Create a class: IFrame
//        Create a method: iframeTest
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get(" https://the-internet.herokuapp.com/iframe");

//        Verify the Bolded text contains “Editor”
        String textContain=driver.findElement(By.xpath("//h3")).getText();
        String expectedText="Editor";
        Assert.assertTrue(textContain.contains(expectedText));

//        Locate the text box
        driver.switchTo().frame(0);

//        Delete the text in the text box
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();

//        Type “This text box is inside the iframe”
        driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).sendKeys("This text box is inside the iframe");

//        Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().defaultContent();
        String display =driver.findElement(By.xpath("//*[.='Elemental Selenium']")).getText();
        String expectedText2="Elemental Selenium";
        Assert.assertTrue(display.contains(expectedText2));
    }
}
