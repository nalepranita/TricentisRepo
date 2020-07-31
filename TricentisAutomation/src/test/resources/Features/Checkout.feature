Feature: Test the functionality of Checkout

  @Checkout_Flow
  Scenario Outline: As a user, I should be able to checkout products from the cart
    Given User should be in the Shopping Cart
    When User Clicks on Checkout Button
    Then Enter Billing Address "<country>","<city>","<Address1>","<Zipcode>","<phoneNumber>"
    And Enter Shipping Method "<ShippingMethod>"
    Then Click Continue

    Examples: 
      | country    | city     | Address1   | Zipcode | phoneNumber | ShippingMethod     |
      | India      | Pune     | Aundh      |  411057 |      123456 | Ground (0.00)      |
      | New Zeland | Auckland | LarryCoast |   22110 |      456778 | Next Day Air (0.00)|
