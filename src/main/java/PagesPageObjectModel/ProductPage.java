package PagesPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By colorDropDown = By.xpath("//select[@id='pa_color']");
    private final By sizeDropDown = By.xpath("//select[@id='pa_size']");
    private final By qtyField = By.xpath("//input[@name='quantity']");
    private final By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private final By viewCartButton = By.xpath("//a[text()='View cart']");

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void changeColor(String color) {
        selectOptionFromDropDown(colorDropDown, color);
    }

    public void changeSize(String size) {
        selectOptionFromDropDown(sizeDropDown, size);
    }

    public void changeQuantity(String quantity) {
        changeTheValue(qtyField, quantity);
    }

    public void addToCart() {
        jsClick(addToCartButton);
    }

    public void goToTheCart() {
        jsClick(viewCartButton);
    }
}
