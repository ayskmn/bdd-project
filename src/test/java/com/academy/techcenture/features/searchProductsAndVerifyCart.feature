Feature: Search Products and Verify Cart After Login
  Scenario: User search for a specific product and adds the result products to cart
    Given user has landed on the Homepage
    When user clicks on products button user lands on the all products page
    And Enter product name in search input and click search button
    Then Verify SEARCHED PRODUCTS is visible
    And Verify all the products related to search are visible
    Then Add those products to cart
    Then Click Cart button and verify that products are visible in cart
    And Click Signup Login button and submit login details
    Then Again go to Cart page
    And Verify that those products are visible in cart after login as well