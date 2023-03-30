package us10
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



class CompleteHandoverTests {

	int previousBalance = 0
	int newEarning = 0

	@Given("the user sees the Balance value")
	public void the_user_verifies_previous_value() {
		String value = Mobile.getAttribute(findTestObject('Object Repository/android.widget.TextView - Balance Value'), 'text', 0)
		this.previousBalance = value.toInteger()
	}

	@When("the user sees how much he is going to earn for that delivery")
	public void the_user_verifies_earnings_from_delivery() {
		Mobile.delay(3)
		String value = Mobile.getAttribute(findTestObject('Object Repository/android.widget.TextView - Earning Value'), 'text', 0)
		value = value.charAt(0)
		this.newEarning = value.toInteger()
	}

	@Then("the user sees that the balance has gone up")
	public void the_user_verifies_balance() {
		TestObject obj = new TestObject()
		obj.addProperty("xpath", ConditionType.EQUALS, "//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[3]")
		String value = Mobile.getAttribute(obj, 'text', 0)
		int newBalance = value.toInteger()
		assert (this.previousBalance + this.newEarning) == newBalance
	}
}