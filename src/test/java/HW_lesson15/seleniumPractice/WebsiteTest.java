package HW_lesson15.seleniumPractice;

import HW_lesson15.seleniumPractice.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebsiteTest extends BaseTest {

    @Test
    public void removeAllRecords() {
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement customerLoginButton = webDriver.findElement(By.xpath("//button[text()=\"Customer Login\"]"));
        customerLoginButton.click();
        WebElement yourNameField = webDriver.findElement(By.name("userSelect"));
        yourNameField.click();
        WebElement user = webDriver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        user.click();
        WebElement loginButton = webDriver.findElement(By.xpath("//button[text()=\"Login\"]"));
        loginButton.click();
        WebElement depositButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][2]"));
        depositButton.click();
        WebElement amountOfDepositField = webDriver.findElement(By.xpath("//input[@type=\"number\"]"));
        amountOfDepositField.sendKeys("1000");
        WebElement depositSubmitButton = webDriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        depositSubmitButton.click();
        WebElement withdrawButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][2]"));
        withdrawButton.click();
        WebElement amountOfWithdrawField = webDriver.findElement(By.xpath("//input[@type=\"number\"]"));
        amountOfWithdrawField.sendKeys("900");
        WebElement withdrawSubmitButton = webDriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        withdrawSubmitButton.click();
        WebElement transactionButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][1]"));
        transactionButton.click();
        WebElement resetButton = webDriver.findElement(By.xpath("//button[text()=\"Reset\"]"));
        resetButton.click();
    }

    @Test
    public void openAccountTab() {
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement managerLoginButton = webDriver.findElement(By.xpath("//button[text()=\"Bank Manager Login\"]"));
        managerLoginButton.click();
        WebElement addCustomerButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][1]"));
        addCustomerButton.click();
        WebElement firstNameField = webDriver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        firstNameField.sendKeys("Sarah");
        WebElement lastNameField = webDriver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastNameField.sendKeys("Connor");
        WebElement postCodeField = webDriver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]"));
        postCodeField.sendKeys("147258");
        WebElement addCustomerButton2 = webDriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        addCustomerButton2.click();
        webDriver.switchTo().alert().accept();
        WebElement openAccountButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][1]"));
        openAccountButton.click();
    }

    @Test
    public void createAccount() {
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement managerLoginButton = webDriver.findElement(By.xpath("//button[text()=\"Bank Manager Login\"]"));
        managerLoginButton.click();
        WebElement openAccountButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][2]"));
        openAccountButton.click();
        WebElement customerNameField = webDriver.findElement(By.name("userSelect"));
        customerNameField.click();
        WebElement customer = webDriver.findElement(By.xpath("//*[@id=\"userSelect\"]/option[3]"));
        customer.click();
        WebElement currencyField = webDriver.findElement(By.name("currency"));
        currencyField.click();
        WebElement currency = webDriver.findElement(By.xpath("//*[@id=\"currency\"]/option[2]"));
        currency.click();
        WebElement processButton = webDriver.findElement(By.xpath("//button[@type=\"submit\"]"));
        processButton.click();
        webDriver.switchTo().alert().accept();

    }

    @Test
    public void removeAllAccounts() {
        webDriver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        WebElement managerLoginButton = webDriver.findElement(By.xpath("//button[text()=\"Bank Manager Login\"]"));
        managerLoginButton.click();
        WebElement customersButton = webDriver.findElement(By.xpath("//*[@class=\"btn btn-lg tab\"][3]"));
        customersButton.click();
        List<WebElement> deleteButtons = webDriver.findElements(By.xpath("//button[text()=\"Delete\"]"));
        int size = deleteButtons.size();
        for (int i = 0; i < size; i++) {
            WebElement deleteButton = deleteButtons.get(i);
            deleteButton.click();
        }
    }
}
