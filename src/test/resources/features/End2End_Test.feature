Feature: End to End simulation Test
Description: We will test some scenario implement E2E Test

@addData
Scenario Outline: As a user I can add new data
    Given A list of item are available
    When I add item to list <payload>
    Then The item is available

    Examples:
    |payload|
    |1|
    |2|

Scenario: As a user I can update data
    Given A list of item are available
    When I add item to list
    And The item is available
    Then I can update that item

Scenario: As a user I can detele data 
    Given A list of item are available
    And I add item to list
    And The item is available
    When I delete that item
    Then The item is not available
