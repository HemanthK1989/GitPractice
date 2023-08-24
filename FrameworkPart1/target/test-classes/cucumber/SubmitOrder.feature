@tag
Feature: Purchase the Order from Ecommerce site

Background:
Given I landed on Ecommerce Login Page

  @Regression
  Scenario Outline: Positive test of Submitting the Order
  
    Given I Logged in with username <UserName> and password <Password>
    When I add product <ProductName> to Cart
    And Checkout <ProductName> and Submit the Order
    Then I verify the Confirmation Message "Thankyou for the order." on Confirmation Page

    Examples: 
      |UserName  											|	Password	 	|ProductName|
      |hemanthkrishnarao1989@gmail.com |Hemanth12$|ZARA COAT 3|
      |hemanthkrishnarao1989@yopmail.com |Hemanth12$|ZARA COAT 3|
