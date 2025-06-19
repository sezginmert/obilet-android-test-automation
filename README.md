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
│       │   │   ├── BaseTest.java
│       │   │   ├── BrowserDriver.java
│       │   │   └── Driver.java
│       │   ├── pages/
│       │   │   ├── FavoriPage.java
│       │   │   ├── HomePage.java
│       │   │   └── SearchPage.java
│       │   ├── tests/
│       │   │   ├── FavoriListesi.java
│       │   │   ├── HesapOlusturma.java
│       │   │   └── Obilet.java
│       │   └── utilities/
│       │       ├── ConfigReader.java
│       │       ├── LoggerHelper.java
│       │       ├── OptionsMet.java
│       │       └── ReusableMethods.java
│       └── resources/
│           ├── obilet.apk
│           ├── Apk Bilgisi_2.3.4_apkcombo.com.apk
│           └── log4j2.xml
├── target/
├── .gitignore
├── configuration.properties
├── pom.xml
├── testng.xml
```

---

## 🧭 Test Scope (User Stories)

- ✅ **US_01:** Vehicle rental filtering test  
- ✅ **US_02:** Flight ticket search and purchase  
- ✅ **US_03:** Adding to and checking hotel favorites list  
- ✅ **US_04:** Bus ticket search by changing the currency  

All test scenarios are categorized under the `tests/` folder.

---

## 📬 Contact

- **Test Owner / QA Engineer:** Oğuzhan Melih Güçlü  
- **Email:** [oguzhanmguclu@gmail.com](mailto:oguzhanmguclu@gmail.com)  
- **LinkedIn:** [linkedin.com/in/oguzhanmelihguclu](https://www.linkedin.com/in/oguzhanmelihguclu/)
