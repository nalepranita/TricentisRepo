
Feature: Test the functionality of Add to Cart
 

	@AddToCart_Flow
  Scenario Outline: As a user, I should be able to add products to the cart
    Given Select the Menu of Prodcuts "<menu>"
    When List of products are displayed
    And Select the product to be added "<product>"
    Then Click on Add to Cart

    Examples: 
      | menu    | product                  |
      | Books   | Computing and Internet   | 
      | Jewelry | Create Your Own Jewelry  | 
