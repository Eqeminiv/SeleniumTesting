import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckboxDemo {
    public WebDriver driver;
    public WebElement element;


    public CheckboxDemo(WebDriver driver){
        this.driver = driver;
    }

    public void navigation()
    {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }
    public void singleCheckbox(){

        element = driver.findElement(By.id("isAgeSelected"));
        element.click();
        element = driver.findElement(By.xpath("//div[contains(@id,'txtAge') and not(contains(@style,'display: none;'))]"));
    }

    public void assertionSingle(){
        Assert.assertTrue(driver.findElement(By.id("txtAge")).getText().equals("Success - Check box is checked"));
    }

    public void multipleCheckboxes() {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        element = driver.findElement(By.xpath("//label[text()='Option 1']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 2']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 3']"));
        element.click();
        element = driver.findElement(By.xpath("//label[text()='Option 4']"));
        element.click();
        element = driver.findElement(By.id("isChkd"));
        element = driver.findElement(By.xpath("//label[text()='Option 4']"));
        element.click();
        element = driver.findElement(By.id("isChkd"));


    }
    public void assertionMultiple(){
        Assert.assertFalse(element.getAttribute("value").equals("true"));
    }

}
