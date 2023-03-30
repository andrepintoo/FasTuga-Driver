Feature: Get Order Ready Notification
  As a user
	I want to receive notifications uppon a ready order from My Orders
	So that I know which order I can start delivering

	#To test this scenario: you must have 1 order with the status "Preparing" and the user
	#must wait 5 seconds before checking the notification, (to enable api to modiffy the 
	#order's status)

  Scenario: Check Received Ready Order Notification 
    Given the user opens the application
		  And the user is logged in
		  And the user sees the "Assigned Orders List" list
		  And the status is " PREPARING"
		  And the user waits "5" seconds
		When the user clicks on the "Menu" in the navbar
			And the user clicks on the "Available Orders" text in the Menu
		Then the order status switches to " READY TO CLAIM"
			And the user opens the notifications
			And the user sees the "notification ready order" notification