package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest(){
//EN FAZLA SURUKLEMEK ICIN KULLANILAN METHOD BUDUR

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(0);

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        WebElement hedef = driver.findElement(By.id("droppable"));

        //dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();
        waitFor(3);

    }
    @Test
    public void clickAndHoldTest(){


//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(0);

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        WebElement hedef = driver.findElement(By.id("droppable"));

        //dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//KAYNAGI TUT
                .moveToElement(hedef)//HEDEFE KOY
                .release()//KAYNAGI BIRAK
                .build()//onceki methodlarin iliskisini kur/guclendir.KULLANILMASI TERCIH EDILIR
                .perform();//islemi gerceklestir
    }
    @Test
    public void moveByOffsetTest(){

//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //KAYNAK VE HEDEF ELEMENTLERI IFRAME IN ICINDE
        driver.switchTo().frame(0);

//        And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        //dragAndDrop() surukleme islemini gerceklestirir
        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)//KAYNAGI TUT
                .moveByOffset(430,30)
                .release()//KAYNAGI BIRAK
                .build()
                .perform();

    }
}
