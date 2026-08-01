# CURA Healthcare Service - Automation Testing Project

![Katalon Studio](https://img.shields.io/badge/Katalon-10.2.0-00a8e8?style=flat-square&logo=katalon)
![Test Status](https://img.shields.io/badge/Status-Pass-00aa00?style=flat-square)
![GitHub repo size](https://img.shields.io/github/repo-size/willyjonatan/CURA-Healthcare-Automation?style=flat-square)
![GitHub last commit](https://img.shields.io/github/last-commit/willyjonatan/CURA-Healthcare-Automation?style=flat-square)

---

## Gambaran Proyek

Proyek ini merupakan **proyek automation testing** untuk aplikasi web [CURA Healthcare Service](https://katalon-demo-cura.herokuapp.com/). Seluruh skenario pengujian dirancang dan dieksekusi secara otomatis menggunakan **Katalon Studio**, tanpa intervensi manual.

Pengujian dilakukan dengan pendekatan Page Object Model (POM) untuk memastikan kemudahan perawatan dan skalabilitas skrip. Pengujian mencakup validasi fungsionalitas utama aplikasi, seperti proses login, pembuatan janji temu, dan verifikasi histori, dengan menerapkan berbagai strategi pengujian, termasuk positif, negatif, validasi, dan data-driven.

## Tujuan Pengujian

- Memastikan fungsionalitas utama aplikasi berjalan sesuai harapan.
- Mengidentifikasi potensi kesalahan atau kerentanan pada alur bisnis kritis.
- Membangun skrip pengujian yang terstruktur, mudah dipelihara, dan dapat digunakan kembali.
- Memberikan dokumentasi eksekusi pengujian yang jelas dan terukur.

---

## Lingkup Pengujian

| **Test Case ID** | **Test Case Name** | **Jenis Pengujian** | **Deskripsi** |
| :--- | :--- | :--- | :--- |
| TC-001 | Login Valid | Positif | Memverifikasi login berhasil dengan kredensial yang benar. |
| TC-002 | Login Invalid | Negatif | Memverifikasi pesan error saat login dengan password yang salah. |
| TC-003 | Make Appointment - End to End | Fungsional | Menguji proses pembuatan janji temu dan verifikasi histori. |
| TC-004 | Make Appointment - Empty Form | Validasi | Memastikan sistem menolak pengiriman form kosong. |
| TC-005 | Make Appointment - Data Driven | Data-Driven | Memverifikasi pemrosesan beberapa skenario data dari berkas Excel. |

---

## Tools yang Digunakan

| **Tools** | **Fungsi** |
| :--- | :--- |
| **Katalon Studio** (v10.2.0) | Platform utama untuk pembuatan dan eksekusi skrip automation. |
| **Google Chrome** | Browser untuk menjalankan skrip pengujian. |
| **Groovy** | Bahasa pemrograman untuk menulis skrip di Katalon. |
| **Git & GitHub** | Kontrol versi dan repositori kode. |
| **Microsoft Excel** | Menyimpan data eksternal untuk pengujian *data-driven*. |

    
---

## 📄 Dokumentasi

Dokumentasi lengkap terkait perencanaan dan hasil pengujian dapat diakses melalui tautan berikut:

| **Dokumen** | **Deskripsi** | **Akses** |
| :--- | :--- | :--- |
| **Test Case Documentation** | Berisi daftar skenario uji, langkah-langkah, dan hasil yang diharapkan. | [📥 Test_Case_Documentation.xlsx](./Documentation/Test Case Documentation.xclsx) |
| **Test Execution Report** | Laporan hasil eksekusi otomatis dari Katalon Studio (format PDF). | [📥 Lihat Laporan](./Documentation/Result.pdf) |

---

## Struktur Proyek CURA Healthcare Automation

Struktur direktori proyek ini diorganisir mengikuti prinsip Page Object Model (POM) untuk menjaga kode tetap bersih, terstruktur, dan mudah dipelihara (modular).

```text
CURA_Healthcare_Automation/
│
├── Test Cases/                   # Kumpulan skrip test case
│   ├── TC_Login_Valid1
│   ├── TC_Login_Invalid
│   ├── TC_Make_Appointment
│   ├── TC_Appointment_EmptyForm
│   └── TC_Appointment_DataDriven
│
├── Profiles/                     # Konfigurasi Global Variables
│   └── default
│
├── Object Repository/             # Objek-objek UI (Page Object Model)
│   ├── Page_Homepage
│   ├── Page_Login
│   ├── Page_Appointment
│   ├── Page_Confirmation
│   └── Page_History
│
├── Test Suites/                  # Suite untuk menjalankan semua test case
│   └── TS_Regression_Suite
│
└── Data Files/                    # Sumber data untuk pengujian data-driven
    └── AppointmentTestData.xlsx
```
---
