package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.List;

public class C02_ByClassname {

    public static void main(String[] args) {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        List<WebElement> kategoryElementleriList = driver.findElements(By.className("panel-title"));
        //4- Category bolumunde 3 element oldugunu test edin

        int expectedKategoriSayisi = 3;
        int actualKategoriSayisi = kategoryElementleriList.size();

        if (expectedKategoriSayisi == actualKategoriSayisi){
            System.out.println("Kategori sayisi testi PASSED");
        }else {
            System.out.println("Kategori sayisi testi FAILED");
        }

        //5- Category isimlerini yazdirin
        System.out.println(ReusableMethods.stringListeDonustur(kategoryElementleriList));
        //6- Sayfayi kapatin
        driver.close();
    }
}
