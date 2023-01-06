package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class WindowHandle extends TestBase {

    @Test
    public void test01(){

//        Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

//        Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();

//        Sayfa title’nin “Amazon” icerdigini test edin
        String actualtitle = driver.getTitle();
        String arananKelime = "Amazon";
        Assert.assertTrue(actualtitle.contains(arananKelime));

//        Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);//Yeni bir sekme acmis olduk
        driver.get("https://techproeducation.com");

//        Sayfa title’nin “TECHPROEDUCATION” icerip icermedigini test edin\
        String actualTechproTitle= driver.getTitle();
        String expectedTitle = "TECHPROEDUCATION";
        Assert.assertFalse(actualTechproTitle.contains(expectedTitle));

//        Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir window acmis olduk
        driver.get("https://walmart.com");

//        Sayfa title’nin “Walmart” icerdigini test edin
        String actualWalmartTitle = driver.getTitle();
        String beklenenKelime = "Walmart";
        Assert.assertTrue(actualWalmartTitle.contains(beklenenKelime));

//        Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
