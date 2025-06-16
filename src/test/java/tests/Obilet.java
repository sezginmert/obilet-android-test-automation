package tests;


import driver.Driver;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ReusableMethods;


public class Obilet {

    HomePage homePage = new HomePage();

    @Test
    public void obiletTest() {

        // kullanici gerekli ayarlamalari yapar
        Driver.getAppiumDriver();

        //Kullanıcı login olur
        homePage.login();

    }
}
