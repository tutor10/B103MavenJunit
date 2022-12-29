package AutomationExercise.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase1 {

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
        // driver.close();
    }

    @Test
    public void testCase() {
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        driver.get("https://automationexercise.com/");
//
//
////        3. Verify that home page is visible successfully
//        String actualUrl = driver.getCurrentUrl();
//        String expectedUrl = "https://automationexercise.com/";
//        Assert.assertEquals(expectedUrl, actualUrl);
//

//        4. Click on 'Signup / Login' button
        //       driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
//
//
////        5. Verify 'New User Signup!' is visible
//        WebElement visibleSign = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
//        Assert.assertTrue(visibleSign.isDisplayed());
//
//
////        6. Enter name and email address
//        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Ugur Tastan");
//        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("tastantutor@hotmail.com");
//
//
////        7. Click 'Signup' button
//        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
//
////        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//        WebElement enterAccInfo = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
//        Assert.assertTrue(enterAccInfo.isDisplayed());
//
////        9. Fill details: Title, Name, Email, Password, Date of birth
//        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();
//        //driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Ugur Tastan");
//        //driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("tastantutor@hotmail.com");
//        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
////        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("7");
////        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("May");
////        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1982");
//
//        //  WITH DROPDOWN METHOD
//        //Day
//        WebElement day = driver.findElement(By.xpath("//*[@id='days']"));
//        Select dayDropdown = new Select(day);
//        dayDropdown.selectByVisibleText("7");
//
//        //Month
//        WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
//        Select monthDropdown = new Select(month);
//        monthDropdown.selectByVisibleText("May");
//
//        //Year
//        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
//        Select yearDropdown = new Select(year);
//        yearDropdown.selectByVisibleText("1982");
//
////        10. Select checkbox 'Sign up for our newsletter!'
//        driver.findElement(By.cssSelector("input[id='newsletter']")).click();
//
////        11. Select checkbox 'Receive special offers from our partners!'
//        driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
//
//
//        //ADDRESS INFORMATION is visible?
//        WebElement addressVisible = driver.findElement(By.xpath("//*[text()='Address Information']"));
//        Assert.assertTrue(addressVisible.isDisplayed());
//
//        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Ugur");
//
//        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Tastan");
//
//        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("HNF");
//
//        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(" 404 E South St");
//
//        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Jackson");
//
//        //driver.findElement(By.cssSelector("select[id='country']")).sendKeys("United States");
//
//        // country with dropdown method
//        WebElement country = driver.findElement(By.cssSelector("select[id='country']"));
//        Select countryDropdown = new Select(country);
//        countryDropdown.selectByVisibleText("United States");
//
//        driver.findElement(By.cssSelector("input[id='state']")).sendKeys("Mississippi");
//
//        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Mississippi");
//
//        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys(" MS 39201");
//
//        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("+1 800-275-8777");
//
//
////           13. Click 'Create Account button'
//        driver.findElement(By.xpath("//*[text()='Create Account']")).click();


//        14. Verify that 'ACCOUNT CREATED!' is visible
//        WebElement accCreatVisible = driver.findElement(By.xpath("//*[text()='Account Created!']"));
//        Assert.assertTrue(accCreatVisible.isDisplayed());
//
////        15. Click 'Continue' button
//        driver.findElement(By.xpath("//*[text()='Continue']")).click();
//
//        WebElement loginVisible= driver.findElement(By.xpath("//*[text()='Login to your account']"));
//        Assert.assertTrue(loginVisible.isDisplayed());
//
//        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("tastantutor@hotmail.com");
//        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
//        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
//
////        16. Verify that 'Logged in as username' is visible
//        WebElement loginAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
//        Assert.assertTrue(loginAs.isDisplayed());
////        17. Click 'Delete Account' button
//        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        driver.get("https://automationexercise.com/delete_account");
        WebElement deleteVisible = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(deleteVisible.isDisplayed());

        driver.findElement(By.xpath("//*[text()='Continue']")).click();



    }

}