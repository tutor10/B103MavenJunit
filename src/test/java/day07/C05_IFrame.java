package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;


public class C05_IFrame extends TestBase {

    @Test
    public void test(){

        //User Story:
        //Sinif : IFrame
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin oldugunu test edelim
        String anaMetin=driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        //tag[.='metin'];Bana bu tagli metni ver
        //tag[text()='metin'];
        String expectedText ="black border";
        Assert.assertTrue(anaMetin.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim

        //Aplications lists elementi iframe in icinde ,Iframe switch yapmam sart
        driver.switchTo().frame(0);//index 0 dan baslar.ilk iframe e switch yapiyoruz

        String icMetin =  driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        String expectedText1 = "Applications lists";
        Assert.assertEquals(expectedText1,icMetin);

        //Alternatif olarak altdaki secenklerde kullanilabilir
        //Assert.assertTrue(expectedText1.contains(icMetin));
        //Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Applications lists']")).isDisplayed());

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
          //Ana sayfadaki Povered By yazisini test etmek istiyorum ama driver hala iframin icinde
          //Iframe in disia cikmak icin driver.switchTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
}