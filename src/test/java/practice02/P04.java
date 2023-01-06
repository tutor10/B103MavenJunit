package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P04 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.xpath("(//*[@frameborder='0'])[1]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        String amazon = driver.getWindowHandle();

        //    - iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String [] aramaSonuc = driver.findElement
                        (By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).
                getText().split(" ");
        System.out.println("Arama Sonuc Sayisi=" + aramaSonuc[2]);


        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);//"https://html.com/tags/iframe/"adrese geri donduk
        System.out.println("Ilk Window Url'i=" + driver.getCurrentUrl());

        //    - amazon sayfasini kapatalım
        driver.switchTo().window(amazon);
        driver.close();


        //    - Sonra diğer sekmeyide kapatalım
              //TestBase'deki @After natosyonu calisacak
    }
}
