package day01_Practice;

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

public class C02_DorpDownOptions {

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
    public void test02() {

        // ...Exercise 2...


     // https://www.amazon.com/ sayfasina gidin
     // dropdown'dan "Baby" secenegini secin


        // - 1.adim Locate edilir
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        //2.Select objesi olusturulur.
        Select select = new Select(ddm);

        //3.Opsiyon secilir
        select.selectByVisibleText("Baby");
        //select.selectByValue("search-alias=baby-products-intl-ship");
        // select.selectByIndex(3);


        // sectiginiz option'i yazdirin
        String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("Sectigim Option="+sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptions=select.getOptions();

        int actualOptionsSayisi=tumOptions.size();
        int expectedOptionsSayisi=28;

        Assert.assertEquals(expectedOptionsSayisi,actualOptionsSayisi);
    }
}
