$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/UCs_5th_Semester/TA_EngenhariaSoftware/Projeto/taes22_grupow_fastugadriver_tests.git/Include/features/us1.feature");
formatter.feature({
  "name": "US1 - Login",
  "description": "  As a user\n    I want to authenticate myself\n    So that I can access the application",
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
  "name": "Check Login Exists",
  "description": "",
  "keyword": "Scenario"
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
  "name": "Check Login With Empty Fields",
  "description": "",
  "keyword": "Scenario"
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
  "name": "Check Login With Invalid Email Format",
  "description": "",
  "keyword": "Scenario"
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
  "name": "Go to Register Screen From Login",
  "description": "",
  "keyword": "Scenario"
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
formatter.scenarioOutline({
  "name": "Check Successful Authentication",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.step({
  "name": "the user fills the email field with \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "the user fills the password field with \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.step({
  "name": "the user sees the \"Welcome\" text",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "contacto@email.pt",
        "password"
      ]
    },
    {
      "cells": [
        "rodrigo.campos@mail.pt",
        "12345678"
      ]
    }
  ]
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
  "name": "Check Successful Authentication",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "the user fills the email field with contacto@email.pt",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_email_outline(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the password field with password",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_password_outline(String)"
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
  "name": "the user sees the \"Welcome\" text",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_text(String)"
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
  "name": "Check Successful Authentication",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "the user fills the email field with rodrigo.campos@mail.pt",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_email_outline(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the password field with 12345678",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_password_outline(String)"
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
  "name": "the user sees the \"Welcome\" text",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.the_user_sees_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Check Login With Invalid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the user sees the \"LOGIN\" screen",
  "keyword": "And "
});
formatter.step({
  "name": "the user fills the email field with \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "the user fills the password field with \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "the user clicks on the \"LOGIN\" button",
  "keyword": "And "
});
formatter.step({
  "name": "the user sees the \"Wrong Credentials\" text",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "abc@email.pt",
        "123456789"
      ]
    },
    {
      "cells": [
        "utilizador@email.pt",
        "admin"
      ]
    }
  ]
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
  "name": "Check Login With Invalid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "the user fills the email field with abc@email.pt",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_email_outline(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the password field with 123456789",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_password_outline(String)"
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
  "name": "Check Login With Invalid Credentials",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "the user fills the email field with utilizador@email.pt",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_email_outline(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user fills the password field with admin",
  "keyword": "And "
});
formatter.match({
  "location": "LoginTests.the_user_fills_password_outline(String)"
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
});