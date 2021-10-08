package PagesPageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver webDriver;

    @FindBy(xpath = "//a[@class='noo-search']")
    WebElement searchIcon;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void clickSearch() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", searchIcon);
    }

    public void inputSearchQuery(String value) {
        searchField.sendKeys(value);
        searchField.sendKeys(Keys.ENTER);
    }

}

