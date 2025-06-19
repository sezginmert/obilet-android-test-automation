# 📱 Obilet Mobile Test Automation Project

Bu proje, **Obilet** mobil uygulamasını **Pixel 8 Pro** cihazı üzerinde test etmek için oluşturulmuştur. Testler **Java (JDK 23.0.1)**, **Appium 2.0**, **TestNG** ile yazılmış ve **Allure** ile raporlanmıştır. Hedef, mobil uygulamanın tüm kritik işlevlerinin uçtan uca otomasyon testleriyle güvence altına alınmasıdır.

---

## 🚀 Kullanılan Teknolojiler ve Araçlar

| Teknoloji / Araç     | Açıklama                                      |
|----------------------|-----------------------------------------------|
| Java (JDK 23.0.1)     | Test senaryoları için yazılım dili            |
| Appium 2.0            | Mobil uygulama otomasyon framework'ü         |
| TestNG                | Test çalıştırma ve yönetim aracı             |
| Allure Reports        | Test raporlama aracı                          |
| Maven                 | Proje yapılandırması ve bağımlılık yönetimi  |
| Android Emulator      | Pixel 8 Pro / Android 14.0 cihaz ortamı      |

---

## 📱 Test Ortamı

- **Uygulama:** Obilet (Native Android App)
- **Cihaz:** Pixel 8 Pro
- **Android Sürümü:** 14.0
- **APK Dosyası:** `obilet.apk`
- **Test Tipi:** Native Mobile App Automation (End-to-End)

---

## 📁 Proje Yapısı

---
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


---

## 🧭 Test Kapsamı (User Stories)

- ✅ **US_01:** Araç kiralama filtreleme testi
- ✅ **US_02:** Uçak bileti arama ve satın alma
- ✅ **US_03:** Otel favori listesine ekleme ve kontrol
- ✅ **US_04:** Para birimini değiştirerek otobüs bileti arama

Tüm test senaryoları `tests/` klasörü altında sınıflandırılmıştır.

---


## 📬 İletişim

- **Test Owner / QA Engineer:** Oğuzhan Melih Güçlü  
- **E-posta:** [oguzhanmguclu@gmail.com](mailto:oguzhanmguclu@gmail.com)  
- **LinkedIn:** [linkedin.com/in/oguzhanmelihguclu](https://www.linkedin.com/in/oguzhanmelihguclu/)

