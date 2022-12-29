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

public class TestCase5 {

    WebDriver driver;
    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com/");
    }
    @After
    public void tearDown () {
        //driver.close();
    }
    @Test
    public void test(){
        //   1. Launch browser
        //   2. Navigate to url 'http://automationexercise.com'
        //   3. Verify that home page is visible successfully
              String actualUrl = driver.getCurrentUrl();
              String expextedUrl ="https://automationexercise.com/";
              Assert.assertEquals(expextedUrl,actualUrl);

        //   4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //   5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUser.isDisplayed());

        //   6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("ugur");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("tastantutor@hotmail.com");

        //   7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //   8. Verify error 'Email Address already exist!' is visible
        WebElement exist = driver.findElement(By.xpath("//*[text()='Email Address already exist!']"));
        Assert.assertTrue(exist.isDisplayed());

    }
}
