$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/André/Katalon Studio/taes22_grupow_fastugadriver_tests.git/Include/features/us1.feature");
formatter.feature({
  "name": "US1 - Login",
  "description": "  As a user\n    I want to authenticate myself\n    So that I can access the application",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Check Login Exists",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Successful Authentication",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"email login\" field with \"contacto@email.pt\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"password login\" field with \"password\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
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
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Login With Empty Fields",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Email field cannot be empty\" error text in \"empty email login\" field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_error_text(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Password field cannot be empty\" error text in \"empty password login\" field",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_error_text(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Login With Invalid Email Format",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"email login\" field with \"abc.pt\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Wrong email format\" error text in \"invalid email login\" field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_error_text(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Check Login With Invalid Credentials",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"email login\" field with \"abc@email.pt\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the \"password login\" field with \"123456789\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_the_password_field_with(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"Wrong Credentials\" text",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Go to Register Screen From Login",
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
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_screen(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on the \"REGISTER\" button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginTests.the_user_clicks_the_button(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sees the \"REGISTER\" text",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
});