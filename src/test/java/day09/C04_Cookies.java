package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void hanleCookiesTest() {

//        Class: Cookies
//        Method: handleCookies
//        Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies=driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada"+" "+ cookieSayisi +" "+ "adet cookie var");

//        3. Bir Cookie yi smiyle bul
        // tum cookie leri yazdiralim
        //allCookies.stream().forEach(t -> System.out.println(t.getName()));//Lambda ile

        for(Cookie eachCookie : allCookies){
            System.out.println("COOKIE:" + eachCookie);//COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI:" + eachCookie.getName());
        }
        System.out.println("Cookiyi Ismiyle Cagiriyorum:"+driver.manage().getCookieNamed("i18n-prefs"));

//        4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam","antep-fistikli-Cikolata");//COOKIE OLUSTUR
        driver.manage().addCookie(favoriCookiem);//SAYFAYA YENI COOKIE EKLE
        waitFor(3);
        System.out.println("Yeni Cookie Sayisi:"+driver.manage().getCookies().size());//COOKIE SAYISI ARTTI

//        5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");

//        6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(3);
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());
    }
}


