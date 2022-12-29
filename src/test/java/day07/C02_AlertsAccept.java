package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
//        uyarıdaki OK butonuna tıklayın
        Thread.sleep(3000);
        driver.switchTo()//degistir
                .alert()//alerte degistir
                .accept();// accept();OK secenegine tiklanir
        Thread.sleep(3000);
//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expextedResult = "You successfully clicked an alert";
        Assert.assertEquals(expextedResult,actualResult);

        //"//*[@onclick='jsAlert()']"
    }
}

