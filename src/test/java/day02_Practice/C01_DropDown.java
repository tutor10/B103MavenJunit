package day02_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.ServiceLoader;

public class C01_DropDown {
    //** INTERVIEW QUESTION ** implicitlyWait() nereden gelir? -> Selenium
//                         Thread.sleep() nereden gelir -> Java

    WebDriver driver;

    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {


        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın

          // DropDown 3 adimla Handole edilir.

        //1-DropDown locate edilir
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        //2-select objesi olusturulur
        Select select = new Select(ddm);
        // 3-opsiyonu secilir
        select.selectByIndex(1);

        //print edelim
        //System.out.println(select.getFirstSelectedOption().getText());
        String sectigimOptionIndex =select.getFirstSelectedOption().getText();
        System.out.println("SECTIGIM  OPTION INDEX="+sectigimOptionIndex);

        Thread.sleep(3000);

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigimOptionValue=select.getFirstSelectedOption().getText();
        System.out.println("SECTIGIM OPTION VALUE="+sectigimOptionValue);

        Thread.sleep(3000);

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionVisible = select.getFirstSelectedOption().getText();
        System.out.println("SECTIGIM OPTION VISIBLE="+sectigimOptionVisible);

        // Tüm option'ları yazdırın
        List<WebElement> tumOpsiyonlar=select.getOptions();

        int sayac=1;
        for (WebElement  w:tumOpsiyonlar) {
            System.out.println(sayac+".Option-"+w.getText());
            sayac++;
        }


        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
          //1.yol
        int expected = 3;
        int actual=tumOpsiyonlar.size();

        Assert.assertEquals(expected,actual);

        //2.yol
        int sayi=tumOpsiyonlar.size();
        Assert.assertEquals(sayi,tumOpsiyonlar.size());
    }


}