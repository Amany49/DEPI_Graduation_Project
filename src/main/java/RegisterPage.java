import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement createAnAccount() {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
    }

    public WebElement firstNameField() {
        return driver.findElement(By.id("firstname"));
    }

    public WebElement lastNameField() {
        return driver.findElement(By.id("lastname"));
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email_address"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.xpath("//*[@id=\"password\"]"));
    }

    public WebElement confirmPasswordField() {
        return driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
    }

    public WebElement createAccountButton() {
        return driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
    }

    public WebElement successMessage() {
        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
    }
}
