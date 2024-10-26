Feature: Google Search
  Validate results within various parameters

  @search
  Scenario Outline: Display results
    Given user is on the google page
    When  user enters "Selenium Webdriver" into search text field
    And   user press the return key
    Then  user get the results displayed within <timeUnit> milliseconds

    Examples:
    | timeUnit |
    | 2000     |
    | 3000     |