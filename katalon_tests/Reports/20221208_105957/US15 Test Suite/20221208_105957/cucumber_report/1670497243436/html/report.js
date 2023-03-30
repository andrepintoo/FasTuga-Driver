$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/include/features/us15.feature");
formatter.feature({
  "name": "Get Order Ready Notification",
  "description": "  As a user\n\tI want to receive notifications uppon a ready order from My Orders\n\tSo that I know which order I can start delivering",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Received Ready Order Notification",
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
  "name": "the user is logged in",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Assigned Orders List\" list",
  "keyword": "And "
});
formatter.match({
  "location": "AvailableOrdersTests.the_user_sees_the_list(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status is \" PREPARING\"",
  "keyword": "And "
});
formatter.match({
  "location": "GetOrderReadyNotificationTests.the_status_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user waits \"5\" seconds",
  "keyword": "And "
});
formatter.match({
  "location": "GetOrderReadyNotificationTests.the_user_waits_seconds(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Menu\" in the navbar",
  "keyword": "When "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Available Orders\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the order status switches to \" READY TO CLAIM\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ClaimOrderTests.the_order_status_switches_to(String)"
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
  "name": "the user sees the \"notification ready order\" notification",
  "keyword": "And "
});
formatter.match({
  "location": "GetOrderCancelledNotificationTests.the_user_sees_the_notification(String)"
});
formatter.result({
  "status": "passed"
});
});