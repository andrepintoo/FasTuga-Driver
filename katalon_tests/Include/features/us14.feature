Feature: Order from Closest/Furthest My Orders
  As a user
	I want to order My Orders from the closest or the furthest from the restaurant
	So that I can make a more informed decision on which order to start delivering

	#To test this scenario: you must have 2 orders in the Assigned Orders with different
	# distance values (with different units - example 2.3 and 3.4)

	Background:
		Given the user opens the application
		  And the user is logged in
		  And the user sees the "Welcome" screen

  Scenario: Check Assigned Orders "Closest" Button Exists
		Then the user sees the "Assigned Orders Closest" button
		
  Scenario: Check Assigned Orders Sorted by Closest
			And the user clicks on the "Assigned Orders Closest" button	
		Then the user sees the assigned orders sorted by "Closest"
		
	Scenario: Check Assigned Orders "Furthest" Button Exists
		Then the user sees the "Assigned Orders Furthest" button
		
	Scenario: Check Assigned Orders Sorted by Furthest
			And the user clicks on the "Assigned Orders Furthest" button	
		Then the user sees the assigned orders sorted by "Furthest"