package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentPage {

    @FindBy(xpath = "//input[@id='author']")
    WebElement yourNameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement yourEmailField;

    @FindBy(xpath = "//input[@id='url']")
    WebElement websiteField;

    @FindBy(xpath = "//textarea[@id='comment']")
    WebElement yourCommentField;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement postCommentButton;

    public CommentPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void fillInYourName(String s) {
        yourNameField.sendKeys(s);
    }

    public void fillInYourEmail(String s) {
        yourEmailField.sendKeys(s);
    }

    public void fillInWebsite(String s) {
        websiteField.sendKeys(s);
    }

    public void fillInYourComment(String s) {
        yourCommentField.sendKeys(s);
    }

    public void clickPostCommentButton() {
        postCommentButton.click();
    }
}

