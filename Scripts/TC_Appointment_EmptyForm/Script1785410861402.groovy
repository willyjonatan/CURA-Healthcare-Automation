import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// ========================================
// 1. LOGIN DULU
// ========================================
WebUI.openBrowser(GlobalVariable.URL)
WebUI.click(findTestObject('Page_Homepage/a_Make Appointment'))
WebUI.setText(findTestObject('Page_Login/input_Username'), GlobalVariable.username)
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.password)
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.verifyElementVisible(findTestObject('Page_Appointment/h2_Make Appointment'))

// ========================================
// 2. LANGSUNG KLIK BOOK APPOINTMENT (TANPA ISI FORM)
// ========================================
WebUI.click(findTestObject('Page_Appointment/button_BookAppointment'))

// ========================================
// 3. VERIFIKASI: TETAP DI HALAMAN "MAKE APPOINTMENT"
// ========================================
// Karena tidak ada pesan error, kita verifikasi bahwa halaman tidak berubah
// yaitu judul "Make Appointment" masih terlihat
WebUI.verifyElementVisible(findTestObject('Page_Appointment/h2_Make Appointment'))

// ========================================
// 4. TUTUP BROWSER
// ========================================
WebUI.closeBrowser()