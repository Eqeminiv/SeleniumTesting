import org.openqa.selenium.*;
import org.testng.Assert;


public class TableFilter {
    public WebDriver driver;
    public WebElement element, element2, element3;

    public TableFilter(WebDriver driver) {
        this.driver = driver;
    }

    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/table-records-filter-demo.html");
    }

    public void filter(){
        driver.findElement(By.xpath("//button[@data-target='pagado']")).click();
        element = driver.findElement(By.xpath("//tr[@data-status='pendiente']"));
        element2 = driver.findElement(By.xpath("//tr[@data-status='pagado']"));
        element3 = driver.findElement(By.xpath("//tr[@data-status='cancelado']"));
    }

    public void assertionFilter(){
        Assert.assertTrue(!element.isDisplayed() && element2.isDisplayed() && !element3.isDisplayed());
    }
}
