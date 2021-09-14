import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToEmail {

    @Test
    public void loginToEmailChromeTest() {

        String pathToProject = System.getProperty("user.dir");
        String pathToDriver = pathToProject + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.i.ua/");

        WebElement searchInputLogin = webDriver.findElement(By.xpath("//*[@name='login']"));
        searchInputLogin.sendKeys("webdriver@i.ua");

        WebElement searchInputPassword = webDriver.findElement(By.xpath("//*[@name='pass']"));
        searchInputPassword.sendKeys("987321");

        WebElement SearchNextButton = webDriver.findElement(By.xpath("//*[@value='Войти']"));
        SearchNextButton.click();

        WebElement createEmail = webDriver.findElement(By.linkText("Создать письмо"));
        Assert.assertEquals(createEmail.getText(), "Создать письмо");

        webDriver.quit();
    }

    @Test
    public void loginToEmailChromeManagerTest() {

        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.i.ua/");

        WebElement searchInputLogin = webDriver.findElement(By.xpath("//*[@name='login']"));
        searchInputLogin.sendKeys("webdriver@i.ua");

        WebElement searchInputPassword = webDriver.findElement(By.xpath("//*[@name='pass']"));
        searchInputPassword.sendKeys("987321");

        WebElement searchNextButton = webDriver.findElement(By.xpath("//*[@value='Войти']"));
        searchNextButton.click();

        WebElement createEmail = webDriver.findElement(By.linkText("Создать письмо"));
        Assert.assertEquals(createEmail.getText(), "Создать письмо");

        webDriver.quit();
    }
}

