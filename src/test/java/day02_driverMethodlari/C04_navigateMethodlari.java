package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // testotomasyonu ana sayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // title'in Otomasyon icerdigini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Testotomasyonu title testi PASSED");
        }else{
            System.out.println("Testotomasyonu title testi FAILED");
        }

        // sonra Wisequarter anasayfaya gidin
        driver.navigate().to("https://www.wisequarter.com");

        // Url'in wisequarter icerdigini test edin

        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("wisequarter URL testi PASSED");
        }else {
            System.out.println("wisequarter URL testi FAILED");
        }

        // tekrar testotomasyonu sayfasina donun
        driver.navigate().back();

        // url'in otomasyon icerdigini test edin

        expectedUrlIcerik = "otomasyon";
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("testotomasyonu URL testi PASSED");
        }else {
            System.out.println("testotomasyonu URL testi FAILED");
            System.out.println("actual URL : " + actualUrl);
        }



        // sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();

    }
}
