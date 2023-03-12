Feature: Download Invoice after purchase order
  Scenario: User creates an account, adds products, downloads invoice after checkout
    Given user is on the homepage, homepage is visible successfully
    And user adds products to cart and clicks on the cart button
    Then verify that cart page is displayed successfully
    And clicks on proceed to checkout button in the cart page
    Then clicks on Register Login button and creates a new account
      |Title|Name     |Email           |Password|Date|Month|Year|First name|Last name|Company|Address        |Country      |State   |City  |Zipcode|Mobile    |
      |Mr   |Kevin Lee|kevlee@gmail.com|123Ken! |12  |May  |1988|Kevin     |Lee      |IPK GMB|123 main street|United States|Virginia|McLean|22102  |7031112233|
    Then verifies the account created successfully page and clicks the continue button
    And verifies Logged in as username at top is displayed
    Then clicks on the cart link in the navbar
    And clicks on proceed to checkout btn
    When verifies address details and review your order
    Then Enter description in comment text area and click Place Order
    And Enter payment details: Name on Card,Card Number,CVC,Expiration date
    When clicks on pay and confirm order button
    Then verify success message Your order has been placed successfully
    And clicks on Download Invoice button and verifies invoice is downloaded successfully
