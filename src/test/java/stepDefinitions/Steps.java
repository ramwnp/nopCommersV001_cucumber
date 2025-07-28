package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends Base{

    @Given("User Launch Crome browser")
    public void user_Launch_Crome_browser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        lp=new LoginPage(driver);
    }

    @When("user opens URL {string}")
    public void user_opens_URL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("user enters Email as {string} and password as {string}")
    public void user_enters_Email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_Login() {
        lp.clickLogin();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("user click on Logout link")
    public void user_click_on_Logout_link() throws InterruptedException {
        lp.logout();
        //Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    //Cutomer feature step definitions....

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() {
        addCust =new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitile());
    }

    @When("User Click on customers menu")
    public void user_Click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();
    }

    @When("click on customers menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        addCust.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        addCust.clickOnAddNewButton();
        Thread.sleep(2000);
    }

    @Then("user can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitile());
    }

    @When("user enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        String email = randomString()+"@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("test123");

        //Registered default
        //the customer can not be in both 'Guests' and 'Registered role
        // Add the customer to 'Guests' or 'Registered' customer role
        addCust.setCustomerRoles("Vendors");
        Thread.sleep(3000);
        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("RAM");
        addCust.setLastName("Gannoj");
        addCust.setCompanyName("busyQA");
        addCust.setAdminContent("This is for testing");
    }

    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
        addCust.clickOnSaveButton();
        Thread.sleep(2000);
    }

    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully."));
    }

    //steps for searching a customer by using EmailID..........
    @When("enter Customer EmailID")
    public void enter_Customer_EmailID() {
        searchCustomerPage = new SearchCustomerPage(driver);
        searchCustomerPage.setEmail("arthur_holmes@nopCommerce.com");
    }

    @When("click On Search Button")
    public void click_On_Search_Button() throws InterruptedException {
        Thread.sleep(5000);
        searchCustomerPage.clickSearch();
    }

    @Then("user Should Found Email In Search Table")
    public void user_Should_Found_Email_In_Search_Table() {
        boolean status = searchCustomerPage.searchCustomersByEmailID("arthur_holmes@nopCommerce.com");
        System.out.println("33333333333333"+status);
        Assert.assertEquals(true,status);
    }
}
