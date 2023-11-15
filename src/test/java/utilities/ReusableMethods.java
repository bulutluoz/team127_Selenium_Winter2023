package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi){

        List<String> stringlerListesi = new ArrayList<>();

        for (WebElement each : elementlerListesi
             ) {

            stringlerListesi.add(each.getText());
        }

        return stringlerListesi;
    }
}
