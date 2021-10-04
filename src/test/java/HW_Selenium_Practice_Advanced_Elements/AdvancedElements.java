package HW_Selenium_Practice_Advanced_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedElements extends HW_lesson15.seleniumPractice.base.BaseTest {

    @Test
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
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
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
    }

    @Test
    public void iFrame() {
        webDriver.get("https://demoqa.com/frames");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("frame1")));
        webDriver.switchTo().frame(webDriver.findElement(By.id("frame1")));
        WebElement firstFrame = webDriver.findElement(By.id("sampleHeading"));
        System.out.println("Text from the first frame: " + firstFrame.getText());
        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(webDriver.findElement(By.id("frame2")));
        WebElement secondFrame = webDriver.findElement(By.id("sampleHeading"));
        System.out.println("Text from the second frame: " + secondFrame.getText());
    }

    @Test
    public void fillTheForm() {
        webDriver.get("https://demoqa.com/automation-practice-form");
        webDriver.manage().window().maximize();
        WebElement firstName = webDriver.findElement(By.xpath("//*[@id='firstName']"));
        firstName.sendKeys("TestFirstName");
        WebElement lastName = webDriver.findElement(By.xpath("//*[@id='lastName']"));
        lastName.sendKeys("TestLastName");
        WebElement email = webDriver.findElement(By.xpath("//*[@id='userEmail']"));
        email.sendKeys("test@gmail.com");
        WebElement gender = webDriver.findElement(By.xpath("//label[text()='Female']"));
        gender.click();
        WebElement mobile = webDriver.findElement(By.xpath("//*[@id='userNumber']"));
        mobile.sendKeys("0669999999");
        WebElement dateOfBirth = webDriver.findElement(By.xpath("//*[@id='dateOfBirthInput']"));
        dateOfBirth.click();
        Select selectMonth = new Select(webDriver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        selectMonth.selectByIndex(3);
        Select selectYear = new Select(webDriver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        selectYear.selectByValue("1987");
        WebElement date = webDriver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--023']"));
        date.click();
        WebElement sports = webDriver.findElement(By.xpath("//label[text()='Sports']"));
        sports.click();
        WebElement reading = webDriver.findElement(By.xpath("//label[text()='Reading']"));
        reading.click();
        WebElement address = webDriver.findElement(By.xpath("//*[@id='currentAddress']"));
        address.sendKeys("Test address");
        WebElement stateInput = webDriver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        stateInput.sendKeys("NCR", Keys.ENTER);
        WebElement inputCity = webDriver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        inputCity.sendKeys("Noida", Keys.ENTER);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement submit = webDriver.findElement(By.xpath("//button[@id='submit']"));
        js.executeScript("arguments[0].click();", submit);

    }

    @Test
    public void textForm() {
        webDriver.get("https://demoqa.com/text-box");
        WebElement fullName = webDriver.findElement(By.xpath("//*[@id='userName']"));
        fullName.sendKeys("Test Full Name");
        WebElement email = webDriver.findElement(By.xpath("//*[@id='userEmail']"));
        email.sendKeys("testEmail@gmail.com");
        WebElement currentAddress = webDriver.findElement(By.xpath("//*[@id='currentAddress']"));
        currentAddress.sendKeys("Test current address");
        WebElement permanentAddress = webDriver.findElement(By.xpath("//*[@id='permanentAddress']"));
        permanentAddress.sendKeys("Test permanent address");
        WebElement submit = webDriver.findElement(By.xpath("//*[@id='submit']"));
        submit.click();
    }
}
