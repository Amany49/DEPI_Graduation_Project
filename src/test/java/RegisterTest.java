import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    WebDriver driver;
    RegisterPage registerPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        registerPage.createAnAccount().click();
        registerPage.firstNameField().sendKeys("amany");
        registerPage.lastNameField().sendKeys("abdallah");

        registerPage.emailField().sendKeys("test149@gmail.com");
        registerPage.passwordField().sendKeys("Test123456@_");
        registerPage.confirmPasswordField().sendKeys("Test123456@_");

        registerPage.createAccountButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String successMessage = registerPage.successMessage().getText();
        Assert.assertTrue(successMessage.contains("Thank you for registering with Main Website Store."), "Registration failed!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
