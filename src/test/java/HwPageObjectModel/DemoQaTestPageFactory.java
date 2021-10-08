package HwPageObjectModel;

import PagesPageFactory.*;
import org.testng.annotations.Test;

public class DemoQaTestPageFactory extends BaseTest {
    @Test
    public void addCommentWithoutCaptcha() {
        getWebDriver().get("https://shop.demoqa.com/author/lsharm/");
        AuthorPage authorPage = new AuthorPage(getWebDriver());
        authorPage.clickReadMore();
        CommentPage commentPage = new CommentPage(getWebDriver());
        commentPage.fillInYourName("Mariya");
        commentPage.fillInYourEmail("testfort@gmail.com");
        commentPage.fillInWebsite("https://qarea.com/");
        commentPage.fillInYourComment("It's a test comment");
        commentPage.clickPostCommentButton();
        ErrorPage errorPage = new ErrorPage(getWebDriver());
        errorPage.verifyErrorMessage();
    }

    @Test
    public void productPresentInCart() {
        getWebDriver().get("https://shop.demoqa.com/");
        getWebDriver().manage().window().maximize();
        HomePage homePage = new HomePage(getWebDriver());
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

    }
}
