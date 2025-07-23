Feature: Login
  Scenario: Succesfull Login with Valid Credentials
    Given User Launch Crome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on Logout link
    Then page title should be "nopCommerce demo store. Login"
    And close browser