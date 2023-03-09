Feature: View Category Products
  Scenario: User views the products under Women and Men Category and navigates to category page
    Given user is on the homepage and verifies that user is on the homepage
    Then verify that categories are visible on left side bar
    And Click on Women category
    Then Click on any category link under Women category, for example, Dress
    And Verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS
    Then On left side bar, click on any sub-category link of Men category
    And Verify that user is navigated to that category page