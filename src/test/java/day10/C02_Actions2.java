package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    /*
    * MANUAL:
    * Amazon home sayfasina git
    * Account & List e uzerinde bekle
    * Acilan pencerede Account linkine tikla
    * Acilan sayfanin title nin Your Account oldugunu dogrula
    */
    @Test
    public void hoverOverTest(){
        //Amazon sayfasina git
        driver.get("https://www.amazon.com");

            //Account & List e uzerinde bekle -mouse over -hover over
        // 1.ACTIONS OBJESI
        Actions actions = new Actions(driver);

        //2.ELEMANI BUL
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        waitFor(1);

        //3.UYGUN ACTIONS METHODUNU KULLAN ,  SONRA PERFORM() KULLAMAYI UNUTMA
        actions.moveToElement(accountList).perform();
        waitFor(2);

        //Acilan pencerede Account linkine tikla
        driver.findElement(By.linkText("Account")).click();

        //Acilan sayfanin title nin "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
