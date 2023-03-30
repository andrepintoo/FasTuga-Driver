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

Mobile.startApplication('C:\\Users\\sfili\\Katalon Studio\\taes22_grupow_fastugadriver_tests.git\\Apk\\app-debug.apk', true)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - email'), 'nicole.azevedo@mail.pt',    0)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - password'), '12345678', 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - LOGIN'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.TextView - Welcome'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.ImageView - Menu'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.CheckedTextView - Opt Out'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.RelativeLayout - Opt Out Confirmation'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - YES'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - REGISTER'), 0)

Mobile.setText(findTestObject('Object Repository/android.widget.EditText - email register2'), 'nicole.azevedo@mail.pt', 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - REGISTER register2'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/android.widget.RelativeLayout - Contact Administrator'), 0)

Mobile.closeApplication()