package PagesPageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@class='noo-search']")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearch() {
        jsClick(searchIcon);
    }

    public void inputSearchQuery(String value) {
        fillingTheField(searchField, value);
        searchField.sendKeys(Keys.ENTER);
    }
}

