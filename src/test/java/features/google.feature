#Feature file for validating the 1st element in the google which loads at 1 second

Feature: Google Search  Validating whether results are displayed within 1 second or not

  @BasicTest
  Scenario Outline: Display results
    Given user is on the google page
    When  user enters "Selenium Webdriver" into search text field
    And   user press the return key
    Then  user get the results displayed within <timeUnit> milliseconds

    Examples:
      | timeUnit |
      | 2000     |
      | 3000     |
