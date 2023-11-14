package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {

    public static void main(String[] args) throws InterruptedException {

        // testotomasyonu anasayfaya gidin
        // URL'in https://www.testotomasyonu.com/ oldugunu
        // ve Title'in test kelimesi icerdigini test edin

        // Her test icin Mutlaka bir webdriver olusturmali
        // ve gerekli ayarlamalari yapmaliyiz
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");


        // URL'in https://www.testotomasyonu.com oldugunu

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("URL testi PASSED");
        }else {
            System.out.println("URL testi FAILED");
            System.out.println("Actual URL : " + actualUrl);
        }

        // ve Title'in test kelimesi icerdigini test edin

        String expectedTitleIcerigi = "test";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerigi)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title testi FAILED");
            System.out.println("Actual title : " + actualTitle);
        }


        driver.quit();
    }
}
