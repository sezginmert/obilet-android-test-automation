# 📱 Obilet Mobile Test Automation Project

This project is created to test the **Obilet** mobile application on a **Pixel 8 Pro** device. The tests are written with **Java (JDK 23.0.1)**, **Appium 2.0**, and **TestNG**, and reported using **Allure**. The goal is to secure all critical functionalities of the mobile app with end-to-end automation tests.

---

## 🚀 Technologies and Tools Used

| Technology / Tool    | Description                                  |
|---------------------|----------------------------------------------|
| Java (JDK 23.0.1)   | Programming language for test scenarios      |
| Appium 2.0          | Mobile application automation framework      |
| TestNG              | Test execution and management tool           |
| Allure Reports      | Test reporting tool                           |
| Maven               | Project configuration and dependency management |
| Android Emulator    | Pixel 8 Pro / Android 14.0 device environment |

---

## 📱 Test Environment

- **Application:** Obilet (Native Android App)  
- **Device:** Pixel 8 Pro  
- **Android Version:** 14.0  
- **APK File:** `obilet.apk`  
- **Test Type:** Native Mobile App Automation (End-to-End)  

---

## 📁 Project Structure

```
ObiletMobileTesting/
├── .idea/
├── Drivers/
├── logs/
├── src/
│   └── test/
│       ├── java/
│       │   ├── driver/
│       │   │   ├── BaseTest
│       │   │   ├── BrowserDriver
│       │   │   └── Driver
│       │   ├── pages/
│       │   │   ├── CarPage
│       │   │   ├── FavoriPage
│       │   │   ├── HomePage
│       │   │   ├── LoginAndCreatePage
│       │   │   └── SearchPage
│       │   ├── tests/
│       │   │   ├── AddHotelToFavoritesTest
│       │   │   ├── CurrencySwitcherTest
│       │   │   └── ObiletCarSearchTest
│       │   └── utilities/
│       │       ├── ConfigReader
│       │       ├── LoggerHelper
│       │       ├── OptionsMet
│       │       ├── ReusableMethods
│       │       └── ScreenshotUtil
│       └── resources/
│           ├── Apk Bilgisi_2.3.4_apkcombo.com
│           ├── log4j2.xml
│           └── obilet.apk
├── target/
├── .gitignore
├── configuration.properties
├── pom.xml
├── README.md
├── testng.xml
├── External Libraries/

```
## 📊 Test Report

Below is the Allure Report screenshot generated for the **Obilet Mobile Test Automation Project**, demonstrating overall suite execution and visual test summaries:



- **Suite:** ObiletMobileTesting  
- **Test Classes Covered:** AddHotelToFavoritesTest, CurrencySwitcherTest, ObiletCarSearchTest  
- **Total Tests:** 3  
- **Passed:** ✅ All tests successfully executed  
- **Report Type:** Interactive HTML powered by Allure  
- **Generated Using:** `allure serve target/allure-results`



---

## 🧭 Test Scope (User Stories)

- ✅ **US_01:** Vehicle rental filtering test  
- ✅ **US_02:** Flight ticket search and purchase  
- ✅ **US_03:** Adding to and checking hotel favorites list  
- ✅ **US_04:** Bus ticket search by changing the currency  

All test scenarios are categorized under the `tests/` folder.

---

## 📬 Contact
- **Test Owner / QA Engineer:** Sezgin MERT
- **LinkedIn:** [https://www.linkedin.com/in/sezginmert/](https://www.linkedin.com/in/sezginmert/)
