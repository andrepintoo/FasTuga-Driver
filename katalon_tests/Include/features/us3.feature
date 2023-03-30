Feature: Register
	As a user
	I want to access the Orders Screen
	So that I can see all available orders

	Background:
		Given the user opens the application
			And the user is logged in

	Scenario: Check Available Orders Screen Exists
		Then the user sees the "Available Orders List" list

	Scenario: Check Empty Available Orders
		Then the user sees the "No orders Available" text
