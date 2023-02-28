Feature: Search Product
  Scenario: Search Product
    Given user navigates to the home page
    When user Click on Products button
    And user Verify user is navigated to ALL PRODUCTS page successfully
    When user Enter product name in search input and click search button
    Then user Verify SEARCHED PRODUCTS is visible
    And user Verify all the products related to search are visible

