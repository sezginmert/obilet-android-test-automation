package tests;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ReusableMethods;

public class FavoriListesi {

    HomePage homePage = new HomePage();

    @Test
    public void getfavoriListesi() {

        // kullanici gerekli ayarlamalari yapar
        Driver.getAppiumDriver();

        //Kullanıcı login olur
        homePage.login();

        // kullanici anasayfadaki Otel butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Ara");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Otel");

        // kullanici NEREYE butonunu görür ve Antalya secer
        homePage.clickAndChooseNereye("NEREYE", "Antalya");
        ReusableMethods.wait(2);

        // kullanici Giriş Tarihi , Çıkış Tarihi butonunu görür ve verileri girer ( Giriş : 04-07-2025 , Çıkış : 07-07-2025)
        ReusableMethods.scrollWithUiScrollableAndClick("GİRİŞ TARİHİ");
       ReusableMethods.wait(2);
        homePage.dortTemmuz.click();
        ReusableMethods.wait(2);
        homePage.yediTemmuz.click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("UYGULA");

        // Kullanici Otel Ara butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Otel Ara");
        ReusableMethods.wait(4);

        // kullanici cikan sonuclardan ilk otelin resmindeki sol üstteki favoriye al butonunu görüntüler ve tiklar
        homePage.favoriButton.isDisplayed();
        homePage.favoriButton.click();

        // kullanici Yeni Liste Oluştur butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Yeni Liste Oluştur");


        // kullanici "Antalya 2025 Summer" adli favori listesi olusturur   ( tamamlanmadı)
        ReusableMethods.scrollAndSendKeysToElement("Antalya, 2025","Antalya 2025 Summer");
        ReusableMethods.wait(3);

        // kullanici anasyafaya geri döner
        homePage.backButton.click();

        // kullanici hesabim butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");

        // kullanici favorilerim Butonunu görür ve tiklar
        homePage.favoriList.isDisplayed();
        homePage.favoriList.click();

        // kullanici "Antalya 2025 Summer" adli favori listesini görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Antalya 2025 Summer");

        // kullanici favoriye aldigi oteli bu listede görür
        String el1= homePage.firstOtelonList.getText();
        String el2=homePage.firstOtelonFavoriList.getText();

        Assert.assertEquals(el1,el2);



    }
}
