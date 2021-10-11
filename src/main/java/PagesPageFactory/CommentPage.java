package PagesPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentPage extends BasePage {

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
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void fillInYourName(String s) {
        fillingTheField(yourNameField, s);
    }

    public void fillInYourEmail(String s) {
        fillingTheField(yourEmailField, s);
    }

    public void fillInWebsite(String s) {
        fillingTheField(websiteField, s);
    }

    public void fillInYourComment(String s) {
        fillingTheField(yourCommentField, s);
    }

    public void clickPostCommentButton() {
        jsClick(postCommentButton);
    }
}

