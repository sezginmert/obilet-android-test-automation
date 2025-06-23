package tests;

import driver.BaseTest;
import driver.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.LoggerHelper;

import java.io.IOException;

public class ObiletCarSearchTest extends BaseTest {

    Actions actions = new Actions(Driver.getAppiumDriver());
    CarPage carPage = new CarPage();
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    LoggerHelper loggerHelper = new LoggerHelper();


    @Test
    public void carSearchAndFiltering() {

        carPage.goToTheCarsPageAndSelectCity();
        loggerHelper.info("Go to the vehicle section on the Obilet homepage");

        carPage.selectCheckInAndOutDates();
        loggerHelper.info("Selects the pick-up date and delivery date");

        carPage.pickupAndDropOffTime();
        loggerHelper.info("Choose pick-up time and delivery time");

        carPage.campaignClose();
        loggerHelper.info("Opened ad campaign is closed");

        carPage.filterByCriteria();
        loggerHelper.info("Filtering is done for the desired features in the vehicle.");


    }


}
