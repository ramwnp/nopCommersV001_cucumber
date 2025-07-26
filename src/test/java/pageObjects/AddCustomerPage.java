package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {
    WebDriver ldriver;

    public AddCustomerPage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver,this);
    }
    //Elements capture
    By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']");
    By btnAddNew = By.xpath("//a[normalize-space()='Add new']");
    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");
    By txtCustomerRoles = By.xpath("//select[@id='SelectedCustomerRoleIds']");
    By lstitemAdministrators = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-h39a-1']");////li[@title='Administrators']

    By lstitemRegistered = By.xpath("//li[@title='Registered']");
    By lstitemGuests = By.xpath("//li[@title='Guests']");
    By lstitemVendors = By.xpath("//li[@title='Vendors']");
    By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");
    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");
    //By txtDob = By.xpath("");
    By txtCompanyName = By.xpath("//input[@id='Company']");
    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
    By btnSave = By.xpath("//button[@name='save']");

    //Actions Methods
    public String getPageTitile(){
        return ldriver.getTitle();
    }
    public void clickOnCustomersMenu(){
        ldriver.findElement(lnkCustomers_menu).click();
    }
    public void clickOnCustomersMenuItem(){
        ldriver.findElement(lnkCustomers_menuitem).click();
    }
    public void clickOnAddNewButton(){
        ldriver.findElement(btnAddNew).click();
    }

    //customer info
    public void setEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }
    public void setCustomerRoles(String role) throws InterruptedException {
        /*if (!role.equals("Vendors")){
            ldriver.findElement(By.xpath(""));
        }*/
        WebElement drpCusRolelistItem=ldriver.findElement(txtCustomerRoles);
        Select drpCusRole = new Select(drpCusRolelistItem);
        WebElement listItem;
        Thread.sleep(3000);
        if (role.equals("Administrators")){
            Thread.sleep(3000);
            //listItem = ldriver.findElement(lstitemAdministrators);
            drpCusRole.selectByVisibleText("Administrators");
        }else if (role.equals("Registered")){
            //listItem = ldriver.findElement(lstitemRegistered);
            drpCusRole.selectByVisibleText("Registered");
        }else if (role.equals("Guests")){
            //listItem = ldriver.findElement(lstitemGuests);
            drpCusRole.selectByVisibleText("Guests");
        } else  if (role.equals("Vendors")) {
            //listItem = ldriver.findElement(lstitemVendors);
            drpCusRole.selectByVisibleText("Vendors");
        }else {
            //listItem = ldriver.findElement(lstitemGuests);
            drpCusRole.selectByVisibleText("Guests");
        }
         //listItem.click(); /*use this or us the JavascriptExecutor for execution*/
        /*JavascriptExecutor executor = (JavascriptExecutor) ldriver;
        executor.executeScript("arguments[0].click();",listItem);*/
        /*WebDriverWait wait = new WebDriverWait(ldriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(listItem));*/
    }

    public void setManagerOfVendor(String value){
        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }
    public void setGender(String gender){
        if (gender.equals("Male")){
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            ldriver.findElement(rdFemaleGender).click();
        }else {
            ldriver.findElement(rdMaleGender).click();//default
        }
    }
    public void setFirstName(String fName){
        ldriver.findElement(txtFirstName).sendKeys(fName);
    }
    public void setLastName(String lName){
        ldriver.findElement(txtLastName).sendKeys(lName);
    }
    public void setCompanyName(String companyName){
        ldriver.findElement(txtCompanyName).sendKeys(companyName);
    }
    public void setAdminContent(String adminContent){
        ldriver.findElement(txtAdminContent).sendKeys(adminContent);
    }
    public void clickOnSaveButton(){
        ldriver.findElement(btnSave).click();
    }
    public void userCanViewConfirmationMessage(String string){

    }
}
