package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Read more')]")
    WebElement readMoreButton;

    public AuthorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickReadMore() {
        jsClick(readMoreButton);
    }
}
