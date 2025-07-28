Feature: Customers
  Scenario: Add New Customer
    Given User Launch Crome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User Click on customers menu
    And click on customers menu item
    And click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added succesfully"
    And close browser

  Scenario: Search Customer by EmailID
    Given User Launch Crome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User Click on customers menu
    And click on customers menu item
    And enter Customer EmailID
    When click On Search Button
    Then user Should Found Email In Search Table
    And close browser