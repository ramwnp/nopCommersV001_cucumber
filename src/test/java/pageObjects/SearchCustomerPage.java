package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver driver;
    WaitHelper waitHelper;
    public SearchCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
     WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(how = How.ID, using = "serchEmail")
    @CacheLookup
    WebElement drpDobMonth;

    @FindBy(how = How.ID, using = "serchEmail")
    @CacheLookup
    WebElement drpDobDay;

    @FindBy(how = How.ID, using = "SearchCompany")
    @CacheLookup
    WebElement txtCompany;

    @FindBy(how = How.XPATH, using = "//select[@id='SelectedCustomerRoleIds']")
    @CacheLookup
    WebElement txtCuctomerRoles;

    @FindBy(how = How.XPATH, using = "//li[@title='Administrators']")
    @CacheLookup
    WebElement listItemAdministrators;

    @FindBy(how = How.XPATH, using = "//li[@title='Registered']")
    @CacheLookup
    WebElement ListItemRegistered;

    @FindBy(how = How.XPATH, using = "//li[@title='Guests']")
    @CacheLookup
    WebElement listItemGuest;

    @FindBy(how = How.XPATH, using = "//li[@title='Vendors']")
    @CacheLookup
    WebElement listItemVendors;

    @FindBy(how = How.XPATH, using = "//button[@id='search-customers']")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement tblSearchResults;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRows;

    @FindBy(how = How.ID, using = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tablecolumns;

    //Actions methods
    public void setEmail(String email){
        waitHelper.waiteForElement(txtEmail,30);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }
    public void setFirstName(String firstName){
        waitHelper.waiteForElement(txtFirstName,30);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        waitHelper.waiteForElement(txtLastName,30);
        txtLastName.clear();
        txtLastName.sendKeys(lastName);
    }
    public void clickSearch(){
        btnSearch.click();
        waitHelper.waiteForElement(btnSearch,30);
    }
    public int getNoOfRows(){
        return tableRows.size();
    }
    public int tableColumns(){
        return tablecolumns.size();
    }
    public boolean searchCustomersByEmailID(String email){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$"+email);
        boolean flag=false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
            System.out.println(emailId+"@$#@@@@@@@@@@@@@@####");
            if (emailId.equals(email)){
                //System.out.println(emailId+"$$$$$$$$$$$$$$$$$$$$$$$"+email);
                flag=true;
            }
        }
        return flag;
    }
}
