package us1
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginTests {
	@Given("the user opens the application")
	public void the_user_opens_the_application() {
		Mobile.startApplication('.\\Apk\\app-debug.apk', true)
	}

	@Then("the user sees the {string} screen")
	public void the_user_sees_the_screen(String string) {
		Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.TextView - '+ string), 0)
	}

	@When("the user fills the {string} field with {string}")
	public void the_user_fills_the_password_field_with(String fieldname, String string) {
		Mobile.setText(findTestObject('Object Repository/android.widget.EditText - ' + fieldname), string, 0)
	}

	@When("the user clicks on the {string} button")
	public void the_user_clicks_the_button(String string) {
		Mobile.tap(findTestObject('Object Repository/android.widget.Button - ' + string), 0)
	}

	@Then("the user sees the {string} text")
	public void the_user_sees_the_text(String string) {
		Mobile.verifyElementText(findTestObject('Object Repository/android.widget.TextView - '+ string), string)
	}

	@Then("the user sees the {string} error text in {string} field")
	public void the_user_sees_the_error_text(String error, String field) {
		String errorMsg = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - ' + field), 'contentDescription', 0)
		assert errorMsg.equals(error)
	}
	
	@Then("the user fills the email field with (.*)")
	public void the_user_fills_email_outline(String email) {
		Mobile.setText(findTestObject('Object Repository/android.widget.EditText - email login'), email, 0)
	}
	
	@Then("the user fills the password field with (.*)")
	public void the_user_fills_password_outline(String password) {
		Mobile.setText(findTestObject('Object Repository/android.widget.EditText - password login'), password, 0)
	}
	
}