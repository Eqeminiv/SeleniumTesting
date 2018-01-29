import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InputFormDemo {
    public WebDriver driver;
    public WebElement element;
    static String firstName = "John";
    static String lastName = "Kentucky";
    static String email = "as@s";
    static String phone = "2313132312";
    static String address = "9/11; Manhattan";
    static String city = "New York";
    static String state = "New York";
    static String zipCode = "1234";
    static String website = "google.com";
    static String projectDescription = "Example description";

    public InputFormDemo(WebDriver driver){
        this.driver = driver;
    }

    public void navigation()
    {
        driver.navigate().to("http://www.seleniumeasy.com/test/input-form-demo.html");
    }

    public void properValuesInputForm(){
        inputText(firstName, "first_name");
        inputText(lastName, "last_name");
        inputText(email, "email");
        inputText(phone, "phone");
        inputText(address, "address");
        inputText(city, "city");
        inputText(zipCode, "zip");
        inputText(website,"website");
        inputText(projectDescription, "comment");
        driver.findElement(By.name("state")).click();
        driver.findElement(By.xpath("//option[text()='"+state+"']")).click();
        element = driver.findElement(By.xpath("//button[@type='submit']"));

    }

    public void assertion()
    {
        Assert.assertNotEquals((element.getAttribute("disabled")),"disabled");
    }

    public void inputText(String text, String name){
        driver.findElement(By.name(name)).sendKeys(text);
    }

}
