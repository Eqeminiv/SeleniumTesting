import org.openqa.selenium.*;
import org.testng.Assert;

public class TablePagination {
    public WebDriver driver;
    public WebElement element, element2;

    public TablePagination(WebDriver driver) {
        this.driver = driver;
    }

    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/table-pagination-demo.html");
    }

    public void checkButtons(){
        driver.findElement(By.xpath("//a[text()='3']")).click();
        element = driver.findElement(By.xpath("//a[@class='next_link']"));
        element2 = driver.findElement(By.xpath("//a[@class='prev_link']"));

    }
    public void assertion(){
        Assert.assertFalse(element.isDisplayed() && !element2.isDisplayed());
        driver.findElement(By.xpath("//a[text()='1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='5']")).isDisplayed()
                && !(driver.findElement(By.xpath("//td[text()='6']")).isDisplayed()));
    }
}
