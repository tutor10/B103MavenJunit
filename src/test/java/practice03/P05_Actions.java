package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P05_Actions extends TestBase {

    @Test
    public void name() throws InterruptedException {
//        http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yaziTahtasi).clickAndHold();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0, 5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5, 0);
        }
        actions.release().build().perform();

        //        - Çizimden sonra clear butonuna basalım

//        - Son olarak sayfayı temizleyiniz
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
    }


    @Test
    public void test01() throws InterruptedException {
//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz -DAIRE CIZIMI
        Actions actions = new Actions(driver);
        actions.moveByOffset(660,345).build().perform();
        int y = 10;
        actions.clickAndHold().build().perform();
        for (int i=1; i<11; i++){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=11; i>0; i--){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=0; i>-11; i--){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        for (int i=-11; i<3; i++){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        waitFor(10);
    }
}
