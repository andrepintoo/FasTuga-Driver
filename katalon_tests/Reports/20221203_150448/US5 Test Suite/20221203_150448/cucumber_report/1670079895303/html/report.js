$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us5.feature");
formatter.feature({
  "name": "US5 - Logout",
  "description": "  As a user\n  I want to logout from the application",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Logout Button Exists",
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
  "name": "the user sees the \"Logout\" text in the Menu",
  "keyword": "Then "
});
formatter.match({
  "location": "LogoutTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Successful Logout",
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
  "name": "the user clicks on the \"Logout\" text in the Menu",
  "keyword": "And "
});
formatter.match({
  "location": "LogoutTests.the_user_clicks_on_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
});