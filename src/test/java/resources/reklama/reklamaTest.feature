#language: en

Feature: reklama ad test

  @test
  Scenario: Add to favourite ad
    * page "Main Page" open
    * click to category "Легковые авто"
    * page "Category Page" open
    * choose brand "BMW"
    * choose model "M5"
    * page "AdList Page" open
    * select ad number 1
    * page "Ad Page" open
    * save field value "Lot price" to stash with key "lot_price_1"
    * hover and click to button "Add to favorite"
    * click to button "Favorite"
    * equals favorite ads and stash value "lot_price_1"