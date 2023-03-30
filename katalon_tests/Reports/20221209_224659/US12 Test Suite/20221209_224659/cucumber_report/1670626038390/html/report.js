$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/sfili/Katalon Studio/taes22_grupow_fastugadriver_tests.git/include/features/us12.feature");
formatter.feature({
  "name": "Get the Directions To the Destination",
  "description": "\tAs a user\n\tI want to receive the directions to the destination\n\tSo that I can optimize my delivery time",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "the user opens the application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginTests.the_user_opens_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user logs in the application",
  "keyword": "And "
});
formatter.match({
  "location": "KeepMeLoggedInTests.the_user_logs_in_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the Assigned Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "CancelOrderTests.the_user_sees_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the \"Assigned Order Item\" in the Assigned Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "CancelOrderTests.the_user_clicks_the_button_in_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check If Map Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the Frame Layout \"Map\"",
  "keyword": "Then "
});
formatter.match({
  "location": "GetTheDirectionsToTheDestination.the_user_sees_the(String)"
});
formatter.result({
  "status": "passed"
});
});