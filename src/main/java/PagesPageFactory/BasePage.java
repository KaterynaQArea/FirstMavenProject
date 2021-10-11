package PagesPageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void fillingTheField(WebElement webElement, String input) {
        webElement.sendKeys(input);
    }

    public void selectOptionFromDropDownByIndex(WebElement webElement, int index) {
        Select select = new Select(webElement);
        select.selectByIndex(index);
    }

    public void selectOptionFromDropDownByVisibleText(WebElement webElement, String s) {
        Select select = new Select(webElement);
        select.selectByVisibleText(s);
    }

    public void jsClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public void isElementVisible(WebElement webElement, int timeWait) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeWait);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
    }
}
