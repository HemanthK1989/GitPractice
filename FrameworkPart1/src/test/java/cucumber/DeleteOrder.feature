@tag
Feature: Delete Order from Orders History

Background:
Given I landed on Ecommerce Login Page

  @Regression
  Scenario Outline: Delete the Single Order
    Given I Logged in with username <UserName> and password <Password>
    When I Go to Orders Page
    And Click on Delete button for the Order
    Then I verify the Success Message <Message> in Orders Page

    Examples: 
      | UserName												| Password |Message|
      | hemanthkrishnarao1989@gmail.com |Hemanth12$|Orders Deleted Successfully|
