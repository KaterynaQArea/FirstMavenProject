package PagesPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By addToFavoriteTokyoTalkies = By.xpath("//a[@data-product-id='704']");
    private final By popUpAddedToWishlist = By.xpath("//div[@id='yith-wcwl-popup-message']");
    private final By myWishlistButton = By.xpath("//a[text()='My Wishlist']");
    private final By productPinkDropShoulderOverSizedTShirt = By.xpath("//a[text()='pink drop shoulder oversized t shirt']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToWishlist() {
        jsClick(addToFavoriteTokyoTalkies);
    }

    public void presenceOfAddedToWishlistPopUp() {
        isElementVisible(popUpAddedToWishlist, 10);
    }

    public void openWishlist() {
        jsClick(myWishlistButton);
    }

    public void chooseTheProduct() {
        jsClick(productPinkDropShoulderOverSizedTShirt);
    }
}
