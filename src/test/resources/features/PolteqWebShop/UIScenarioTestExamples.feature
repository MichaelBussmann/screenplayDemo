Feature: UI scenario test examples
  This feature file contains example test scenario's that show how to work with Cucumber and the Screenplay pattern.

  Scenario: Search for an item with one result
    Given Max has opened the Polteq webshop
    When he searches for 't-shirt'
    Then he should see that one product is found

#  Scenario: Search for an item with multiple results
#    Given Max has opened the Polteq webshop
#    When he searches for 'mug'
#    Then he should see that 5 products are found
#
#  Scenario: Search for an item with no results
#    Given Max has opened the Polteq webshop
#    When he searches for 'geen resultaat'
#    Then he should see a message that nothing could be found
#
#  Scenario: Open a product detail screen and see if the 'add to cart' button is present
#    Given Max has opened the Polteq webshop
#    When he clicks on the first product on the page
#    Then he should see the 'add to cart' button
#
#  Scenario: Open a product detail screen and see if the product title is correct
#    Given Max has opened the Polteq webshop
#    When he clicks on product number 2 on the page
#    Then he should see the same product title
#
#  Scenario: Adding a new product to the cart
#    Given Max has opened the Polteq webshop
#    And he opens the first product on the page
#    When he clicks 'Add to Cart'
#    Then he should see that the product is added to the cart