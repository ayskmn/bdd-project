Feature: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
  Background: Click on signup btn
    Given user is navigated to homepage and homepage is loaded successfully
    Then Scroll down page to bottom
    And Verify SUBSCRIPTION is visible

  Scenario: Scroll down to the bottom of the page and scroll up to the top of the page with arrow
    Then Click on arrow at bottom right side to move upward
    And Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen

  Scenario: Scroll down to the bottom of the page and scroll up to the top of the page with window scroll
    Then Scroll up page to top
    And Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible