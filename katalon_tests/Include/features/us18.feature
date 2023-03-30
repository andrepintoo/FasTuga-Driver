Feature: See Notifications History
	As a user
  I want to be able to see my notifications history
  So that I can see all my notifications
  
  	Background:
		Given the user opens the application
			And the user logs in the application
		
		Scenario: Check Notification History Button Exists
  	When the user clicks on the "Menu" in the navbar
    Then the user sees the "Notification History" text in the Menu
    
    Scenario: Check Notification History Screen Exists
    When the user clicks on the "Menu" in the navbar
    Then the user clicks on the "Notification History" text in the Menu
    		And the user sees that the "Order Ready Notification" text exists
    		And the user sees that the "Order Cancelled Notification" text exists
		
		#To test this scenario: you must send a request with a order ready so that the new notification appears 
		
		Scenario: Check Order Ready Notification in Notification History
		  And the user sees the "Available Orders List" list
      And the user waits "10" seconds
		  And the user clicks on the "Menu" in the navbar
      And the user clicks on the "Available Orders Menu" text in the Menu
			And the user opens the notifications
			And the user sees the "notification ready order" notification
			And the user closes the notifications
		When the user clicks on the "Menu" in the navbar
      And the user clicks on the "Notification History" text in the Menu
    	And the user sees that the "Order Ready Notification" text exists
    Then the user sees the Orders Ready Notification list
      And the user sees the "ORDER READY" button in the Orders Ready Notification list
    		
		#To test this scenario: you must have oreders in the Assigned Orders List
		
    Scenario: Check Cancel Order Notification In Notification History 
    	And the user sees the Assigned Orders list
      And the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
      And the user sees the "Order Details" screen
			And the user clicks on the "Claim" button
			And the user sees the "Welcome" screen
    	And the user sees the Assigned Orders list
			And the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
      And the user sees the "Order Details" screen
			And the user clicks on the "Cancel" button
			And the user sees the "Cancel Order Confirmation" confirmation
			And the user fills the "reason cancel order" field with "I fell"
			And the user clicks on the "YES Cancel Order" button
			And the user sees the "Welcome" screen
			And the user opens the notifications
	    And the user sees the "notification cancel order" notification
	    And the user closes the notifications
	  When the user clicks on the "Menu" in the navbar
      And the user clicks on the "Notification History" text in the Menu
    Then the user sees the Orders Cancelled Notification list
      And the user sees the "ORDER CANCELLED" button in the Orders Cancelled Notification list
      
		#To test this scenario: you must send a request with a order ready so that the new notification appears
    		
    Scenario: Check New Notification Doesn't Delete Older One
	    And the user clicks on the "Menu" in the navbar
      And the user clicks on the "Notification History" text in the Menu
      And the user sees the Orders Ready Notification list
      And the user sees the text button in the Orders Ready Notification list
      And the user clicks on the "Menu" in the navbar
      And the user clicks on the "Available Orders Menu" text in the Menu
      And the user waits "10" seconds
     And the user clicks on the "Menu" in the navbar
      And the user clicks on the "Available Orders Menu" text in the Menu
			And the user opens the notifications
			And the user sees the "notification ready order" notification
			And the user closes the notifications
		When the user clicks on the "Menu" in the navbar
      And the user clicks on the "Notification History" text in the Menu
    	And the user sees that the "Order Ready Notification" text exists
    Then the user sees the Orders Ready Notification list
      And the user sees the "ORDER READY" button in the Orders Ready Notification list still exists
      
      