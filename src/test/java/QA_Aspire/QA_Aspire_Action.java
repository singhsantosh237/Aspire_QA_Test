package QA_Aspire;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QA_Aspire_Action extends QA_Aspire_Locators {

    static WebDriver driver = null;


    public void WaitDriver(int i) {
        driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void BeginTheTest() throws Exception {
        try {
            String projectpath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectpath + "/Driver/chromedriver");
        } catch (Exception e) {
            String projectpath = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver", projectpath + "\\Driver\\chromedriver");
        }
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

//    Login into The Application

    @Test
    public void TestCaseA_loginToWebApplication() throws Exception {
        try {
            driver.findElement(By.xpath(txtEmail)).sendKeys(username);
            driver.findElement(By.xpath(txtPwd)).sendKeys(password);
            driver.findElement(By.xpath(btnLogin)).click();
            WaitDriver(5);
        } catch (Exception e) {
            System.out.println("Exception is" + e);
        }
    }

//    Open The Inventory

    @Test
    public void TestCaseB_openInventory() throws Exception {
        driver.findElement(By.xpath(btnOpenInventory)).click();
        WaitDriver(3);
    }

//    Create A New Product

    @Test
    public void TestCaseC_createANewProduct() throws Exception {
        WaitDriver(3);
        driver.findElement(By.xpath(menuProduct)).click();
        WaitDriver(3);
        driver.findElement(By.xpath(subMenuProduct)).click();
        WaitDriver(3);
        driver.findElement(By.xpath(btnCreateProduct)).click();
        WaitDriver(10);
        driver.findElement(By.xpath(txtProductName)).sendKeys(productName);
        WaitDriver(3);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtCost)).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.xpath(txtCost)).sendKeys("30");
        WaitDriver(3);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtSalesPrice)).sendKeys(Keys.BACK_SPACE);
        }
        WaitDriver(3);
        driver.findElement(By.xpath(txtSalesPrice)).sendKeys("50");
        WaitDriver(2);
        driver.findElement(By.xpath(btnSave)).click();
        Thread.sleep(5000);
    }

//    Update the Quantity

    @Test
    public void TestCaseD_updateTheQuantity() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement button = driver.findElement(By.xpath(btnUpdateQuantity));
        js.executeScript("arguments[0].click();", button);
        WaitDriver(3);
        driver.findElement(By.xpath(btnCreateQuantity)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(txtCountedQuantity)).click();
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtCountedQuantity)).sendKeys(Keys.BACK_SPACE);
        }
        WaitDriver(15);
        driver.findElement(By.xpath(txtCountedQuantity)).sendKeys("100");
        WaitDriver(3);
        driver.findElement(By.xpath(btnSave)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(btnMainMenu)).click();
        WaitDriver(3);
    }

//    Open the Manufacturer

    @Test
    public void TestCaseE_openManufacturing() throws Exception {
        driver.findElement(By.xpath(btnOpenManufacturing)).click();
        WaitDriver(5);
    }

//    Crete Manufacturing

    @Test
    public void TestCaseF_createManufacturing() throws Exception {
        driver.findElement(By.xpath(btnCreateManufacturing)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(txtProduct)).sendKeys(productName);
        Thread.sleep(2000);
        driver.findElement(By.xpath(txtProduct)).sendKeys(Keys.ENTER);
        WaitDriver(3);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtQuantity)).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(By.xpath(txtQuantity)).sendKeys("100");
        WaitDriver(3);
        try {
            driver.findElement(By.xpath(btnDiscard)).click();
            WaitDriver(3);
            driver.findElement(By.xpath(txtProduct)).sendKeys(productName);
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println("Same Product is there");
        }
    }

//    Add Manufacturing Details

    @Test
    public void TestCaseG_addTheDetalis() throws Exception {
        driver.findElement(By.xpath(btnAddALine)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(txtAddtoConsume)).click();
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtAddtoConsume)).sendKeys(Keys.BACK_SPACE);
        }
        WaitDriver(15);
        driver.findElement(By.xpath(txtAddtoConsume)).sendKeys("100");
        Thread.sleep(2000);
        driver.findElement(By.xpath(txtAddProduct)).click();
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath(txtAddProduct)).sendKeys(Keys.BACK_SPACE);
        }
        WaitDriver(15);
        driver.findElement(By.xpath(txtAddProduct)).sendKeys(productName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(txtAddProduct)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnConfirm)).click();
        Thread.sleep(2000);
    }

//    Validate The Details

    @Test
    public void TestCaseH_validateTheDetalis() throws Exception {
        driver.findElement(By.xpath("//label[text()='Quantity']//following::input[1]")).click();
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//label[text()='Quantity']//following::input[1]")).sendKeys(Keys.BACK_SPACE);
        }
        WaitDriver(15);
        driver.findElement(By.xpath("//label[text()='Quantity']//following::input[1]")).sendKeys("100");
        WaitDriver(5);
        driver.findElement(By.xpath(btnSave)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(btnValidateButton)).click();
        Thread.sleep(2000);
        String finalStatus = driver.findElement(By.xpath("//div[@title='Open profile']//following::div[8]")).getText();
        System.out.println("Final status is:" + finalStatus);
        Assert.assertEquals(finalStatus,"Done");
    }

    @AfterTest
    public void TearDownTest() {
        driver.close();
    }

}
