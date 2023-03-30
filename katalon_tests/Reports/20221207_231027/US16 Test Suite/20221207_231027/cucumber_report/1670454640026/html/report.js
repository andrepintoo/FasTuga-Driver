$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/Include/features/us16.feature");
formatter.feature({
  "name": "US16 - Get Order Cancelled Notification",
  "description": "\tAs a user\n\tI want to receive notifications uppon a cancelled order from My Orders\n\tSo that I can stop a deliver or avoid starting that delivery",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Received Cancelled Order Notification",
  "description": "",
  "keyword": "Scenario"
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
formatter.step({
  "name": "the user sees the \"Order Details\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Cancel\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Cancel Order Confirmation\" confirmation",
  "keyword": "And "
});
formatter.match({
  "location": "GetOrderCancelledNotificationTests.the_user_sees_the_confirmation(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"reason cancel order\" field with \"I fell\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"YES Cancel Order\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Welcome\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user opens the notifications",
  "keyword": "And "
});
formatter.match({
  "location": "GetOrderCancelledNotificationTests.the_user_opens_the_notifications()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"notification cancel order\" notification",
  "keyword": "Then "
});
formatter.match({
  "location": "GetOrderCancelledNotificationTests.the_user_sees_the_notification(String)"
});
formatter.result({
  "status": "passed"
});
});