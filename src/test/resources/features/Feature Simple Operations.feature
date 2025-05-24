@UITestSampleOne
Feature: Feature Elements Test

  Scenario: Text Box Test
    Given User navigate to url "https://demoqa.com/"
    And Click on "Elements" button
    Then User is Navigated to "Elements" Page
    And Click on "Text Box"
    Then User is Navigated to "Text Box" Page
    Then User enters "Full Name" as "Adrian K"
    Then User enters "Email" as "adrian.k@test.com"
    Then User enters "Current Address" as "Silk Street, Book Ave, USA"
    Then User enters "Permanent Address" as "Silk Street, Book Ave, USA"
    Then User clicks on "Submit" button
