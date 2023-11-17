package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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



        if (expectedUrunIsmi.equals(actualUrunIsmi)){

            System.out.println("DSLR Camera testi PASSED");
        }else {
            System.out.println("DSLR Camera testi FAILED");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
