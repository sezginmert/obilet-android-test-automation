package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static driver.Driver.getAppiumDriver;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/fav_button\"])[1]")
    public WebElement favoriButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/back_arrow_toolbar\"]")
    public WebElement backButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/tv_day_number\"])[34]")
    public WebElement fourJuly;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/tv_day_number\"])[37]")
    public WebElement sevenJuly;

    @AndroidFindBy (xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement firstOtelOnSearchList;

    public void clickAndChooseWhere(String text01, String text02) {
        ReusableMethods.scrollWithUiScrollableAndClick(text01);
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick(text02);

    }



}
