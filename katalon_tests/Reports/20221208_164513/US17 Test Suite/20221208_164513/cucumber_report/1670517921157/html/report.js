$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us17.feature");
formatter.feature({
  "name": "US17 - Turn On/Off Notifications",
  "description": "  As a user\n  I want to be able to turn on or off my notifications",
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
formatter.scenario({
  "name": "Check Turn On/Off Notifications Button Exists",
  "description": "",
  "keyword": "Scenario"
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
  "name": "the user sees the \"Turn OnOff Notifications\" in the Menu",
  "keyword": "Then "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_sees_the_text(String)"
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
formatter.scenario({
  "name": "Check Successful Turning Off Notifications",
  "description": "",
  "keyword": "Scenario"
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
  "name": "the user sees a \"Order\" notification text",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_verifies_notification(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user closes the notifications",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_closes_notifications()"
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
  "name": "the user clicks on the \"Turn OnOff Notifications\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user switches notifications status",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_switches_notifications()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Go Back To Application From Settings\" image button",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_goes_back(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user closes the menu",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_closes_menu()"
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
  "name": "the user sees that the \"Order\" notification doesnt exist",
  "keyword": "Then "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_doenst_see_notification(String)"
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
formatter.scenario({
  "name": "Check Successful Turning On Notifications",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user closes the notifications",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_closes_notifications()"
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
  "name": "the user has the notifications turned off",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_has_notifications_off()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user opens the notifications",
  "keyword": "When "
});
formatter.match({
  "location": "GetOrderCancelledNotificationTests.the_user_opens_the_notifications()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees that the \"Order\" notification doesnt exist",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_doenst_see_notification(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user closes the notifications",
  "keyword": "Then "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_closes_notifications()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Menu\" in the navbar",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Turn OnOff Notifications\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user switches notifications status",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_switches_notifications()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"Go Back To Application From Settings\" image button",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_goes_back(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user closes the menu",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_closes_menu()"
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
  "name": "the user sees a \"Order\" notification text",
  "keyword": "And "
});
formatter.match({
  "location": "TurnOnOffNotificationsTests.the_user_verifies_notification(String)"
});
formatter.result({
  "status": "passed"
});
});