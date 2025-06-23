package tests;

import driver.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FavoriPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

public class CurrencySwitcherTest extends BaseTest {

    HomePage homePage = new HomePage();
    FavoriPage favoriPage = new FavoriPage();
    SearchPage searchPage = new SearchPage();

    LoggerHelper loggerHelper = new LoggerHelper();

    @Test
    public void testChangeCurrencyFromTRYToEUR() {

        // User logs in
        homePage.login();

        // The user sees and clicks the "My Account" button on the homepage
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");
        ReusableMethods.wait(2);
        loggerHelper.info("The user sees and clicks the 'My Account' button on the homepage");

        // The user sees and clicks the "Settings" button
        ReusableMethods.scrollWithUiScrollableAndClick("Ayarlar");
        ReusableMethods.wait(2);
        loggerHelper.info("The user sees and clicks the 'Settings' button");

        // The user sees and clicks the "Currency" button
        ReusableMethods.scrollWithUiScrollableAndClick("Para Birimi");
        ReusableMethods.wait(2);
        loggerHelper.info("The user sees and clicks the 'Currency' button");

        // The user sees and clicks the Euro (EUR) currency option
        ReusableMethods.scrollWithUiScrollableAndClick("Euro (EUR)");
        ReusableMethods.wait(7);
        loggerHelper.info("The user sees and clicks the Euro (EUR) currency option");

        // The user sees the 'From', 'To', and 'Departure Date' fields in the Bus Search section and enters data
        // (From: İzmir, To: Ankara, Departure Date: Tomorrow)
        searchPage.searchBusTickets("İzmir", "Ankara", "Yarın");

        // The user sees and clicks the "Search Bus" button
        ReusableMethods.scrollWithUiScrollableAndClick("Otobüs Ara");
        ReusableMethods.wait(7);
        loggerHelper.info("The user sees and clicks the 'Search Bus' button");

        // The user sees that the prices in the search results are displayed in EUR
        searchPage.euroIcon.isDisplayed();
        String el1 = searchPage.euroIcon.getText();
        String el2 = "€";
        Assert.assertEquals(el1, el2);
        loggerHelper.info("The user sees that the prices in the search results are displayed in EUR");

        // The user resets the test data
        searchPage.cleanupTestDataCurrency();
        loggerHelper.info("The user resets the test data");
    }
}
