package tests;

import driver.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CarHomePage;
import pages.HomePage;
import utilities.ReusableMethods;

public class CarSearchTest {

    Actions actions = new Actions(Driver.getAppiumDriver());
    CarHomePage carHomePage = new CarHomePage();
    HomePage homePage = new HomePage();

    @Test
    public void carSearchFiltering(){
        ReusableMethods.wait(5);
        ReusableMethods.scrollWithUiScrollableAndClick("Araç");
        carHomePage.placeOfPurchaseClick.click();
        carHomePage.placeOfPurchaseSendKeys.sendKeys("Ankara Yüksek Hızlı Tren Garı");
        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(2);
        carHomePage.locationClick.click();
        ReusableMethods.wait(2);
        carHomePage.rentalDate.click();
        ReusableMethods.wait(2);
        homePage.dortTemmuz.click();
        ReusableMethods.wait(2);
        homePage.yediTemmuz.click();



    }
}
