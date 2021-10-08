package PagesPageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SearchResultsPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "//div[@class='pull-right noo_woocommerce-catalog']//select[@name='filter_size']")
    WebElement filterSizeDropDown;

    @FindBy(xpath = "//a[text()='blue sinner ripped knee high waist skinny jeans']")
    WebElement firstProduct;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void selectSize(String value) {
        Select select = new Select(filterSizeDropDown);
        select.selectByVisibleText(value);
    }

    public void selectFirstProduct() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", firstProduct);
    }
}
