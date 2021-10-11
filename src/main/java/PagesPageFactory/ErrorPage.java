package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ErrorPage extends BasePage{

    @FindBy(id = "error-page")
    WebElement errorMessage;

    public ErrorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void verifyErrorMessage() {
        Assert.assertEquals(errorMessage.getText(), "Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");
    }
}
