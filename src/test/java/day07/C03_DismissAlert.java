package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void dismissAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();// dismiss(); CANCEL secenegini tikliyoruz

        // ve result mesajının "You clicked: Cancel" oldugunu test edin.

        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj ="You clicked: Cancel";
        Assert.assertEquals(expectedMesaj,actualMesaj);
    }
}
