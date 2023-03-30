package us8
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



class AssignOrderTests {

	String obj = ""

	@Given("the user sees the Available Orders list")
	public void the_user_sees_the_available_list() {
		TestObject newObj = new TestObject()
		newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]")
		Mobile.verifyElementExist(newObj, 0)
	}

	@When("the user clicks on one of the orders in the Available Orders list")
	public void the_user_clicks_the_order_in_the_list() {
		TestObject obj = new TestObject("")
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")
		this.obj = Mobile.getAttribute(obj, 'text', 6)
		Mobile.tap(obj, 0)
	}

	@When("the user double clicks on one of the orders in the Available Orders list")
	public void the_user_double_clicks_the_order_in_the_list() {
		TestObject obj = new TestObject("")
		obj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")
		Mobile.doubleTap(obj, 0)
	}

	@Then("the user sees that the assigned order item is not in the Available Orders list")
	public void the_user_verifies_order_item_missing_in_available_orders() {
		TestObject newObj = new TestObject()
		newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")

		String text1 = Mobile.getAttribute(newObj, 'text', 6)

		assert text1.compareTo(this.obj) != 0
	}
}