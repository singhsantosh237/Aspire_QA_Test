package QA_Aspire;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.commons.lang.RandomStringUtils;

public class QA_Aspire_Locators {

    // Login Id and Passwords

    public static String url = "https://aspireapp.odoo.com/web/login";
    public static String username = "user@aspireapp.com";
    public static String password = "@sp1r3app";
    public static String productName = "QA Test Aspire Tech " + RandomStringUtils.randomNumeric(4);
    String measure = "Units";


//    ###### Xpath #######

    String txtEmail = "//input[@id='login']";

    String txtPwd = "//input[@id='password']";

    String btnLogin = "//button[@class='btn btn-primary btn-block']";

    String btnOpenInventory = "//div[text()='Inventory']";

    String menuProduct = "//button[@title='Products']";

    String subMenuProduct = "//a[text()='Products']";

    String btnCreateProduct = "//button[@class='btn btn-primary o-kanban-button-new']";

    String txtProductName = "//label[text()='Product Name']//following::input[1]";

    String txtCost = "//label[text()='Cost']//following::input[1]";

    String txtSalesPrice = "//label[text()='Sales Price']//following::input[1]";

    String btnSave = "//button[@title='Save record']";

    String btnUpdateQuantity = "//span[text()='Update Quantity']";

    String btnCreateQuantity = "//button[@class='btn btn-primary o_list_button_add']";

    String txtCountedQuantity = "//th[@data-name='user_id']//following::input[3]";

    String btnMainMenu = "//a[@class='fa o_menu_toggle fa-th']";

    String btnOpenManufacturing = "//div[text()='Manufacturing']";

    String btnCreateManufacturing = "//button[@class='btn btn-primary o_list_button_add']";

    String txtProduct = "//label[text()='Product']//following::input[1]";

    String txtQuantity = "//label[text()='Quantity']//following::input[2]";

    String btnAddALine = "//a[text()='Add a line']";

    String txtAddProduct = "//th[text()='Product']//following::input[1]";

    String txtAddtoConsume = "//th[text()='Product']//following::input[2]";

    String btnConfirm = "//button[@name='action_confirm']";

    String btnDiscard = "//span[text()='Discard']";

    String btnValidateButton = "//button[@class='btn btn-primary']";
}
