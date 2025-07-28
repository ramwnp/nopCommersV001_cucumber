package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Base {
    public WebDriver driver;
    public LoginPage lp;
    public AddCustomerPage addCust;
    public SearchCustomerPage searchCustomerPage;

    //created for generate randome string for unique email-ID
    public static String randomString(){
       String generatedString1 =RandomStringUtils.randomAlphabetic(5);
        return generatedString1;
    }
}
