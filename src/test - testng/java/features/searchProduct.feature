@tag
Feature: Search and Place the order for products
  This is just a description

  @OffersPage
  Scenario Outline: Search Experience for product search in both home and offers page
    Given user is on GreenCard landing page
    When user searched with shortname <Name> and extracted actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name matches in offers page matches with Landing Page
    
  Examples:
  | Name |
  | tom  |
  | beet |

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
