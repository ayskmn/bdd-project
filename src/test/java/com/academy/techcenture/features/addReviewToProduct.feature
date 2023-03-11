Feature: Add review on product
  Scenario: User submits a review on a product with their credentials
    Given user is on the homepage, verifies homepage is loaded successfully
    Then user goes to product link and navigated to ALL PRODUCTS page successfully
    And clicks on view product to navigate to that products page
    Then clicks on view product btn
    When verifies Write Your Review is visible
    Then enters name, email and review
    And clicks on submit button
    Then verifies success message Thank you for your review is visible
