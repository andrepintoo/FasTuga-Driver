	Feature: US8 - Assign Order
  	As a user
    I want to be able to accept an order
    So that it starts to be prepared for the delivery
    
   #To test this scenario: you must have exactly 2 orders with the status "Available" in the Available Orders List

	Background:
		Given the user opens the application
    	And the user logs in the application
    	And the user sees the Available Orders list
    When the user clicks on one of the orders in the Available Orders list

  Scenario: Check Assign Button Exists
    Then the user sees the "Order Details" screen
    	And the user sees the "Assign" button
    	
   Scenario: Check Assigned Order By Clicking Assign Button
    	And the user clicks on the "Assign" button
    Then the user sees the Available Orders list
    	And the user sees that the assigned order item is not in the Available Orders list
    	
    #Scenario: Check Assigned Order By Double Tap
	  # 	Given the user opens the application
	  #  	And the user logs in the application
	  #  	And the user sees the Available Orders list
	  #  When the user double clicks on one of the orders in the Available Orders list
	  #  Then the user sees that the assigned order item is not in the Available Orders list