#language: en

Feature: reklama ad test

  @test
  Scenario: Add to favourite ad
    When page "Main Page" open
    And click to category "Легковые авто"
    When page "Car Page" open
    And choose brand "BMW"
    And choose model "M5"