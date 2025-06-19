package pages;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static driver.Driver.getAppiumDriver;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/fav_button\"])[1]")
    public WebElement favoriButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/back_arrow_toolbar\"]")
    public WebElement backButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement firstOtelOnSearchList;

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


}
