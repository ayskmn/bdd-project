Feature:Place Order- Login before Checkout
  Scenario: User logs in, adds products to cart and places the order
    Given user navigates to the homepage and the homepage is visible
    And user clicks on signup login button
    Then enters email, password and clicks on Login btn
    And verifies Logged in as username at top of the page
    Then adds products to the cart
    And clicks on Cart button in the navbar
    When verifies that cart page is displayed
    And clicks on proceed to checkout
    Then verifies address details and reviews the order
      |Name         |Address    |StateZipcode    |Country      |Mobile    |
      |Mr. Kevin Lee|123 main st|Mc Lean VA 22102|United States|7036774566|
    Then enters description in the comment text area and places the order
    When enters payment details; name on card, card number, cvc, exp date
    Then clicks on pay and confirm order
    And verifies the success message Your order has been placed successfully!
