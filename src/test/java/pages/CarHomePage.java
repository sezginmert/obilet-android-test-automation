package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getAppiumDriver;

public class CarHomePage {

    public CarHomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.obilet.androidside:id/find_rent_car_from_pick_up_textView")
    public WebElement placeOfPurchaseClick;

    @AndroidFindBy(id = "com.obilet.androidside:id/search_editText")
    public WebElement placeOfPurchaseSendKeys;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.obilet.androidside:id/find_journey_location_recyclerView\"]/android.widget.LinearLayout[1]")
    public WebElement locationClick;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/tv_day_number\"])[47]")
    public WebElement rentalDate;

}
