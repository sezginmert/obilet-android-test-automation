package pages;

import driver.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static driver.Driver.getAppiumDriver;

public class HomePage {


    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement allowButton;


    public void login() {
        ReusableMethods.scrollWithUiScrollableAndClick("Hesabım");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("ÜYE GİRİŞİ YAPIN");
        ReusableMethods.wait(2);
        ReusableMethods.scrollAndSendKeysToElement("E-mail adresinizi giriniz.", "oguzhanmelihguclusck@gmail.com");
        ReusableMethods.wait(2);
        ReusableMethods.scrollAndSendKeysToElement("Doldurulması zorunludur.", "Test123456");
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick("Giriş Yap");
    }


    // oguzhan

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/tv_day_number\"])[34]")
    public WebElement dortTemmuz;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.obilet.androidside:id/tv_day_number\"])[37]")
    public WebElement yediTemmuz;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/fav_button\"])[1]")
    public WebElement favoriButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.obilet.androidside:id/back_arrow_toolbar\"]")
    public WebElement backButton;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.obilet.androidside:id/item_root_layout\"])[3]")
    public WebElement favoriList;

    @AndroidFindBy (xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement firstOtelonList;

    @AndroidFindBy (xpath = "(//*[@class='android.widget.TextView'])[4]")
    public WebElement firstOtelonFavoriList;


    public void clickAndChooseNereye(String text01, String text02) {
        ReusableMethods.scrollWithUiScrollableAndClick(text01);
        ReusableMethods.wait(2);
        ReusableMethods.scrollWithUiScrollableAndClick(text02);

    }


}
