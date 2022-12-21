package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();

        //3.Login alanine “username” yazdirin
        WebElement login= driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        //4.Password alanine “password” yazdirin
        WebElement password= driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();

        //6. Online banking butonuna basiniz sonra Pay Bills sayfasina gidin
        //<strong>Online Banking</strong>
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        //<span class="headers" id="pay_bills_link">Pay Bills</span>
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //<input type="text" id="sp_amount" name="amount" class="span1" required="required" autocomplete="off">
        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("500");

        //8.tarih kismina “2020-09-10” yazdirin
        //<input type="text" id="sp_date" name="date" class="span4 hasDatepicker" required="required" autocomplete="off">
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        // Sayfayı kapatınız
        driver.close();

    }
}