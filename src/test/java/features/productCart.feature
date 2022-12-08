@tag
Feature: Search and add products to cart
  This is just a description

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and offers page
    Given user is on GreenCard landing page
    When user searched with shortname <Name> and extracted actual name of product
    And user adds <Quantity> items of <Name> to the cart
    And user opens cart and proceed to checkout
    Then validate product name in checkout page matches with Landing Page
    And validate apply and place order buttons are displayed
    
  Examples:
  | Name | Quantity |
  | tom  | 3				|
  | beet | 2				|

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
