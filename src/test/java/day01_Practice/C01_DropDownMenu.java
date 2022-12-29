package day01_Practice;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {


    WebDriver driver;
    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test01() {

        // ...Exercise 1...


       // https://www.amazon.com/ sayfasina gidin
       // dropdown'dan "Books" secenegini secin
          //Dropdown 3 adimda handle edilir

            // - 1.adim Locate edilir
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

           //2.Select objesi olusturulur.
        Select select = new Select(ddm);

           //3.Opsiyon secilir
      select.selectByVisibleText("Books");
        //select.selectByValue("search-alias=stripbooks-intl-ship");
      // select.selectByIndex(5);

       // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);


       // arama sonuclarinin Java icerdigini test edin

        //1.yol
//        WebElement aramaSonucElementi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
//        String aramaSonucYazisi=aramaSonucElementi.getText();
//        Assert.assertTrue(aramaSonucYazisi.contains("java"));
//        System.out.println(aramaSonucYazisi);

        //2.yol
        String java = driver.findElement(By.xpath("//*[@class='sg-col-inner']")).getText();
        System.out.println(java);
    }
}
