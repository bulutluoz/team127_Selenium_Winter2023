package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C04_RelativeLocators {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // https://testotomasyonu.com/relativeLocators sayfasina gidin
        driver.get("https://testotomasyonu.com/relativeLocators");
        // DSLR Camera elementini locate edin

        WebElement dslrCameraElementi = driver.findElement(By.id("pic7_thumb"));

        // webelemntin HTML kodunda src tag'inin
        // "testotomasyonu.com/uploads/product" icerdigini test edin

        String srcAttributeValue = dslrCameraElementi.getAttribute("src");

        String expectedHtmlIcerik = "testotomasyonu.com/uploads/product";

        if (srcAttributeValue.contains(expectedHtmlIcerik)){

            System.out.println("DSLR Camera testi PASSED");
        }else {
            System.out.println("DSLR Camera testi FAILED");
        }

        /*
            Bir websayfasinda
            bir webelementi gorebiliyor, HTML kodlarina ulasabiliyor
            ama locate edemiyorsaniz

            etrafindaki webelementleri kullanarak,
            locate islemini yapabilmemiz icin
            Selenium4 ile birlikte relative locator ozelligi gelmistir

            Relative locator icin
            - hedef elementin en az 1 ozelligi
            - hedef element etrafinda locate edip kullanabildigimiz en az 1 baska webelement
            olmalidir
         */


        // DSLR camera webelementi ve relative locator kullanarak
        // Motor E13 telefonu locate edin

        WebElement motorE13Elementi =
                driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(dslrCameraElementi));

        // Motor E13 telefonunun src attribute'inde 16882639136208024 numarasinin bulundugunu test edin

        expectedHtmlIcerik = "16882639136208024";
        String actualSrcAttributeValue = motorE13Elementi.getAttribute("src");

        if (actualSrcAttributeValue.contains(expectedHtmlIcerik)){
            System.out.println("Motorola E13 testi PASSED");
        }else System.out.println("Motorola E13 testi FAILED");

        // Hp Victus bilgisayarin src attribute'inde 1688033137 numarasinin bulundugunu test edin

       WebElement hpVictusElementi =
               driver.findElement(RelativeLocator.with(By.id("pic12_thumb")).below(dslrCameraElementi));

       expectedHtmlIcerik = "1688033137";
       actualSrcAttributeValue = hpVictusElementi.getAttribute("src");

       if (actualSrcAttributeValue.contains(expectedHtmlIcerik)){
           System.out.println("HP Victus testi PASSED");
       }else System.out.println("HP Victus testi FAILED");


       // Samsung smart watch'un id attribute'nun degerinin "pic13_thumb" oldugunu test edin

        WebElement samsungSmartWatchElementi =
                driver.findElement(RelativeLocator.
                        with(By.tagName("img")).below(motorE13Elementi).toRightOf(hpVictusElementi));


        String expectedIdDegeri = "pic13_thumb";
        String actualIdDegeri = samsungSmartWatchElementi.getAttribute("id");


        if (expectedIdDegeri.equals(actualIdDegeri)){
            System.out.println("Samsung smart watch testi PASSED");
        }else System.out.println("Samsung smart watch testi FAILED");


        Thread.sleep(3000);
        driver.quit();
    }
}
