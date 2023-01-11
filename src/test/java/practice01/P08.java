package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {

    WebDriver driver;
    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com");
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01() {

//        https://www.google.com/ adresine gidin
//        cookies uyarisini kabul ederek kapatin

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        //1.yol
        String actualTitle = driver.getTitle();
        String expectedTitle ="Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //2.yol if ile
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Google";
//        if (actualTitle.contains(expectedTitle)) {
//            System.out.println("PASSED");
//        } else
//            System.out.println("FAILED");



//        Arama cubuguna “Nutella” yazip aratin
        //1.yol
        WebElement arama = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        arama.sendKeys("Nutella", Keys.ENTER);
        //2.yol
        //driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella",Keys.ENTER);

//        Bulunan sonuc sayisini yazdirin
        //1.yol
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());

        //2.yol
        String [] sonucSayisi1 = driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi1[1];
        System.out.println("Sonuc Sayisi="+sonuc);

//        sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("\\D","");//ReplaceAll methodu ile \\D 'i kullanarak butun noktalama isaretlerini hiclik ile degistir
        int istenenSayi =10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

        //        Sayfayi kapatin
        driver.close();
    }
}
