package practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02 extends TestBase {

    @Test
    public void test01(){

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);


        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//img"));

        //emojiler.stream().forEach(t->t.click());//Lambda ile tum webelementleri tikladik

        for(WebElement w : emojiler){
            w.click();
        }

        // parent iframe e geri donun
        //driver.switchTo().defaultContent();
        driver.navigate().refresh();
        //driver.switchTo().parentFrame();
        //driver.navigate().refresh();

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Ugur");
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> veriler = new ArrayList<>(Arrays.asList(
                "Ugur","Tastan","selenium","lambda","java","sql","gitgithub","fsd","dfasf","lkjl","asdasd","asd","sda"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

//        //2.yol
//        List<WebElement> forum=driver.findElements(By.xpath("(//input[@class='mdl-textfield__input'])"));
//        List <String> inputTexts = new ArrayList<>(Arrays.asList("Hello World!", "Merhaba Javacanlar", "Turkey" ,"Kebab", "Java ile Hayat Cok Guzel", "İstanbul", "Adam" ,"58" , "34", "63", "63"));
//        for (int i = 0; i <inputTexts.size() ; i++) {
//            forum.get(i).sendKeys(inputTexts.get(i));
//        }

        //  apply button a basin
        driver.findElement(By.xpath("//*[text()='Apply']")).click();
    }
}
