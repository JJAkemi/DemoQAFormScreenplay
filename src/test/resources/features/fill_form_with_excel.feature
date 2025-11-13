Feature: Fill DemoQA form using Excel data

  Scenario: Fill the form successfully with data from Excel
    Given that the user opens the DemoQA practice form
    When the user fills the form with Excel data row 2
    Then the confirmation modal should be displayed
