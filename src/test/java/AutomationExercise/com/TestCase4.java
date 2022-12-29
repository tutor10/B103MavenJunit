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

public class TestCase4 {

    WebDriver driver;

    // Eger test sinifinda birden fazla @Test methodu olusturulmussa ,@Before kullanilmasi daha uydundur
    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");

    }

    @After
    public void tearDown() {
        // driver.close();
    }
    @Test
    public void test(){



//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
      String actualUrl = driver.getCurrentUrl();
      String expectedUrl ="https://automationexercise.com/";
      Assert.assertEquals(expectedUrl,actualUrl);

//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

//        5. Verify 'Login to your account' is visible
        WebElement loginaccvis = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        loginaccvis.isDisplayed();

//        6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("tastantutor@hotmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");

//        7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

//        8. Verify that 'Logged in as username' is visible
        WebElement loginvisible1 = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        loginvisible1.isDisplayed();

//        9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
//        10. Verify that user is navigated to login page
        driver.navigate().to("https://automationexercise.com/login");
        WebElement verify = driver.findElement(By.xpath("//*[@href='/login']"));
        verify.isDisplayed();


    }
}
