import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.testobject.ConditionType

Mobile.startApplication('.\\Apk\\app-debug.apk', false)
Mobile.tap(findTestObject('Object Repository/android.widget.CheckBox - Keep Me Logged In'), 0)
Mobile.setText(findTestObject('Object Repository/android.widget.EditText - email'), 'contacto@email.pt',0)
Mobile.setText(findTestObject('Object Repository/android.widget.EditText - password'), 'password', 0)
Mobile.tap(findTestObject('Object Repository/android.widget.Button - LOGIN'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.ScrollView - Available Orders List'), 0)

TestObject newObj = new TestObject()
newObj.addProperty("xpath", ConditionType.EQUALS, "//android.widget.ScrollView[2]/android.widget.GridLayout[1]/android.widget.Button[1]")

Mobile.tap(newObj, 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - Assign'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.TextView - Welcome'), 0)