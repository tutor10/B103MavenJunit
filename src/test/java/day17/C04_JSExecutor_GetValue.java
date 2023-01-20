package day17;

import org.junit.Test;
import utilities.TestBase;

public class C04_JSExecutor_GetValue extends TestBase{


    @Test
    public void test() {

        //    *****ODEV*****
        // 1)https://www.priceline.com/ a git

        // 2)getValueTest metotu olustur

        // 3)Tarih kısmındaki Yazili metinleri al ve yazdır

        driver.get("https://www.priceline.com/");

        getValueByJS("hotelDates");

    }
}
