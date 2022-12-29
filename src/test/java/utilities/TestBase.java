package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public abstract class TestBase {
    // TestBase i abstarct yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
    // TestBase testBase = new TestBase();->YAPILAMAZ
    // Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak

    //    driver objesini olustur. Driver ya public yada protected olmali.
    //    Sebepi child classlarda gorulebilir olmasi
    protected static WebDriver driver;

    //    setUp
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    //tearDown
    @After
    public void tearDown(){
       // driver.quit();
    }



}