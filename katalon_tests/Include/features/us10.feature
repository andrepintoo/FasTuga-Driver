	Feature: US10 - Complete Handover
  	As a user
    I want to complete my order
    So that I receive my earning
    
   #To test this scenario: must have at least 2 assigned orders (the first one being in the "Delivering" state) in the Assigned Orders List
    
  Background:
		Given the user opens the application
  		And the user logs in the application
  		And the user sees the "Welcome" screen
  		
	Scenario: Check Delivered Button Exists
			And the user sees the Assigned Orders list
  	When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
   	Then the user sees the "Order Details" screen
   		And the user sees the "Delivered" button
   
  Scenario: Check Balance Text Exists
  	Then the user sees that the "Balance Value" text exists
   		
 	Scenario: Check Successful Complete Handover By Button Delivered
	 		And the user sees the Assigned Orders list
	 		And the user sees the Balance value
	  When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
	  	And the user sees how much he is going to earn for that delivery
			And the user clicks on the "Delivered" button
		Then the user sees the "Welcome" screen
			And the user sees that the clicked order item is not in the Assigned Orders list
			And the user sees that the balance has gone up
		
	#Scenario: Check Successful Complete Handover By Double Tap
	 #		And the user sees the Assigned Orders list
	 #		And the user sees the Balance value
	 # When the user double clicks on one of the orders in the Available Orders list
	#	Then the user sees that the clicked order item is not in the Assigned Orders list
		#	And the user sees that the balance has gone up