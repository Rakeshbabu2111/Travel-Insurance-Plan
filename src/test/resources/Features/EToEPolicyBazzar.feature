Feature: Travel insurance plan for students-Policy Bazzar

  @regression
  Scenario Outline: Validation of user interaction with policy bazzar site when user searches for Travel insurance plans
    Given the user navigate to policy bazaar website
    When the user click on the travel insurance icon
    And the user selects the destination "<Destination Name>"
    And the user selects the trip duration
    And the user selects the no of travellers and age of travellers
    And the user selects pre-existing medical condition
    And the user enter the mobile number "<Mobile Number>"
    And the user selects the student plans and enters the student travel information
    And the user sort the plans from low to high
    Then display three lowest international travel insurance plan with amount and insurance provider company

    Examples: 
      | Destination Name | Mobile Number |
      | United Kingdom   |    9963423134 |

  @smoke
  Scenario: Insurance products in Health insurance
    Given the user navigate to policy bazaar website
    When the user hover on insurance products
    Then the user prints health insurance products menu items

  @regression
  Scenario: Validation of user interaction with policybazzar site when user searches for car insurance plans
    Given the user navigate to policy bazaar website
    When the user click on the car insurance icon
    And the user click on buying a new car
    And the user selects city and RTO
    And the user selects car brand
    And the user selects car model
    And the user selects car fuel type
    And the user selects car variant
    And the user enters FullName and Invalid Email and Mobile Number
    Then capture and display error messages
