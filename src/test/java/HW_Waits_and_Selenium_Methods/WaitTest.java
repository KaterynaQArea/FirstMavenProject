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
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Go To Book Store']")));
        WebElement goToBookStoreButton = webDriver.findElement(By.xpath("//button[text()='Go To Book Store']"));
        goToBookStoreButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/books?book=9781449325862']")));
        WebElement gitPocketGuide = webDriver.findElement(By.xpath("//*[@href='/books?book=9781449325862']"));
        gitPocketGuide.click();
        WebElement addToYourCollectionButton = webDriver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        addToYourCollectionButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Back To Book Store']")));
        WebElement backToStoreButton = webDriver.findElement(By.xpath("//button[text()='Back To Book Store']"));
        backToStoreButton.click();
        WebElement youDoNotKnowJS = webDriver.findElement(By.xpath("//*[@href='/books?book=9781491904244']"));
        youDoNotKnowJS.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add To Your Collection']")));
        WebElement addToYourCollectionButton2 = webDriver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        addToYourCollectionButton2.click();
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement profileButton = webDriver.findElement(By.xpath("//span[text()='Profile']"));
        profileButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='text-right button di']")));
        WebElement deleteAllBooks = webDriver.findElement(By.xpath("//*[@class='text-right button di']"));
        deleteAllBooks.click();
        WebElement okButton = webDriver.findElement(By.xpath("//button[text()='OK']"));
        okButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        webDriver.switchTo().alert().accept();
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
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Kasa Indoor Pan/Tilt Smart Home Camera, 1080p HD Security Camera wireless 2.4GHz with Night Vision, Motion Detection for Baby Monitor, Cloud & SD Card Storage, Works with Alexa & Google Home (EC70)')]")));
        WebElement product = webDriver.findElement(By.xpath("//div[contains(text(),'Kasa Indoor Pan/Tilt Smart Home Camera, 1080p HD Security Camera wireless 2.4GHz with Night Vision, Motion Detection for Baby Monitor, Cloud & SD Card Storage, Works with Alexa & Google Home (EC70)')]"));
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
        if (popUps.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}



