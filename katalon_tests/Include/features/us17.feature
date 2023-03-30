Feature: US17 - Turn On/Off Notifications
  As a user
  I want to be able to turn on or off my notifications
  
  #To test these features you must have at least 1 order in either the Available Orders List or the Assigned Orders List

	Background:
		Given the user opens the application
    	
  Scenario: Check Turn On/Off Notifications Button Exists
  	And the user is logged in
    When the user clicks on the "Menu" in the navbar
    Then the user sees the "Turn OnOff Notifications" in the Menu
    
	Scenario: Check Successful Turning Off Notifications
			And the user is logged in
			And the user opens the notifications
			And the user sees a "Order" notification text
			And the user closes the notifications
		When the user clicks on the "Menu" in the navbar
			And the user clicks on the "Turn OnOff Notifications" text in the Menu
			And the user switches notifications status
			And the user clicks on the "Go Back To Application From Settings" image button
			And the user closes the menu
			And the user sees the "Welcome" screen
			And the user opens the notifications
		Then the user sees that the "Order" notification doesnt exist
		
	 Scenario: Check Successful Turning On Notifications
	 		And the user closes the notifications
	 		And the user is logged in
	 		And the user has the notifications turned off
	 	When the user opens the notifications
	 		And the user sees that the "Order" notification doesnt exist
	 	Then the user closes the notifications
	 		And the user clicks on the "Menu" in the navbar
	 		And the user clicks on the "Turn OnOff Notifications" text in the Menu
			And the user switches notifications status
			And the user clicks on the "Go Back To Application From Settings" image button
			And the user closes the menu
			And the user opens the notifications
			And the user sees a "Order" notification text
	 	