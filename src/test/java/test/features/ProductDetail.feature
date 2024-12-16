Feature: Akakce Mobile Application Test

  @smoke
  Scenario: Verify product details navigation
    And User chooses to continue without login
    When User searches for "Laptop"
    And User applies filter for category "Bilgisayar,Donanım"
    And User selects sorting by "En Yüksek Fiyat"
    And User selects the 10th product from the list and go to product
    Then Verify "Satıcıya Git" button is visible on the product details page
