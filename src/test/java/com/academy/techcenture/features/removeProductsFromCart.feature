Feature: Remove Products From Cart
  Scenario: User adds products to cart and removes them from the cart
    Given user navigates to homepage successfully
    Then adds products to cart
    And clicks on the cart btn and verifies cart page is displayed
    When clicks X btn corresponding to particular product
    Then verifies that product is removed from the cart
