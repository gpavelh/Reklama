@tests
Feature: reklama ad test

  @test1
  Scenario: Add to favorites from sale ad
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
    * check that favorite count equals 1 on icon "Favorites count"
    * click to button "Favorite"
    * equals favorite ads and stash value "lot_price_1"

  @test2
  Scenario: Add some ad to favorites from ads list
    * page "Main Page" open
    * click to category "Лес"
    * page "AdList Page" open
    * save all field value "Ad cost" to stash with key "lots_prices_1"
    * add all ad to favorite
    * click to button "Favorite"
    * equals all favorite ads and stash value "lots_prices_1"

  @test3
  Scenario: Quick search ad and add to favorites from ads list
    * page "Main Page" open
    * click to button "Advanced search button"
    * page "Advanced Search Page" open
    * advanced search ad "Labs ricuks"
    * page "AdList Page" open
    * save all field value "Ad cost" to stash with key "lots_prices_1"
    * add all ad to favorite
    * click to button "Favorite"
    * equals all favorite ads and stash value "lots_prices_1"