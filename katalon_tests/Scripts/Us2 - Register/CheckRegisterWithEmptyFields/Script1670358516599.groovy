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

Mobile.startApplication('.\\Apk\\app-debug.apk', true)

Mobile.tap(findTestObject('android.widget.Button - REGISTER'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.Button - register from register'), 0)

String errorMsgFisrtName = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - first name register'), 
    'contentDescription', 0)

String errorMsgLastName = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - last name register'), 
    'contentDescription', 0)

String errorMsgEmail = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - email register'), 
    'contentDescription', 0)

String errorMsgPassword = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - password register'), 
    'contentDescription', 0)

String errorMsgPasswordConfirmation = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - password confirmation register'), 
    'contentDescription', 0)

String errorMsgPhoneNumber = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - phone number register'), 
    'contentDescription', 0)

String errorMsgLicensePlate = Mobile.getAttribute(findTestObject('Object Repository/android.widget.EditText - license plate register'), 
    'contentDescription', 0)

assert (((((errorMsgFisrtName.equals('Enter First Name.') || errorMsgLastName.equals('Enter Last Name.')) || errorMsgEmail.equals(
    'Enter Email.')) || errorMsgPassword.equals('Enter Password.')) || errorMsgPasswordConfirmation.equals('Enter Password Confirmation.')) || 
errorMsgPhoneNumber.equals('Enter Phone Number.')) || errorMsgLicensePlate.equals('Enter License Plate.')

Mobile.closeApplication()

