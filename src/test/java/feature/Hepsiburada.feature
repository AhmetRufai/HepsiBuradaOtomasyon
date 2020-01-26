Feature: Hepsiburada Case
#Testcase'lerin anlaşılır ve okunabilir olması için Cucumber kütüphanesi kullanılmıştır
  Scenario: Scenario1: Select Browser and Login
    When I have opened "https://www.hepsiburada.com/" with "chrome" browser
    Then sign in as "tester@gmail.com" and "tester123"

  Scenario: Scenario2: Buy and Cancel Product
    When Add a book to cart
    Then Buy the product with the Havale option
    Then Cancel purchased product