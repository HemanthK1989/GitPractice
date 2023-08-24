@tag
Feature: Login with invalid credentials

  @ErrorHandling
  Scenario Outline: Verify Error Validation message
  	Given I landed on Ecommerce Login Page
    When I Logged in with username <UserName> and password <Password>
    Then "Incorrect email or password." message should display

    Examples: 
      | UserName  											| Password |
      | hemanthkrishnarao1989@gmail.com |Hemanth12| 
