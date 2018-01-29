import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AjaxFormTests {
    WebDriver driver;
    public static long tolerance;

    public AjaxFormTests(WebDriver driver) {
        this.driver = driver;
        tolerance = 3000;
    }

    public void navigation()
    {
        driver.navigate().to("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
    }

    public void inputting(){
        driver.findElement(By.id("btn-submit")).click();
        driver.findElement(By.id("title")).sendKeys("Name");
        driver.findElement(By.id("description")).sendKeys("Comment");
        driver.findElement(By.id("btn-submit")).click();
        try{
            Thread.sleep(tolerance);
        }catch(InterruptedException ie){}
    }

    public void assertion(){
        Assert.assertTrue(driver.findElement(By.id("submit-control")).getText().equals("Form submited Successfully!"));
    }
}
