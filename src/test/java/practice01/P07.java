package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P07 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

              // https://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get(" https://the-internet.herokuapp.com/add_remove_elements/");

             // Add Element butonuna 100 defa basınız
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < 100 ; i++) {
            addButton.click();

        }
             // 100 defa basıldığını test ediniz
        List<WebElement>deleteButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteButton.size());

             // 90 defa delete butonuna basınız
        for (int i = 0; i <90 ; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();

        }

        // 90 defa basıldığını doğrulayınız
        //1.yol
//        List<WebElement> deleteButtonList = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
//        int kalanDeleteButton = deleteButton.size()-90;
//        Assert.assertEquals(kalanDeleteButton,deleteButtonList.size());
        //2.yol
        WebElement delete= driver.findElement(By.xpath("//*[@id='elements']"));
        int counter = 0;
        for (int i=0;i<90;i++) {
            delete.click();
            counter++;
        }
        System.out.println(counter);

        // 90 defa basıldığını doğrulayınız
        Assert.assertEquals(90,counter);

        //3.yol
//        List<WebElement> deleteClicked = driver.findElements(By.xpath("//*[@class='added-manually']"));
//        Assert.assertEquals(10, deleteClicked.size());

             // Sayfayı kapatınız
        driver.close();
    }
}
