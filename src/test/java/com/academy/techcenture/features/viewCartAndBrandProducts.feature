Feature: View & Cart Brand Products
  Scenario: User verifies brand side bar on products page
    Given user has landed on the homepage
    Then Click on Products button in the navigation menu on the homepage
    And Verify that Brands are visible on left side bar
    Then Click on any brand name
    When Verify that user is navigated to brand page and brand products are displayed
    Then On left side bar, click on any other brand link
    And Verify that user is navigated to that brand page and can see products