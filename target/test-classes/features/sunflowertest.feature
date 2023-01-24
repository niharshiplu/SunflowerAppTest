@tag
Feature: Test sunflower App

  @smoke-01
  Scenario: Verify text message on Landing screen
    When User launch Sunflower app
    Then User sees My Garden screen with "Your garden is empty" text

  @smoke-02
  Scenario: Verify Button visibility on Landing screen
    When User launch Sunflower app
    Then User sees My Garden screen with "ADD PLANT" button

  @func-01
  Scenario: Verify Plant List and My Garden tab is clickable
    When User launch Sunflower app
    Then User click Plant List and My Garden tab

  @func-02
  Scenario: Verify ADD PLANT button click navigates to Plant List tab
    Given User launch Sunflower app
    When User clicks ADD PLANT button
    Then User navigates to the Plant List tab
