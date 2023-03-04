Feature: Verify Product quantity in Cart
  Scenario: Update product quantity to for and verify quantity in cart
    Given the user is navigated to homepage
    And Click View Product for any product on home page
    When Verify product detail is opened
    And Increase quantity to four
    Then Click Add to cart button after increasing qty
    Then Click View Cart link
    And Verify that product is displayed in cart page with exact quantity