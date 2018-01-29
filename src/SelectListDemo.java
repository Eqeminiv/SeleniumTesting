import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectListDemo {

    public WebDriver driver;
    public WebElement element;
    public static String day = "Wednesday";
    public static String[] states = {"Ohio","Florida","Washington"};;
    public Actions action;
    Select select;

    public SelectListDemo(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

    public void selectList(){
        element = driver.findElement(By.id("select-demo"));
        element.click();
        element = driver.findElement(By.xpath("//option[@value='"+day+"']"));
        element.click();
        element = driver.findElement(By.xpath("//p[@class='selected-value']"));
    }

    public void assertionSingle(){
        Assert.assertEquals(element.getText(),"Day selected :- "+day);
    }

    public void multipleChoiceList(){
        //action.keyDown(Keys.LEFT_CONTROL).click(driver.findElement(By.xpath("//option[@value='"+states[0]+"']")))
       //         .click(driver.findElement(By.xpath("//option[@value='"+states[1]+"']")))
       //         .click(driver.findElement(By.xpath("//option[@value='"+states[2]+"']")))
        //        .keyUp(Keys.LEFT_CONTROL);

        element = driver.findElement(By.id("multi-select"));
        select = new Select(element);

        for(int i=0;i<3;i++)
        {
            select.selectByValue(states[i]);
        }

        for(WebElement elem : select.getAllSelectedOptions())
        {
            System.out.println(elem.getText());
        }

    }
    public void assertionMultiple(){
        driver.findElement(By.id("printMe")).click();
        element = driver.findElement(By.xpath("//p[@class='getall-selected']"));
        Assert.assertEquals(element.getText(),"First selected option is : "+states[0]);
        driver.findElement(By.id("printAll")).click();
        Assert.assertEquals(element.getText(),"Options selected are : "+states[0]+","+states[1]+","+states[2]);
    }

}
