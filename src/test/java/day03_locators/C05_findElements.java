package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_findElements {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com adresine gidin
        driver.get("https://www.testotomasyonu.com");
        // shoes linkine tiklayin
        driver.findElement(By.partialLinkText("hoes")).click();

        // cikan urunlerden 3.urune tiklayin
        // 3.urunu ozel olarak locate edemiyorsak, tum urunleri bir list'e atip
        // sonra listedeki 3.urunu secebiliriz
        Thread.sleep(2000);
        List<WebElement> urunElementleriListesi = driver.findElements(By.className("prod-img"));

        // 3.elemente click yapalim
        urunElementleriListesi.get(2).click();
        Thread.sleep(2000);
        // urun kisa aciklamalarinda case sensitive olmadan shoe gectigini test edin

        WebElement urunDetaylariElementi = driver.findElement(By.className("prod-detail"));

        String expectedIcerik = "shoe";
        String actualDetaylar = urunDetaylariElementi.getText().toLowerCase();

        if (actualDetaylar.contains(expectedIcerik)){
            System.out.println("Urun detay testi PASSED");
        }else System.out.println("Urun detay testi FAILED");

        Thread.sleep(2000);
        driver.close();
    }
}
