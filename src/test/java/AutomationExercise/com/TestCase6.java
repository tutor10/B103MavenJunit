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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase6 {

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
    public void tearDown() {
        // driver.close();
    }
    @Test
    public void test(){


//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

//        4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

//        5. Verify 'GET IN TOUCH' is visible
        WebElement getTouchVisible = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(getTouchVisible.isDisplayed());

//        6. Enter name, email, subject and message
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Ugur");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("tastantutor@hotmail.com");
        driver.findElement(By.xpath("//*[@name='subject']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@id='message']")).sendKeys("Hello World");

//        7. Upload file

   WebElement chooseFile = driver.findElement(By.xpath("//*[@type='file']"));
      chooseFile.sendKeys("C:\\SeleniumLMS.pdf");
//        8. Click 'Submit' button
//        9. Click OK button
//        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//        11. Click 'Home' button and verify that landed to home page successfully
//

    }
}
