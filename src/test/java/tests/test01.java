package tests;


import driver.Driver;
import org.testng.annotations.Test;


public class test01 {


    @Test
    public void test001() {


        // kullanici gerekli ayarlamalari yapar
        Driver.getAppiumDriver();

    }
}
