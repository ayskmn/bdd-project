Feature: Verify address details in checkout page
  Scenario: Create new account and verify address after checkout
    Given Navigate to automationexercise.com and verify homepage is visible
    And click signupLogin button when on homepage
    Then fill all details and create a new account
      |Title|Name     |Email           |Password|Date|Month|Year|First name|Last name|Company|Address        |Country      |State   |City  |Zipcode|Mobile    |
      |Mr   |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Kevin     |Lee      |IPK GMB|123 main street|United States|Virginia|McLean|22102  |7031112233|
    And verify ACCOUNT CREATED! and click on continue button
    Then verify logged in as username text at top
    And add some products to cart
    And click on the cart link and verify the cart page is displayed
    Then click proceed to checkout button
    And Verify that the delivery address is same address filled at the time registration of account
    And Verify that the billing address is same address filled at the time registration of account