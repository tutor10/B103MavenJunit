package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

/*
    @BeforeClass ve @AfterClass notasyonlari sadece static method'lar icin calisir.
@BeforeClass ve @AfterClass kullanirsak olusturdugumuz @Test method'larinin hepsini ayni anda calistirip
en son @AfterClass'i calistiririz.
    Ama sadece @Before ve @After kullanirsak her test icin @Before ve @After'i kullanir.
 */

    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün Testlerden önce çalıştı");
        System.out.println("------------------------------------------");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün Testlerden sonra çalıştı");
        System.out.println("------------------------------------------");
    }
    @Before
    public void setup01(){
        System.out.println("Her Test'ten önce çalışır");
        System.out.println("------------------------------------------");
    }
    @After
    public void teardown01(){
        System.out.println("Her Test'ten sonra çalışır");
        System.out.println("------------------------------------------");
    }
    @Test
    public void test01(){
        System.out.println("Ilk Test");
        System.out.println("------------------------------------------");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
        System.out.println("------------------------------------------");
    }
    @Test
    @Ignore//Eger bir testi calistirmak iztemezsek bu sekilde kullanabiliriz.
    public void test03(){
        System.out.println("Ucuncu Test");
    }
}