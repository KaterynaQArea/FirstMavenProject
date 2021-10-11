package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "//a[text()='clear shopping cart']")
    WebElement clearShoppingCartButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void presenceOfProductAddedToCart(int timeWait) {
        isElementVisible(clearShoppingCartButton, timeWait);
    }

}
