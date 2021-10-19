package HwPageObjectModel;

import PagesPageObjectModel.CartPage;
import PagesPageObjectModel.HomePage;
import PagesPageObjectModel.ProductPage;
import PagesPageObjectModel.WishlistPage;
import org.testng.annotations.Test;

public class DemoQaTestPageObjectModel extends BaseTest {

    @Test
    public void productPresenceInWishlist() {
        HomePage homePage = new HomePage((getWebDriver()));
        homePage.openURL("https://shop.demoqa.com/");
        homePage.addToWishlist();
        homePage.presenceOfAddedToWishlistPopUp();
        homePage.openWishlist();
        WishlistPage wishlistPage = new WishlistPage(getWebDriver());
        wishlistPage.presenceInWishlist();
        log("The product 'Tokyo-Talkies' added to the wishlist");
    }

    @Test
    public void productPresenceInCart() {
        HomePage homePage = new HomePage((getWebDriver()));
        homePage.openURL("https://shop.demoqa.com/");
        homePage.chooseTheProduct();
        ProductPage productPage = new ProductPage(getWebDriver());
        productPage.changeColor("pink");
        productPage.changeSize("37");
        productPage.changeQuantity("3");
        productPage.addToCart();
        productPage.goToTheCart();
        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.presenceOfProductAddedToCart();
        log("The product 'PINK DROP SHOULDER OVERSIZED T SHIRT' added to the cart");
    }
}
