package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver ldriver;

    public LoginPage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver,this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement linkLogout;

    // here writing Actions methods for every element
    public void setUserName(String uname){
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }
    public void setPassword(String pwd){
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }
    public void clickLogin(){
        btnLogin.click();
    }
    public void logout(){
        /*WebDriverWait wait = new WebDriverWait(ldriver,30);
        wait.until(ExpectedConditions.elementToBeClickable(linkLogout));*/
        JavascriptExecutor executor = (JavascriptExecutor) ldriver;
        executor.executeScript("arguments[0].click()",linkLogout);
        //linkLogout.click();
    }
}
