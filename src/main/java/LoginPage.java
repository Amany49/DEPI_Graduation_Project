import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginLink() {
        return driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
    }

    public WebElement emailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField() {
        return driver.findElement(By.xpath("//*[@id=\"pass\"]"));
    }

    public WebElement loginButton() {
        return driver.findElement(By.xpath("//*[@id=\"send2\"]/span"));
    }

    public WebElement errorMessage() {
        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
    }
}
