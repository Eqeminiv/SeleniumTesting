import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RadioButtonDemo {

    public WebDriver driver;
    public WebElement element;


    public RadioButtonDemo(WebDriver driver) {
        this.driver = driver;
    }

    public void navigation() {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    }

    public void oneRadioButton() {

        element = driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
        element.click();
        element = driver.findElement(By.id("buttoncheck"));
        element.click();
        element = driver.findElement(By.xpath("//p[@class='radiobutton']"));
    }

    public void assertionOneButton() {
        Assert.assertEquals(element.getText(), "Radio button 'Male' is checked");
    }

    public void groupRadioButtons() {
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        element = driver.findElement(By.xpath("//input[@value='Female' and @name='gender']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@value='15 - 50' and @name='ageGroup']"));
        element.click();
        element = driver.findElement(By.xpath("//button[@onclick='getValues();' and @type='button']"));
        element.click();
        element = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));

    }

    public void assertionGroupButtons() {
        Assert.assertEquals(element.getText(), "Sex : Female\nAge group: 15 - 50");
    }

}
