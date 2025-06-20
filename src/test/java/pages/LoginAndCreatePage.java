package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getAppiumDriver;

public class LoginAndCreatePage {

    public LoginAndCreatePage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }


    @AndroidFindBy(id = "com.obilet.androidside:id/sign_up_now_layout")
    public WebElement hemenUyeOlButton;

    @AndroidFindBy(id = "com.obilet.androidside:id/sign_up_button")
    public WebElement uyeOlButton;

    @AndroidFindBy(id = "com.obilet.androidside:id/exit")
    public WebElement logoutButton;
}
