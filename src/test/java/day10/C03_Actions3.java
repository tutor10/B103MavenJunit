package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown(){

       // Method : scrollUpDown()

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

            //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);

//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        waitFor(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//
//        actions
//                .sendKeys(Keys.PAGE_DOWN)
//                .sendKeys(Keys.PAGE_DOWN)
//                .sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        waitFor(3);


        //ARROW_DOWN PAGE_DOWN dan daha az mesafe aldirir
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(3);

        //Sonra sayfanin ustune dogru gidelim
        //YUKARI CIK
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(3);

        //YUKARI CIK
        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(3);
//        actions.sendKeys(Keys.ARROW_RIGHT).perform();
//        actions.sendKeys(Keys.ARROW_LEFT).perform();
    }
}
