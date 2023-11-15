package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText_ByPartialLinkText {

    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlamalari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // shoes linkine tiklayin

        // driver.findElement(By.linkText("Shoes")).click();
        // driver.findElement(By.linkText("hoes")).click();
        // eger By.linkText() kullanirsaniz, link uzerindeki text'i birebir ayni olarak yazmamiz gerekir
        // bosluk, ? gibi karakterler varsa onlar da mutlaka yazilmalidir

        // driver.findElement(By.partialLinkText("hoes")).click();
        // driver.findElement(By.partialLinkText("oes")).click();
        // driver.findElement(By.partialLinkText("ho")).click();
        WebElement shoesLinki = driver.findElement(By.partialLinkText("oe"));
        shoesLinki.click();

        // By.partialLinkText() kullanildiginda
        // link uzerindeki yazinin tamamina ihtiyac yoktur
        // Yazinin, istegimiz webelementi unique olarak bulabilecegimiz
        // herhangi bir parcasini kullanmamiz yeterli olur

        // acilan sayfada Title'in Shoes icerdigini test edin

        String expectedTitleIcerik = "Shoes";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Shoes testi PASSED");
        }else System.out.println("Shoes testi FAILED");

        // Shoes linkinin bu sayfada da erisilebilir oldugunu test edin

        /*
            Bir webelementi locate ettikten sonra
            sayfayi yenileme veya yeni bir sayfaya gitme gibi islemler yaparsak
            driver daha onceden yaptigimiz locate'leri KULLANAMAYABILIR
            ve bize "StaleElementReferenceException" verir

            bu durumda locate ve elemente kayit islemini YENIDEN YAPMALIYIZ
         */
        shoesLinki = driver.findElement(By.partialLinkText("oe"));
        if (shoesLinki.isEnabled()){
            System.out.println("Shoes linki erisim testi PASSED");
        }else System.out.println("Shoes linki erisim testi FAILED");

        Thread.sleep(3000);
        driver.close();
    }
}
