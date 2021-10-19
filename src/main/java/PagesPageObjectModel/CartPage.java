package PagesPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productInTheCart = By.xpath("//a[text()='pink drop shoulder oversized t shirt - Pink'] ");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void presenceOfProductAddedToCart() {
        isElementVisible(productInTheCart, 10);
    }
}
