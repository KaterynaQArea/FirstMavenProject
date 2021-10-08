package PagesPageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FirstProductPage {

    private final WebDriver webDriver;
    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement colorDropDown;
    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement sizeDropDown;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    WebElement addToCartButton;
    @FindBy(xpath = "//a[text()='View cart']")
    WebElement viewCartButton;

    public FirstProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void chooseColor(int index) {
        Select select = new Select(colorDropDown);
        select.selectByIndex(index);
    }

    public void chooseSize(int index) {
        Select select = new Select(sizeDropDown);
        select.selectByIndex(index);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }
    public void goToCart () {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", viewCartButton);

    }
}
