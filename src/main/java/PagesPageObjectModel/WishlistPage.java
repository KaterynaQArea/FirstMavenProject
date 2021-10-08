package PagesPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BasePage {

    private final By productTokyoTalkies = By.xpath("//a[contains(text(),'Tokyo Talkies')]");

    public WishlistPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void presenceInWishlist() {
        isElementVisible(productTokyoTalkies, 10);
    }
}