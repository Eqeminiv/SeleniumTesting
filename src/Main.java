import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Main {
    public WebDriver driver;

    @BeforeClass
    public void initialize()
    {
        System.out.println("*************");
        System.out.println("launching");
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test1()
    {
        AjaxFormTests test1 = new AjaxFormTests(driver);
        test1.navigation();

        test1.inputting();
        test1.assertion();

      //  driver.quit();
    }

    @Test
    public void test2()
    {
        CheckboxDemo test2 = new CheckboxDemo(driver);
        test2.navigation();

        test2.singleCheckbox();
        test2.assertionSingle();

        test2.multipleCheckboxes();
        test2.assertionMultiple();

      //  driver.quit();
    }

    @Test
    public void test3()
    {
        InputFormDemo test3 = new InputFormDemo(driver);
        test3.navigation();

        test3.properValuesInputForm();
        test3.assertion();

      //  driver.quit();
    }

    @Test
    public void test4()
    {
        JQueryDropdown test4 = new JQueryDropdown(driver);
        test4.navigation();

        test4.dropdownSearch();
        test4.assertionSearch();

        test4.selectMultiple();
        test4.assertionMultiple();

        test4.dropdownDisabled();
        test4.assertionDisabled();

        test4.dropdownCategories();
        test4.assertionCategories();

       // driver.quit();
    }

    @Test
    public void test5()
    {
        RadioButtonDemo test5 = new RadioButtonDemo(driver);
        test5.navigation();

        test5.oneRadioButton();
        test5.assertionOneButton();

        test5.groupRadioButtons();
        test5.assertionGroupButtons();

      //  driver.quit();
    }

    @Test
    public void test6()
    {
        SelectListDemo test6 = new SelectListDemo(driver);
        test6.navigation();

        test6.selectList();
        test6.assertionSingle();

        test6.multipleChoiceList();
        test6.assertionMultiple();

       // driver.quit();
    }

    @Test
    public void test7()
    {
        SingleInputField test7 = new SingleInputField(driver);
        test7.navigation();

        test7.singleInputField();
        test7.assertionSingle();

        test7.twoInputFields();
        test7.assertionDouble();

       // driver.quit();
    }

    @Test
    public void test8()
    {
        TableFilter test8 = new TableFilter(driver);
        test8.navigation();

        test8.filter();
        test8.assertionFilter();

       // driver.quit();
    }

    @Test
    public void test9()
    {
        TablePagination test9 = new TablePagination(driver);
        test9.navigation();

        test9.checkButtons();
        test9.assertion();

       // driver.quit();
    }

    @Test
    public void test10()
    {
        TableSearch test10 = new TableSearch(driver);
        test10.navigation();

        test10.filterSearch();
        test10.assertionFilterSearch();

        test10.filterSearchWithButton();
        test10.assertionButtonFilter();

        //driver.quit();
    }

    @AfterClass
    public void quit()
    {
        driver.quit();
    }
}