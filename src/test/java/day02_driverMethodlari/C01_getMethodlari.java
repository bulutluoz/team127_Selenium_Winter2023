package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_getMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");


        driver.get("https://www.wisequarter.com");


        // driver.get("www.youtube.com");
        // driver.get() https:// yazilmadan calismaz

        driver.get("https://youtube.com");

        driver.close();
    }
}
