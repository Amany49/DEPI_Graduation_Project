import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.loginLink().click();
        loginPage.emailField().sendKeys("test149@gmail.com");
        loginPage.passwordField().sendKeys("Test123456@_");
        loginPage.loginButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://magento.softwaretestingboard.com/", "Login failed!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement myAccountTab = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        Assert.assertTrue(myAccountTab.isDisplayed(), "My Account tab not visible after login!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testInvalidLogin() {
        loginPage.loginLink().click();
        loginPage.emailField().sendKeys("test01@test.com");
        loginPage.passwordField().sendKeys("test123@#");
        loginPage.loginButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String errorMessage = loginPage.errorMessage().getText();
        Assert.assertTrue(errorMessage.contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."), "Error message not displayed!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
