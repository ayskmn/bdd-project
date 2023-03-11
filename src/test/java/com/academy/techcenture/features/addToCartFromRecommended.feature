Feature: Add to cart from Recommended items
  Scenario: User adds a recommended product to cart
    Given browser is launched and user is navigated to homepage
    Then scrolls down to footer
    And verifies RECOMMENDED ITEMS are visible
    Then Click on Add To Cart on Recommended product
    And clicks on view cart button after adding product
    Then Verifies that product is displayed in cart page