package pages;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.LoggerHelper;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static driver.Driver.getAppiumDriver;

public class SearchPage {
    LoggerHelper loggerHelper = new LoggerHelper();

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/fav_button\"])[1]")
    public WebElement favoriButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/back_arrow_toolbar\"]")
    public WebElement backButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement firstOtelOnSearchList;

    @AndroidFindBy (xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/item_currency_textView\"])[1]")
    public WebElement euroIcon;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/toolbar_image_navigation\"]")
    public WebElement backButtonBusTicket;


    public void clickAndChooseWhere(String text01, String text02) {
        ReusableMethods.scrollWithUiScrollableAndClick(text01);
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick(text02);

    }

    public void selectCheckInAndOutDates() {
        LocalDate today = LocalDate.now();
        LocalDate checkIn = today.plusDays(3);
        LocalDate checkOut = today.plusDays(6);

        String checkInDay = String.valueOf(checkIn.getDayOfMonth());
        String checkOutDay = String.valueOf(checkOut.getDayOfMonth());

        // Giriş ve çıkış tarihi seçim adımları
        ReusableMethods.scrollWithUiScrollableAndClick("GİRİŞ TARİHİ");
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='" + checkInDay + "']")).click();
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().findElement(By.xpath("//android.widget.TextView[@text='" + checkOutDay + "']")).click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("UYGULA");
    }

    public void searchBusTickets(String city1, String city2, String when) {
        try {
            // Capitalize city names using Turkish locale
            city1 = capitalizeFirstLetterTurkish(city1);
            city2 = capitalizeFirstLetterTurkish(city2);

            ReusableMethods.scrollWithUiScrollableAndClick("NEREDEN");
            ReusableMethods.wait(3);

            ReusableMethods.scrollWithUiScrollableAndClick(city1 + " ");
            ReusableMethods.wait(3);

            ReusableMethods.scrollWithUiScrollableAndClick("NEREYE");
            ReusableMethods.wait(3);

            ReusableMethods.scrollWithUiScrollableAndClick(city2 + " ");
            ReusableMethods.wait(3);

            ReusableMethods.scrollWithUiScrollableAndClick(when);

            LoggerHelper.info("Bus ticket search performed: From " + city1 + ", To " + city2 + ", Date: " + when);
        } catch (Exception e) {
            LoggerHelper.error("An error occurred while performing the bus ticket search: " + e.getMessage());
            throw e;
        }
    }

    // Capitalizes the first letter of a string using Turkish locale rules
    private String capitalizeFirstLetterTurkish(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        Locale turkish = new Locale("tr", "TR");
        return input.substring(0, 1).toUpperCase(turkish) + input.substring(1).toLowerCase(turkish);
    }

    public void cleanupTestDataCurrency(){
        backButtonBusTicket.click();
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Ayarlar");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Para Birimi");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Türk Lirası (TRY)");
        ReusableMethods.wait(7);

    }


}
