package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Sorular:
        // 1_ TekrarTesti isimli bir class olusturun
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek ?
        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("PASSED");
        } else
            System.out.println("FAILED");

        // 5- Arama cubuguna “Nutella” yazip aratin
        WebElement arama = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        arama.sendKeys("Nutella", Keys.ENTER);

        //driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella",Keys.ENTER);

        // 6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucSayisi.getText());

        // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        // 8- Sayfayi kapatin
    }
}