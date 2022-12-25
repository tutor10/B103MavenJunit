package day05_JUnit;

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

public class C07_Assertion {
    //assertTrue(True)--->Passed
    // assertTrue(False)--->Failed

    //assertFalse(False)--->Passed
    // assertFalse(True)--->Failed
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2)https://www.amazon.com adresinegidin
        driver.get("https://www.amazon.com");//sadece bir url ye gidecegi icin before icine yazabiliriz
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01(){
        //1)Bir class oluşturun:YoutubeAssertions


        //3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin

        //○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
        String actualTitle= driver.getTitle();
        String expectedTitle="Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
    @Test
    public void test02(){

        //○ image Test => amazon resminin görüntülendiğini (isDisplayed()) testedin
        WebElement sayfaResmi= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());

    }
    @Test
    public void test03(){
        //○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04(){
        //○ wrongTitleTest => Sayfa basliginin “amazon” olmadigini dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

}








