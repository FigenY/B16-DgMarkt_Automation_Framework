@wip
Feature:Cat-Subcategory - PRICE slider function
  As a user, I should be able to bring the products in the price range I want on the Sub-Category Page by using the PRICE slider.

  Background:
    Given The user is on the login page
    When The user clicks Health & Beauty submenu
    Then The user should be able to see the "Health & Beauty" page

  Scenario: Adjusting the PRICE slider to filter products within a specific price range
    When The user locates the PRICE slider on the page.
    Then I adjust the PRICE slider minimum to 150 and maximum to 300
    Then I should see products priced between 150 and 300

  Scenario: Adjusting the PRICE slider to the minimum price
    When I adjust the PRICE slider minimum to 0
    Then I should see products priced from 0 onwards

  Scenario: Adjusting the PRICE slider to the maximum price
    When I adjust the PRICE slider maximum to 381
    Then I should see products priced up to 381

  Scenario: No products displayed when the selected price range has no products
   When I adjust the PRICE slider minimum to 300 and maximum to 150
    Then I should see no products displayed
    And a message should be shown saying "No products found in this price range"

  Scenario: Verifying that resetting the PRICE slider shows all products
    When I reset the PRICE slider to its default values
    Then I should see all products on the Sub-Category Page