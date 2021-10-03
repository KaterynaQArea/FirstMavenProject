package HW_Selenium_Practice_Advanced_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedElements extends BaseTest {

    /*@Test
    public void pageSourceCheck() {
        webDriver.get("https://shop.demoqa.com/");
        String title = webDriver.getTitle();
        int length = title.length();
        System.out.println("The length of '" + title + "' is " + length);
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, "https://shop.demoqa.com/");
        int lengthPageSource = webDriver.getPageSource().length();
        System.out.println("Page length = " + lengthPageSource);
    }
    @Test
    public void navigationTest() {
        webDriver.get("https://demoqa.com/profile");
        WebElement registrationLink = webDriver.findElement(By.xpath("//a[text()='register']"));
        registrationLink.click();
        webDriver.navigate().back();
        webDriver.navigate().forward();
        webDriver.navigate().to("https://demoqa.com/profile");
        webDriver.navigate().refresh();
    }
    @Test
    public void StartReset() {
        webDriver.get("https://demoqa.com/progress-bar");
        WebElement startButton = webDriver.findElement(By.xpath("//button[@id='startStopButton']"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='resetButton']")));
        WebElement resetButton = webDriver.findElement(By.xpath("//button[@id='resetButton']"));
        resetButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='startStopButton']")));
        WebElement startButton1 = webDriver.findElement(By.xpath("//button[@id='startStopButton']"));
    }
    @Test
    public void visibleAfter5Seconds() {
        webDriver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
    }*/
    @Test
    public void frame() {
        webDriver.get("https://demoqa.com/frames");
        webDriver.switchTo().frame(0).getPageSource();
    }
}
