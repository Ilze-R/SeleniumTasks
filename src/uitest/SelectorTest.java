import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectorTest extends AbstractTest {

    @Test
    public void testSignInText() {
        WebElement signInElement = driver.findElement(By.xpath("//a[@href='/login']"));
        Assert.assertEquals("Signup / Login", signInElement.getText());
   }

    @Test
    public void testTShirtPrice(){
        List<WebElement> listOfItems = driver.findElements(By.cssSelector(".productinfo.text-center"));
        for (WebElement item : listOfItems) {
            if ("GRAPHIC DESIGN MEN T SHIRT - BLUE".equals(item.findElement(By.tagName("p")).getText())) {
                Assert.assertTrue(item.findElement(By.tagName("h2")).getText().contains("1389"));
                break;
            }
        }
    }

    @Test
    public void contactEmailAddress(){
        driver.get("https://automationexercise.com/contact_us");
        WebElement linkElement = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-4 > div > address > p:nth-child(3) > a > u"));
        Assert.assertTrue("feedback@automationexercise.com".equals(linkElement.getText()));
    }

}
