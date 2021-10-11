package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstProductPage extends BasePage {

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement colorDropDown;
    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement sizeDropDown;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartButton;
    @FindBy(xpath = "//a[text()='View cart']")
    WebElement viewCartButton;

    public FirstProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void chooseColor(int index) {
        selectOptionFromDropDownByIndex(colorDropDown, index);
    }

    public void chooseSize(int index) {
        selectOptionFromDropDownByIndex(sizeDropDown, index);
    }

    public void addProductToCart() {
        jsClick(addToCartButton);
    }

    public void goToCart() {
        jsClick(viewCartButton);
    }
}
