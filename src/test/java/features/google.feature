#Feature file for validating the 1st element in the google which loads at 1 second

Feature: Google page

  @BasicTest
  Scenario: element loading at 1 second
    Given User is on the google homepage with browser
    When User lands on the google homepage
    Then User should get the list of elements which are loaded in One second
