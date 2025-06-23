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




















































































































}
