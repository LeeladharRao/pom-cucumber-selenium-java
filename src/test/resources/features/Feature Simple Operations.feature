@UITestSampleOne
Feature: Feature Simple Operations

  Scenario: Text Input
    Given launch the Application
    Then Navigate to "Text Input"
    And Enter "Solar Eclipse" in textbox and verify button text

  Scenario: Click
    Given launch the Application
    Then Navigate to "Click"
    And Click the button

  Scenario: Verify Text
    Given launch the Application
    Then Navigate to "Verify Text"
    And Verify the displayed text
