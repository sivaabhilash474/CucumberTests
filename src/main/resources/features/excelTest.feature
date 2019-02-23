@tag
Feature: Excel test file compare

  @tag1
  Scenario: Testing on excel comparsion
    Given I entered the following values for the "dfsev" scenario:
    |typeRec									|formField											|newValue											      |
    |case											|name														|LSS_201801_BOOKNAME_Automation_Run |
    And I validate the system generated excel report files match the business generated files:
    |lss_foregone_income_existing_dfsev_report_$FCSTMNTH$.xlsx   |
    |lss_foregone_income_prospective_dfsev_report_$FCSTMNTH$.xlsx|