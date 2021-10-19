package PagesPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void jsClick(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", webDriver.findElement(locator));
    }

    public void isElementVisible(By locator, int timeWait) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, timeWait);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void selectOptionFromDropDown(By locator, String value) {
        Select select = new Select(webDriver.findElement(locator));
        select.selectByValue(value);
    }

    public void changeTheValue(By locator, String value) {
        WebElement field = webDriver.findElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    public void openURL(String URL) {
        webDriver.get(URL);
    }
}
