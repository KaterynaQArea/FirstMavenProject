package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//a[text()='clear shopping cart']")
    WebElement clearShoppingCartButton;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void presenceOfProductAddedToCart(int timeWait) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeWait);
        webDriverWait.until(ExpectedConditions.visibilityOf(clearShoppingCartButton));
    }
}
