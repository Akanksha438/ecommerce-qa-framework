import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
    }

    @Test
    public void testLogin() {
        driver.findElement(By.linkText("Signup / Login")).click();
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));

        emailInput.sendKeys("testuser@example.com");
        passwordInput.sendKeys("testpassword");
        loginBtn.click();

        WebElement loggedInText = driver.findElement(By.xpath("//a[text()='Logged in as']"));
        Assert.assertTrue(loggedInText.isDisplayed(), "Login failed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}