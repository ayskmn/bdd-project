Feature: Verify Subscription in Cart page

  Scenario: Verify subscription input is on the cart page
    Given user landing on a home Page
    When user clicks on a cart button
    And user Scrolls down to footer
    And Verify text SUBSCRIPTION is displayed
    Then Enter email address in input field and click arrow button
    And Verify success message (You have been successfully subscribed!) is visible

