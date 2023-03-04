Feature: Place Order: Register while Checkout
  Scenario: Place an order with register while checkout functionality
    Given User verify that the home page is visible successfully
    Then Useradd products to cart
    And User clicks on the Cart link in navbar
    Then User verifies that the cart page is displayed
    And User clicks on the Proceed To Checkout button in the cart page

    When User click on the Register  Login button
    And user fill details: <First name>, <Last name>, <Company>, <Address>, <Address2>, <Country>, <State>, <City>, <Zipcode>, <Mobile>
      |Title|Name     |Email           |Password|Date|Month|Year|First name|Last name|Company|Address        |Country      |State   |City  |Zipcode|Mobile    |
      |Mr   |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Kevin     |Lee      |IPK GMB|123 main street|United States|Virginia|McLean|22102  |7031112233|
    And User verify Logged in as username at the top

    When User clicks on the Cart btn after registering
    And User clicks on Proceed To Checkout button
    Then User verify Address Details and Review Your Order

    When User enters a description in the comment text area
    And User clicks on the Place Order button
    Then User enter payment details: Name on Card, Card Number, CVC, Expiration date
    And User clicks on the Pay and Confirm Order button
    Then User verifies the success message Your order has been placed successfully!