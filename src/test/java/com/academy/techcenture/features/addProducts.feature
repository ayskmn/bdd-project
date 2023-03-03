Feature: Add Products in Cart
  Scenario: User adds 2 products to cart and verifies the info and total is correct

    Given user landing on the homePage
    And Click Products button
    Then Hover over first product and click Add to cart
    When Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click View Cart button
    And Verify both products are added to Cart
    Then Verify their prices, quantity and total price

