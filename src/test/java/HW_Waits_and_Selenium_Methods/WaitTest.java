package HW_Waits_and_Selenium_Methods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class WaitTest extends BaseTest {
    @Test
    public void DeleteAllBooks() {
        webDriver.get("https://demoqa.com/login");
        webDriver.manage().window().maximize();
        WebElement usernameField = webDriver.findElement(By.xpath("//*[@id='userName']"));
        usernameField.sendKeys("Kateryna");
        WebElement passwordField = webDriver.findElement(By.xpath("//*[@id='password']"));
        passwordField.sendKeys("Qarea2021!");
        WebElement loginButton = webDriver.findElement(By.xpath("//*[@id='login']"));
        loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Go To Book Store']")));
        WebElement goToBookStoreButton = webDriver.findElement(By.xpath("//button[text()='Go To Book Store']"));
        js.executeScript("arguments[0].click();", goToBookStoreButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Git Pocket Guide']")));
        WebElement gitPocketGuide = webDriver.findElement(By.xpath("//a[text()='Git Pocket Guide']"));
        gitPocketGuide.click();
        WebElement addToYourCollectionButton = webDriver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        addToYourCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        webDriver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Back To Book Store']")));
        WebElement backToStoreButton = webDriver.findElement(By.xpath("//button[text()='Back To Book Store']"));
        backToStoreButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"You Don't Know JS\"]")));
        WebElement youDoNotKnowJS = webDriver.findElement(By.xpath("//a[text()=\"You Don't Know JS\"]"));
        youDoNotKnowJS.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add To Your Collection']")));
        WebElement addToYourCollectionButton2 = webDriver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        addToYourCollectionButton2.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        webDriver.switchTo().defaultContent();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='Profile']")));
        WebElement profileButton = webDriver.findElement(By.xpath("//span[text()='Profile']"));
        profileButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Delete All Books']")));
        WebElement deleteAllBooks = webDriver.findElement(By.xpath("//button[text()='Delete All Books']"));
        js.executeScript("arguments[0].click();", deleteAllBooks);
        WebElement okButton = webDriver.findElement(By.xpath("//button[text()='OK']"));
        okButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        ////*[@class='text-right button di']
    }

    @Test
    public void addProducts() {
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().window().maximize();
        WebElement usernameField = webDriver.findElement(By.xpath("//*[@id='user-name']"));
        usernameField.sendKeys("standard_user");
        WebElement passwordField = webDriver.findElement(By.xpath("//*[@id='password']"));
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = webDriver.findElement(By.xpath("//*[@id='login-button']"));
        loginButton.click();

        List<WebElement> goods = webDriver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (int i = 0; i < 4; i++) {
            WebElement good = goods.get(i);
            good.click();
        }
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='shopping_cart_container']")));
        WebElement cartIcon = webDriver.findElement(By.xpath("//*[@id='shopping_cart_container']"));
        cartIcon.click();
        WebElement checkoutButton = webDriver.findElement(By.xpath("//*[@id='checkout']"));
        checkoutButton.click();
        WebElement firstNameField = webDriver.findElement(By.xpath("//*[@id='first-name']"));
        firstNameField.sendKeys("TestFirstName");
        WebElement lastNameField = webDriver.findElement(By.xpath("//*[@id='last-name']"));
        lastNameField.sendKeys("TestLastName");
        WebElement zipCodeField = webDriver.findElement(By.xpath("//*[@id='postal-code']"));
        zipCodeField.sendKeys("61210");
        WebElement continueButton = webDriver.findElement(By.xpath("//*[@id='continue']"));
        continueButton.click();
        WebElement finishButton = webDriver.findElement(By.xpath("//*[@id='finish']"));
        finishButton.click();
        WebElement backHomeButton = webDriver.findElement(By.xpath("//*[@id='back-to-products']"));
        backHomeButton.click();
    }

    @Test
    public void testToDos() {
        webDriver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        webDriver.manage().window().maximize();
        WebElement addNewToDo = webDriver.findElement(By.xpath("//*[@placeholder='Add new todo']"));
        addNewToDo.sendKeys("MAKE HOMEWORK", Keys.ENTER);
        addNewToDo.sendKeys("Practice Automation", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(text(), 'Practice magic')]")));
        WebElement practiceMagic = webDriver.findElement(By.xpath("//li[contains(text(), 'Practice magic')]"));
        practiceMagic.click();
        WebElement buyNewRobes = webDriver.findElement(By.xpath("//li[contains(text(), ' Buy new robes')]"));
        Actions action = new Actions(webDriver);
        action.moveToElement(buyNewRobes).perform();
        WebElement deleteIcon = webDriver.findElement(By.xpath("//li[2]//i[@class='fa fa-trash']"));
        deleteIcon.click();
    }

    @Test
    public void testAmazon() {
        webDriver.get("https://www.amazon.com/");
        webDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        By popUp = By.xpath("//div[@id='glow-toaster-body']");
        if (isElementVisible(popUp)) {
            WebElement doNotChangeAddressButton = webDriver.findElement(By.xpath("//input[@data-action-type='DISMISS']"));
            doNotChangeAddressButton.click();
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(), \"Today's Deals\")]")));
        WebElement todayDealsTab = webDriver.findElement(By.xpath("//a[contains(text(), \"Today's Deals\")]"));
        todayDealsTab.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(), \"Kasa Smart 2K Security Camera for Baby Monitor Pan Tilt, 4MP HD In...\")]")));
        WebElement product = webDriver.findElement(By.xpath("//span[contains(text(), \"Kasa Smart 2K Security Camera for Baby Monitor Pan Tilt, 4MP HD In...\")]"));
        product.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='submit.add-to-cart']")));
        WebElement addToCartButton = webDriver.findElement(By.xpath("//*[@id='submit.add-to-cart']"));
        addToCartButton.click();
        WebElement cart = webDriver.findElement(By.xpath("//*[@id='nav-cart-count']"));
        cart.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@value='Proceed to checkout']")));
        WebElement proceedToCheckoutButton = webDriver.findElement(By.xpath("//input[@value='Proceed to checkout']"));
        proceedToCheckoutButton.click();
    }

    public boolean isElementVisible(By popUp) {
        List<WebElement> popUps = webDriver.findElements(By.xpath("//input[@data-action-type='DISMISS']"));
        return popUps.size() > 0;
    }
}



