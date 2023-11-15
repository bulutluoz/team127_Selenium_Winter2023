package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C01_ByClassnameLocator {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu.com sayfasina gidin
        driver.get("https://www.testotomasyonu.com");
        // arama kutusuna phone yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        // arama yapildiktan sonra, sol tarafta cikan Categories menusundeki
        // kategori sayisinin 8 oldugunu test edin

        int expectedKategoriSayisi= 8;
        List<WebElement> kategoriElementleriList = driver.findElements(By.className("acc_head"));
        int actualKategoriSayisi = kategoriElementleriList.size();

        if (expectedKategoriSayisi == actualKategoriSayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else {
            System.out.println("Kategori sayisi testi FAILED");
            System.out.println("Actual kategori sayisi : " + actualKategoriSayisi);
        }


        // kategorileri yazdirin

        // System.out.println(kategoriElementleriList);

        // Bu List webelementler'den olusuyor
        // webelementler uzerindeki yaziyi direk yazdiramayiz
        // her bir webelementi ele alip, uzerindeki yaziyi yazdirmamiz gerekir

        /*
        yazdirma islemini bir for-each loop ile yapabiliriz
        ama biz bu islemi cok kullanacagimiz icin
        bir method olusturup
        webelementlerden olusan listeyi
        String'lerden olusan bir listeye cevirdik


        for (WebElement each:kategoriElementleriList
             ) {

            System.out.println(each.getText());
        }

         */

        System.out.println(ReusableMethods.stringListeDonustur(kategoriElementleriList));

        Thread.sleep(3000);
        driver.close();

    }
}
