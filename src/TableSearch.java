import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class TableSearch {
    public WebDriver driver;
    public WebElement element;
    static String filter = "SEO tags";
    static String name = "Zieko";


    public TableSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void navigation()
    {
        driver.navigate().to("http://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }

    public void filterSearch(){
        element = driver.findElement(By.id("task-table-filter"));
        element.sendKeys(filter);
        element = driver.findElement(By.xpath("//td[text()='"+filter+"']"));
    }

    public void assertionFilterSearch(){
        Assert.assertTrue(element.isDisplayed(), filter+" not found");
    }

    public void filterSearchWithButton(){
        element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

        //filter button active?
        while(element.isEnabled() == false)
        {
            driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs btn-filter']")).click();
            if(element.isEnabled() == false)
            {
                System.out.println("Filter button is not working");
                throw new WebDriverException();

            }
        }

        element.sendKeys(name);
        element = driver.findElement(By.xpath("//td[text()='"+name+"']"));
    }

    public void assertionButtonFilter(){
        Assert.assertTrue(element.isDisplayed(), name+" not found");
    }

}
