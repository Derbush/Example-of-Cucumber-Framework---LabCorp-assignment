@ui
Feature: Career Page Link Tests

  Scenario: Verify a specific LabCorp job listing confirming information on the job posting.
    Given User navigates to "https://www.labcorp.com/"
    When  User finds and clicks on "Careers" link
    Then  Search for a position "Test Automation Engineer", select and browse to the position
    Then  Confirm Job Title "Test Automation Engineer"
    And   Confirm Job Location
    |Durham, North Carolina, United States of America|
    |Burlington, North Carolina, United States of America|
    And   Confirm Job Id "2322968"
    And   Confirm text
      | Bachelor’s degree or equivalent in Electrical or Electronics Engineering or Computer Science.  Clinical Healthcare experience a plus. |
      | Programming Languages: Java, C/C++, Python, VB/VB Script |
      | Automation tools: Selenium, Cucumber/Gherkin, TestNG, Jenkins/CICD pipeline integration |
    Then  Click Apply Now and switch to another window "Workday"
    And   Click to Return to Job Search
