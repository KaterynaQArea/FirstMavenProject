package HwPageObjectModel;

import PagesPageFactory.*;
import org.testng.annotations.Test;

public class DemoQaTestPageFactory extends BaseTest {
    @Test
    public void addCommentWithoutCaptcha() {
        AuthorPage authorPage = new AuthorPage(getWebDriver());
        authorPage.openURL("https://shop.demoqa.com/author/lsharm/");
        authorPage.clickReadMore();
        CommentPage commentPage = new CommentPage(getWebDriver());
        commentPage.fillInYourName("Mariya");
        commentPage.fillInYourEmail("testfort@gmail.com");
        commentPage.fillInWebsite("https://qarea.com/");
        commentPage.fillInYourComment("It's a test comment");
        commentPage.clickPostCommentButton();
        ErrorPage errorPage = new ErrorPage(getWebDriver());
        errorPage.verifyErrorMessage();
        log("Error message 'Error: You entered an incorrect CAPTCHA answer. Please go back and try again' when the comment is added without captcha");
    }

    @Test
    public void productPresentInCart() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.openURL("https://shop.demoqa.com/");
        homePage.clickSearch();
        homePage.inputSearchQuery("blue");
        SearchResultsPage searchResultsPage = new SearchResultsPage(getWebDriver());
        searchResultsPage.selectSize("37");
        searchResultsPage.selectFirstProduct();
        FirstProductPage firstProductPage = new FirstProductPage(getWebDriver());
        firstProductPage.chooseColor(1);
        firstProductPage.chooseSize(2);
        firstProductPage.addProductToCart();
        firstProductPage.goToCart();
        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.presenceOfProductAddedToCart(10);
        log("The product was added to the cart from the search results");
    }
}
