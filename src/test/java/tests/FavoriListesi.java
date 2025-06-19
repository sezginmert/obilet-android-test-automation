package tests;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavoriPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

public class FavoriListesi {

    HomePage homePage = new HomePage();
    FavoriPage favoriPage = new FavoriPage();
    SearchPage searchPage = new SearchPage();

    LoggerHelper loggerHelper = new LoggerHelper();

    @Test
    public void getfavoriListesi() {


        //Kullanıcı login olur
        homePage.login();
        loggerHelper.info("Kullanici login olur");

        // kullanici anasayfadaki Otel butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Ara");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Otel");
        loggerHelper.info("Kullanici anasayfaya gider ve Otel butonunu görür ardından tiklar");

        // kullanici NEREYE butonunu görür ve Antalya secer
        searchPage.clickAndChooseWhere("NEREYE", "Antalya");
        ReusableMethods.wait(2);
        loggerHelper.info("Kullanici NEREYE butonunu görür tiklar ve ardindan Antalya'yi secer");

        // kullanici Giriş Tarihi , Çıkış Tarihi butonunu görür ve verileri girer ( Giriş : 04-07-2025 , Çıkış : 07-07-2025)
        ReusableMethods.scrollWithUiScrollableAndClick("GİRİŞ TARİHİ");
        ReusableMethods.wait(2);
        searchPage.fourJuly.click();
        ReusableMethods.wait(2);
        searchPage.sevenJuly.click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("UYGULA");
        loggerHelper.info("Kullanici Giris Tarihi ve Cikis Tarihi butonlarini görür ve verileri girer");

        // Kullanici Otel Ara butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Otel Ara");
        ReusableMethods.wait(4);
        String el1 = searchPage.firstOtelOnSearchList.getText().toLowerCase();
        loggerHelper.info("Kullanici Otel Ara butonunu görür ve tiklar");

        // kullanici cikan sonuclardan ilk otelin resmindeki sol üstteki favoriye al butonunu görüntüler ve tiklar
        searchPage.favoriButton.isDisplayed();
        searchPage.favoriButton.click();
        ReusableMethods.wait(4);
        loggerHelper.info("Kullanici cikan sonuclardan ilk otelin resmindeki sol üstteki favoriye al butonunu görüntüler ve tiklar");


        // kullanici "Antalya 2025 Summer" adli favori listesi olusturur   ( tamamlanmadı)

        favoriPage.favListName.clear();
        ReusableMethods.wait(2);
        favoriPage.favListName.sendKeys("Antalya 2025 Summer");
        ReusableMethods.wait(3);
        ReusableMethods.scrollWithUiScrollableAndClick("Yeni Liste Oluştur");
        ReusableMethods.wait(3);
        loggerHelper.info("kullanici  Antalya 2025 Summer  adli favori listesi olusturur");
        ReusableMethods.wait(5);

        // kullanici anasyafaya geri döner
        searchPage.backButton.click();
        loggerHelper.info("Kullanici anasayfaya geri doner");


        // kullanici hesabim butonunu görür ve tiklar
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");
        loggerHelper.info("Kullanici hesabim butonunu gorur ve tiklar");


        // kullanici favorilerim Butonunu görür ve tiklar
        favoriPage.favList.isDisplayed();
        favoriPage.favList.click();
        loggerHelper.info("kullanici favorilerim Butonunu görür ve tiklar");

        // kullanici "Antalya 2025 Summer" adli favori listesini görür ve tiklar
        favoriPage.favFirstList.click();
        ReusableMethods.wait(2);
        loggerHelper.info("kullanici \"Antalya 2025 Summer\" adli favori listesini görür ve tiklar");


        // kullanici favoriye aldigi oteli bu listede görür

        String el2 = favoriPage.firstOtelOnFavList.getText().toLowerCase();

        Assert.assertEquals(el1, el2);
        loggerHelper.info(" kullanici favoriye aldigi oteli bu listede görür");

       // yapilan islemlerin silinmesi
        favoriPage.cleanupTestData();


    }
}
