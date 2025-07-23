package stepDefinitions;

import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("User Launch Crome browser")
    public void user_Launch_Crome_browser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        lp=new LoginPage(driver);
    }

    @When("user opens URL {string}")
    public void user_opens_URL(String url) {
        driver.get(url);
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

}
