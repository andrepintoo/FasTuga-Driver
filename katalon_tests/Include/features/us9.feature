Feature: Claim Order
  As a user 
	I want to claim an order
	So that I can start my delivery
	
	#To test this scenario: you must have 2 orders with the status "Ready to Claim"
  
  Background:
  Given the user opens the application
		And the user is logged in
		And the user sees the "Assigned Orders List" list
	When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
  
  Scenario: Check Claim Button Exists
		Then the user sees the "Order Details" screen
			And the user sees the "Claim" button 
			
	Scenario: Check Claimed Order By Clicking Claim Button
			And the user clicks on the "Claim" button 
		Then the order status switches to " DELIVERING"
			And the user sees the "Welcome" screen
			
	#Scenario: Check Successful Claimed Order By Double Tap
		#Then the order status switches to " DELIVERING"