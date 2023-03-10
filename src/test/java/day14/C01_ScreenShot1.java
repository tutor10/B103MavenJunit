package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {
/*
Selenium tum ekran goruntusu nasil alinir?
    -tum ekran goruntusu selenium'dan gelen getScreenshotAs method'u ile alinir
    -getScreenshotAs method'u Selenium'daki TakeScreenshot API' indan gelir.
 */

    @Test
    public void fullPageScreenShotTest() throws IOException {


//        Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://techproeducation.com");

        // 1.Ekran goruntusunu getScreenshotAs metotu ile alip file olarak olusturalim
        File goruntu=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


//        2. Almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet.dir= directory=dosya
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef = new File(path);
       // String path = System.getProperty("user.dir")+"\\test-output\\EkranGoruntuleri\\image.png";//CALISMIYORSA WINDOWS ICIN

//        3. Goruntum ile dosyami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

//        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
//                new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path

//        -“QA” aramasi yap
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA", Keys.ENTER);
        waitFor(3);

        //        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));
//       Reusable metod yardimiyla ekran goruntusunu alalim
        takeScreenShotOfPage();
    }
}
