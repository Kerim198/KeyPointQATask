@wip
Feature: Interactions

  Scenario: Droppable Interactions
    Given the user should be on the "demoqa" page
    When the user navigates to "Interactions", "Droppable"
    And the user drags the “drag me” box to the “drop me” box
    Then the user verifies that "Dropped!"