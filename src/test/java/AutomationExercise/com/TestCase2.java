package AutomationExercise.com;

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

public class TestCase2 {

    WebDriver driver;
    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // driver.get("https://automationexercise.com/");
    }
    @After
    public void tearDown () {
        //driver.close();
    }
    @Test
    public void test(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "https://automationexercise.com/";
//        Assert.assertEquals(expectedUrl,actualUrl);
//
////        4. Click on 'Signup / Login' button
//        driver.findElement(By.xpath("//*[@href='/login']")).click();
//
////        5. Verify 'Login to your account' is visible
//        WebElement loginVisible = driver.findElement(By.xpath("//*[text()='Login to your account']"));
//        Assert.assertTrue(loginVisible.isDisplayed());
//
////        6. Enter correct email address and password
//        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("tastantutor@hotmail.com");
//        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
//
////        7. Click 'login' button
//        driver.findElement(By.xpath("//*[text()='Login']")).click();
//
////        8. Verify that 'Logged in as username' is visible
//        WebElement loginvisible1 = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
//        Assert.assertTrue(loginvisible1.isDisplayed());
////        9. Click 'Delete Account' button
//        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

//        10. Verify that 'ACCOUNT DELETED!' is visible
        driver.get("https://automationexercise.com/delete_account");
        WebElement deleteVisible = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(deleteVisible.isDisplayed());

        driver.findElement(By.xpath("//*[text()='Continue']")).click();


    }
}
