Feature: Test the functionality Order Confirmation

  @CheckORder_Flow
  Scenario: As a user, I should be able capture the order information
    Given Order is booked already
    Then Capture Order information
    
	@Logout
	Scenario: As a user, I should be able to Logout from Application
    Given Logout link is visible
    When Clicks on Logout
    Then User is logged out
    
