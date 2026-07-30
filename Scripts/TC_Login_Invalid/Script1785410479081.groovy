import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ========================================
// 1. BUKA BROWSER
// ========================================
WebUI.openBrowser(GlobalVariable.URL)

// ========================================
// 2. KLIK "MAKE APPOINTMENT"
// ========================================
WebUI.click(findTestObject('Page_Homepage/a_Make Appointment'))

// ========================================
// 3. ISI USERNAME BENAR, PASSWORD SALAH
// ========================================
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)
WebUI.setText(findTestObject('Page_Login/input_Password'), 'SalahPassword123')

// ========================================
// 4. KLIK LOGIN
// ========================================
WebUI.click(findTestObject('Page_Login/button_Login'))

// ========================================
// 5. VERIFIKASI MUNCUL PESAN ERROR
// ========================================
WebUI.verifyElementVisible(findTestObject('Page_Login/p_LoginFailed'))

// ========================================
// 6. TUTUP BROWSER
// ========================================
WebUI.closeBrowser()