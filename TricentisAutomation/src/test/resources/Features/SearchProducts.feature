Feature: Feature To Search Prodcuts Functionality of Tricentis DemoWebShop
	@SearchProduct_FLow
  Scenario Outline: Check whether user is able to Search for specific products
    Given The Search Bar is visible
    When User Enters "<product>" to be searched
    And Clicks on Search Button
    Then User is displayed with list of items

    Examples:
				    | product |
				    | Camera  |
				    |Desktop  |
           