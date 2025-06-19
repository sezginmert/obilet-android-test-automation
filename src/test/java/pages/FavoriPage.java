package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static driver.Driver.getAppiumDriver;

public class FavoriPage {

    SearchPage searchPage = new SearchPage();


    public FavoriPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.obilet.androidside:id/item_root_layout\"])[3]")
    public WebElement favList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/hotel_name_text\"]")
    public WebElement firstOtelOnFavList;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement favListName;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.obilet.androidside:id/list_item_layout\"])[2]")
    public WebElement favFirstList;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/more_options\"]")
    public WebElement favListMoreOptionsButton;

    public void cleanupTestData() {
        favListMoreOptionsButton.click();
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Listeyi Sil");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Tamam");


    }

}
