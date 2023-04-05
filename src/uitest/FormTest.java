import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormTest extends AbstractTest {

    @Test
    public void testContactUsForm() throws InterruptedException {

        driver.get("https://automationexercise.com/contact_us");
        driver.manage().window().fullscreen();
        WebElement nameInput = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(2) > input"));
        nameInput.sendKeys("test");
        WebElement emailInput = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(3) > input"));
        emailInput.sendKeys("test@gmail.com");
        WebElement subjectInput = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(4) > input"));
        subjectInput.sendKeys("subject");
        WebElement messageInput = driver.findElement(By.cssSelector("#message"));
        messageInput.sendKeys("This is the test message");
        WebElement submit = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
            System.out.println("No alert");
        } else {
            System.out.println("Alert present");
        }

        driver.switchTo().alert().accept();

        WebElement message = driver.findElement((By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")));

        Assert.assertEquals("Success! Your details have been submitted successfully.", message.getText());
    }
}
