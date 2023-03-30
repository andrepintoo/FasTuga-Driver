$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/sfili/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us4.feature");
formatter.feature({
  "name": "US4 - Order Details",
  "description": "  As a user\n\tI want to open the order details\n\tSo that I can check the order information",
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
  "name": "the user sees the Available Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "AssignOrderTests.the_user_sees_the_available_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the orders in the Available Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "AssignOrderTests.the_user_clicks_the_order_in_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Order Details Screen Exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"Order Details\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
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
  "name": "the user sees the Available Orders list",
  "keyword": "And "
});
formatter.match({
  "location": "AssignOrderTests.the_user_sees_the_available_list()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on one of the orders in the Available Orders list",
  "keyword": "When "
});
formatter.match({
  "location": "AssignOrderTests.the_user_clicks_the_order_in_the_list()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Order information",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user sees the \"Order Details\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"8438\" text in \"Order Number\" field",
  "keyword": "And "
});
formatter.match({
  "location": "OrderDetailsTests.the_user_sees_the_text(String,String)"
});
