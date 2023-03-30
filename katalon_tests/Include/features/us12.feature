Feature: Get the Directions To the Destination
	As a user
	I want to receive the directions to the destination
	So that I can optimize my delivery time

	Background:
		Given the user opens the application
			And the user logs in the application
			And the user sees the Assigned Orders list
		When the user clicks on one of the "Assigned Order Item" in the Assigned Orders list
		
	Scenario: Check If Map Exists
		Then the user sees the Frame Layout "Map"