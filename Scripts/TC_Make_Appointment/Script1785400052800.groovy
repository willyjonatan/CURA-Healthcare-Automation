import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ========================================
// 1. LOGIN (LANGSUNG)
// ========================================
WebUI.openBrowser(GlobalVariable.URL)
WebUI.click(findTestObject('Page_Homepage/a_Make Appointment'))
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.password)
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.verifyElementVisible(findTestObject('Page_Appointment/h2_Make Appointment'))

// ========================================
// 2. ISI FORM APPOINTMENT
// ========================================
WebUI.selectOptionByValue(findTestObject('Page_Appointment/select_Facility'), 
                          GlobalVariable.facility, false)
WebUI.check(findTestObject('Page_Appointment/input_ApplyForHospitalReadmission'))
WebUI.click(findTestObject('Page_Appointment/input_HealthcareProgram_Medicaid'))
WebUI.setText(findTestObject('Page_Appointment/input_VisitDate'), GlobalVariable.visitDate)
WebUI.setText(findTestObject('Page_Appointment/textarea_Comment'), GlobalVariable.comment)

// ========================================
// 3. BOOK APPOINTMENT
// ========================================
WebUI.click(findTestObject('Page_Appointment/button_BookAppointment'))

// ========================================
// 4. VERIFIKASI KONFIRMASI
// ========================================
WebUI.verifyElementVisible(findTestObject('Page_Confirmation/p_ConfirmationText'))

// ========================================
// 5. KEMBALI KE HOMEPAGE
// ========================================
WebUI.click(findTestObject('Page_Confirmation/a_GoToHomepage'))

// ========================================
// 6. BUKA HISTORY
// ========================================
WebUI.click(findTestObject('Page_History/button_ToggleMenu'))
WebUI.delay(1)
WebUI.click(findTestObject('Page_History/a_History'))
WebUI.delay(2)

// ========================================
// 7. VERIFIKASI DATA DI HISTORY
// ========================================
WebUI.verifyElementText(findTestObject('Page_History/p_Facility'), 
                        GlobalVariable.facility)
WebUI.verifyElementText(findTestObject('Page_History/p_Program'), 
                        'Medicaid')
WebUI.verifyElementText(findTestObject('Page_History/p_Comment'), 
                        GlobalVariable.comment)

// ========================================
// 8. TUTUP BROWSER
// ========================================
WebUI.delay(2)
WebUI.closeBrowser()