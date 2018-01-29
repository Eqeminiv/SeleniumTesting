import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SingleInputField {
    public WebDriver driver;
    public WebElement element;
    public String text;
    public int num1;
    public int num2;

    public SingleInputField(WebDriver driver){
        this.driver = driver;
        text = "Example";
        num1 = 2;
        num2 = 3;
    }

    public void navigation(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    public void singleInputField(){

        element = driver.findElement(By.id("user-message")) ;
        element.sendKeys(text);
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='showInput();']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@id='display']"));

    }

    public void assertionSingle(){
        Assert.assertEquals(element.getText(),text);
    }

    public void twoInputFields(){
        element = driver.findElement(By.id("sum1"));
        element.sendKeys(String.valueOf(num1));
        element = driver.findElement(By.id("sum2"));
        element.sendKeys(String.valueOf(num2));
        element = driver.findElement(By.xpath("//button[@type='button' and @onclick='return total()']"));
        element.click();
        element = driver.findElement(By.xpath("//span[@id='displayvalue']"));
    }

    public void assertionDouble(){
        Assert.assertEquals(element.getText(), String.valueOf(num1+num2));
    }
}
