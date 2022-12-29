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

import java.time.Duration;

public class C03_RadioButton {

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
    public void test03() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // radiobutton elementlerini locate edin
        WebElement radioOption1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radioOption2 = driver.findElement(By.id("vfb-7-2"));
        WebElement radioOption3 = driver.findElement(By.id("vfb-7-3"));

        // option2'yi secin
        radioOption2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(radioOption2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioOption1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(radioOption3.isSelected());


    }
}
