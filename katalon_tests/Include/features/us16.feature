Feature: US16 - Get Order Cancelled Notification

	As a user
	I want to receive notifications uppon a cancelled order from My Orders
	So that I can stop a deliver or avoid starting that delivery
	
	Scenario: Check Received Cancelled Order Notification 
	Given the user opens the application
    	And the user logs in the application
    	And the user sees the Assigned Orders list
  When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
      And the user sees the "Order Details" screen
			And the user clicks on the "Cancel" button
			And the user sees the "Cancel Order Confirmation" confirmation
			And the user fills the "reason cancel order" field with "I fell"
			And the user clicks on the "YES Cancel Order" button
			And the user sees the "Welcome" screen
			And the user opens the notifications
	Then the user sees the "notification cancel order" notification