package HwGitSelenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    public void selenideTest() {

        open("https://demo.nopcommerce.com/build-your-own-computer");
        $(By.xpath("//*[@id='product_attribute_1']")).selectOption(2);
        $(By.xpath("//*[@id='product_attribute_2']")).selectOption(3);
        $(By.xpath("//*[@id='product_attribute_4_8']")).click();
        $(By.xpath("//*[@id='product_attribute_3_6']")).click();
        $(By.xpath("//*[@id='add-to-cart-button-1']")).click();
        $(By.xpath("//span[text()=\"Shopping cart\"]")).click();
        $(By.xpath("(//div[@class='attributes'])[2]")).shouldHave(text("RAM: 8GB [+$60.00] HDD: 320 GB"));
    }
}
