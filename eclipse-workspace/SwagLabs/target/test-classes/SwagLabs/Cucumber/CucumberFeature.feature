@tag
Feature: Swag Labs Automation
  I want to use this template for my feature file
  
  Background:
  Given I access the URL

  @tag2
  Scenario Outline: Purchase product from Swag Labs
    Given I login using username <username> and password <password>
    When I add items to cart
    And I proceed with checkout
    And I fill information page with <firstname> , <lastname> and <pincode>
    And Confirm the order added
    Then "Thank you for your order!" is displayed

    Examples: 
      |username| password |firstname|lastname|pincode|
      |standard_user|secret_sauce|Shantanu|De|834001|
      
