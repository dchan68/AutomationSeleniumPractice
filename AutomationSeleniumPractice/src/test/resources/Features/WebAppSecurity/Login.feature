Feature: feature is to test the login functionality

	@LoginTest1
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks sign in
    Then user is nagivated to home page
