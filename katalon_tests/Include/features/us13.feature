Feature: Order from Closest-Furthest Available Orders
	As a user
	I want to order Available Orders from the closest or the furthest from the restaurant
	So that I can make a more informed decision on which order to take

	#To test this scenario: you must have 2 orders in the Avaialable Orders with different
	# distance values (with different units - example 2.3 and 3.4)

	Background:
		Given the user opens the application
			And the user is logged in
			And the user sees the "Welcome" screen

	Scenario: Check Available Orders "Closest" Button Exists
		Then the user sees the "Available Orders Closest" button
		
	Scenario: Check Available Orders Sorted by Closest
			And the user clicks on the "Available Orders Closest" button	
		Then the user sees the available orders sorted by "Closest"
		
	Scenario: Check Available Orders "Furthest" Button Exists
		Then the user sees the "Available Orders Closest" button
		
	Scenario: Check Available Orders Sorted by Furthest
			And the user clicks on the "Available Orders Furthest" button	
		Then the user sees the available orders sorted by "Furthest"