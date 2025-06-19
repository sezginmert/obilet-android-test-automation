package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavoriPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

public class AddHotelToFavoritesTest {

    HomePage homePage = new HomePage();
    FavoriPage favoriPage = new FavoriPage();
    SearchPage searchPage = new SearchPage();

    LoggerHelper loggerHelper = new LoggerHelper();

    @Test
    public void shouldAddHotelToFavoritesSuccessfully() {

        // User logs in
        homePage.login();
        loggerHelper.info("User logs in");

        // User sees and clicks the Hotel button on the home page
        ReusableMethods.scrollWithUiScrollableAndClick("Ara");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Otel");
        loggerHelper.info("User navigates to the homepage, sees the Hotel button, and clicks it");

        // User sees the WHERE TO button and selects Antalya
        searchPage.clickAndChooseWhere("NEREYE", "Antalya");
        ReusableMethods.wait(2);
        loggerHelper.info("User sees the WHERE TO button, clicks it, and selects Antalya");

        // User sees the Check-in and Check-out date buttons and enters the data (Check-in: Today+3days , Check-out: Today+6days)
        searchPage.selectCheckInAndOutDates();
        loggerHelper.info("User sees the Check-in and Check-out date buttons and enters the data");

        // User sees and clicks the Search Hotels button
        ReusableMethods.scrollWithUiScrollableAndClick("Otel Ara");
        ReusableMethods.wait(4);
        String el1 = searchPage.firstOtelOnSearchList.getText().toLowerCase();
        loggerHelper.info("User sees and clicks the Search Hotels button");

        // User sees the favorite icon on the top-left corner of the first hotel's image and clicks it
        searchPage.favoriButton.isDisplayed();
        searchPage.favoriButton.click();
        ReusableMethods.wait(4);
        loggerHelper.info("User sees the favorite icon on the top-left corner of the first hotel's image in the results and clicks it");

        // User creates a favorite list named “Antalya 2025 Summer”
        favoriPage.favListName.clear();
        ReusableMethods.wait(2);
        favoriPage.favListName.sendKeys("Antalya 2025 Summer");
        ReusableMethods.wait(3);
        ReusableMethods.scrollWithUiScrollableAndClick("Yeni Liste Oluştur");
        ReusableMethods.wait(3);
        loggerHelper.info("User creates a favorite list named 'Antalya 2025 Summer'");
        ReusableMethods.wait(5);

        // User navigates back to the home page
        searchPage.backButton.click();
        loggerHelper.info("User navigates back to the home page");

        // User sees and clicks the My Account button
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");
        loggerHelper.info("User sees and clicks the My Account button");

        // User sees and clicks the My Favorites button
        favoriPage.favList.isDisplayed();
        favoriPage.favList.click();
        loggerHelper.info("User sees and clicks the My Favorites button");

        // User sees and clicks the favorite list named “Antalya 2025 Summer”
        favoriPage.favFirstList.click();
        ReusableMethods.wait(2);
        loggerHelper.info("User sees and clicks the favorite list named 'Antalya 2025 Summer'");

        // User sees the hotel they added to favorites in this list
        String el2 = favoriPage.firstOtelOnFavList.getText().toLowerCase();
        Assert.assertEquals(el1, el2);
        loggerHelper.info("User sees the hotel they added to favorites in this list");

        // Test data cleanup
        favoriPage.cleanupTestData();
    }
}
