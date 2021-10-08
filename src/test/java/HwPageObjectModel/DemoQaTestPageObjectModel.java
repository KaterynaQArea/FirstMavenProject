package HwPageObjectModel;

import PagesPageObjectModel.CartPage;
import PagesPageObjectModel.HomePage;
import PagesPageObjectModel.ProductPage;
import PagesPageObjectModel.WishlistPage;
import org.testng.annotations.Test;

public class DemoQaTestPageObjectModel extends BaseTest {

    @Test
    public void productPresenceInWishlist() {

        getWebDriver().get("https://shop.demoqa.com/");
        HomePage homePage = new HomePage((getWebDriver()));
        homePage.addToWishlist();
        homePage.presenceOfAddedToWishlistPopUp();
        homePage.openWishlist();
        WishlistPage wishlistPage = new WishlistPage(getWebDriver());
        wishlistPage.presenceInWishlist();
    }

    @Test
    public void productPresenceInCart() {
        getWebDriver().get("https://shop.demoqa.com/");
        HomePage homePage = new HomePage((getWebDriver()));
        homePage.chooseTheProduct();
        ProductPage productPage = new ProductPage(getWebDriver());
        productPage.changeColor("pink");
        productPage.changeSize("37");
        productPage.changeQty("3");
        productPage.addToCart();
        productPage.goToTheCart();
        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.presenceOfProductAddedToCart();
    }
}
