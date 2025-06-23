package pages;

import driver.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.LoggerHelper;
import utilities.ReusableMethods;


import java.io.IOException;
import java.time.LocalDate;

import static driver.Driver.getAppiumDriver;

public class CarPage {

    public CarPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    LoggerHelper loggerHelper = new LoggerHelper();
    Actions actions = new Actions(Driver.getAppiumDriver());



    @AndroidFindBy(id = "com.obilet.androidside:id/find_rent_car_from_pick_up_textView")
    public WebElement placeOfPurchaseClick;

    @AndroidFindBy(id = "com.obilet.androidside:id/search_editText")
    public WebElement placeOfPurchaseSendKeys;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.obilet.androidside:id/find_journey_location_recyclerView\"]/android.widget.LinearLayout[1]")
    public WebElement locationClick;

    @AndroidFindBy(id = "com.obilet.androidside:id/find_rent_car_pick_up_hour_layout")
    public WebElement pickUpTime;

    @AndroidFindBy(id = "com.obilet.androidside:id/find_rent_car_drop_hour_layout")
    public WebElement dropOffTime;

    @AndroidFindBy(id = "com.obilet.androidside:id/find_rent_car_find_button")
    public WebElement SearchForARentalcarButton;

    @AndroidFindBy(id = "com.obilet.androidside:id/btn_close")
    public WebElement campaignClose;

    @AndroidFindBy(id = "com.obilet.androidside:id/buttonFilter")
    public WebElement filters;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public WebElement highest;

    @AndroidFindBy(id = "com.obilet.androidside:id/buttonFilter")
    public WebElement showVehicle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/input_textView\"])[1]")
    public WebElement dateOfBirthInput;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/input_textView\"])[2]")
    public WebElement drivingLicenseDate;

    @AndroidFindBy(id = "com.obilet.androidside:id/btn_continue")
    public WebElement proceedToPaymentButton;

    @AndroidFindBy(id = "com.obilet.androidside:id/bottom_nav_find_journey")
    public WebElement homeSerachButton;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.obilet.androidside:id/linearLayoutRoot\"])[3]")
    public WebElement SelectingACarFromAList;

    @Step("Go to the cars page and select a city")
    public void goToTheCarsPageAndSelectCity() {
        ReusableMethods.scrollWithUiScrollableAndClick("Araç");
        loggerHelper.info("Go to the vehicle section on the Obilet homepage");


        placeOfPurchaseClick.click();
        loggerHelper.info("Clicks on the search box to select a pickup location");

        placeOfPurchaseSendKeys.sendKeys("Ankara Yüksek Hızlı Tren Garı");
        loggerHelper.info("Enter the place where you bought the car into the search box");

        actions.sendKeys(Keys.ENTER).perform();
        ReusableMethods.wait(5);
        loggerHelper.info("After entering the required purchase location, you can search here with enter to list the results.");

        locationClick.click();
        ReusableMethods.wait(5);
        loggerHelper.info("Selects the pickup location as Ankara from the listed search results.");

    }


    @Step("Selects vehicle pick-up date and drop-off date")
    public void selectCheckInAndOutDates() {
        LocalDate today = LocalDate.now();
        LocalDate checkIn = today.plusDays(3);
        LocalDate checkOut = today.plusDays(6);

        String checkInDay = String.valueOf(checkIn.getDayOfMonth());
        String checkOutDay = String.valueOf(checkOut.getDayOfMonth());

        // Giriş ve çıkış tarihi seçim adımları
        ReusableMethods.scrollWithUiScrollableAndClick("ALIŞ TARİHİ");
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='" + checkInDay + "']")).click();
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='" + checkOutDay + "']")).click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("UYGULA");
        ReusableMethods.wait(2);
    }


    @Step("Searches by filtering the desired features of the car")
    public void filterByCriteria(){
        filters.click();
        ReusableMethods.scrollWithUiScrollableAndClick("Benzin");
        ReusableMethods.scrollWithUiScrollableAndClick("Otomatik");
        highest.sendKeys("8000");
        ReusableMethods.wait(10);
        showVehicle.click();
        ReusableMethods.wait(6);
        ReusableMethods.scrollWithUiScrollableAndClick("Detaylar");
        ReusableMethods.scrollWithUiScrollableAndClick("Seç ve Devam Et");
        ReusableMethods.wait(3);
        ReusableMethods.scrollWithUiScrollableAndClick("Ödemeye Geç");
    }

    @Step("Enters the pick-up time and delivery time")
    public void pickupAndDropOffTime(){
        pickUpTime.click();
        ReusableMethods.scrollWithUiScrollableAndClick("03:00");
        ReusableMethods.wait(1);
        dropOffTime.click();
        ReusableMethods.wait(1);
        ReusableMethods.scrollWithUiScrollableAndClick("11:00");
        ReusableMethods.wait(1);
        SearchForARentalcarButton.click();
        loggerHelper.info("Press the search button and find a vehicle that matches the date.");
    }

    public void campaignClose(){
        campaignClose.click();
        loggerHelper.info("Opened ad campaign is closed");

    }


}
