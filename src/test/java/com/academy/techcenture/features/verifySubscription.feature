Feature: Verify Subscription in home page

  Scenario: A success msg is visible upon subscription
  Given User navigates to home page and page is visible
  And Scroll down to footer
  Then Verify text SUBSCRIPTION
  When Enter email address in input and click arrow button
  Then Verify success message You have been successfully subscribed! is visible
