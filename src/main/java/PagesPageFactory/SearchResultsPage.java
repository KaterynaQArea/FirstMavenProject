package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='pull-right noo_woocommerce-catalog']//select[@name='filter_size']")
    WebElement filterSizeDropDown;

    @FindBy(xpath = "//a[text()='blue sinner ripped knee high waist skinny jeans']")
    WebElement firstProduct;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void selectSize(String value) {
        selectOptionFromDropDownByVisibleText(filterSizeDropDown, value);
    }

    public void selectFirstProduct() {
        jsClick(firstProduct);
    }
}
