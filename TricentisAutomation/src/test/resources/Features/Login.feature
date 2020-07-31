
Feature: Feature To Test Login Functionality of Tricentis DemoWebShop
	@Login_Flow
  Scenario Outline: Check whether user is able to Login to Tricentis Website
    Given The Tricentis DemoWebShop website is opened
    When User Enters "<username>" and "<password>"
    And Clicks on Login Button
    Then User is navigated to HomePage with "<username>" displayed

    Examples:
				    | username               | password     | 
				    | nalepranita@gmail.com  | Secure@1234  |
				    | nalepranita@gmail.com  | Secure@1234  |
           