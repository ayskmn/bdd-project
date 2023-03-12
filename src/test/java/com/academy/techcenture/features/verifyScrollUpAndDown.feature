Feature: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
  Scenario: Scroll down to the bottom of the page and scroll up to the top of the page
    Given user is navigated to homepage and homepage is loaded successfully
    Then Scroll down page to bottom
    And Verify SUBSCRIPTION is visible
    Then Click on arrow at bottom right side to move upward
    And Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen