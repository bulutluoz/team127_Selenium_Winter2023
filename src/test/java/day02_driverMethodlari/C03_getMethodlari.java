package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C03_getMethodlari {

    public static void main(String[] args) throws InterruptedException {

        /*
            Selenium 4.12 versiyonu ile
            kendi Webdriver'ini da olusturabiliyor

            Yani artik disardan bir webdriver tanimlama MECBURIYETI kalmadi

            ANCAK... sirketlerin pek cogu kendilerine ozel olarak
            satin aldiklari webdriver'lari kullanabiliyor.

            Biz bu duruma alismak icin
            Selenium webdriver yerine indirdigimiz driver.exe dosyasini kullanmaya devam edecegiz
         */

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");


        // System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle()); // FE5F9AA5BFC6196B91F3382713F26D7A
        // Window handle degeri : selenium'un olusturdugu her webdriver objesine verdigi
        //                        unique bir kod'dur
        //                        Biz bu degerleri birden fazla sayfa acilirsa, sayfalar arasinda gecis yapmak icin kullanacagiz

        System.out.println(driver.getWindowHandles()); // [FE5F9AA5BFC6196B91F3382713F26D7A]
        // aktif webdriver objesinin actigi TUM SAYFALARIN window handle degerlerini getirir


        driver.quit();
    }
}
