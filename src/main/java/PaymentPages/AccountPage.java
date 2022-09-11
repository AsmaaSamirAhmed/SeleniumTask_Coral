package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;
    By CheckName=By.xpath("//span[@class='fontBig ng-binding']");
    By DepositButton =By.xpath("//button[@ng-click='deposit()']");
    By WithdrawlButton=By.xpath("//button[@ng-click='withdrawl()']");
    By TransactionsButton=By.xpath("//button[@ng-click='transactions()']");
    By AmountTobeDeducted=By.xpath("//input[@type='number']");
    By ConfirmBtn =By.xpath("//button[@type='submit']");
    By CheckMsg =By.xpath("//span[@class='error ng-binding']");
    By balance= By.xpath("//strong[@class='ng-binding'][2]");

    public AccountPage(WebDriver driver){
        this.driver=driver;
    }
    public String  CheckSuccessAccount(){
        return driver.findElement(CheckName).getText();
    }
    public void ClickOnDepositeBtn(){
        driver.findElement(DepositButton).click();
    }
    public void InserAmountToDeducted(String amount){
        driver.findElement(AmountTobeDeducted).sendKeys(amount);
    }
    public void Confirmation(){
       driver.findElement(ConfirmBtn).click();
    }
    public String CheckActionDone(){
        return driver.findElement(CheckMsg).getText();
    }
    public void ClickOnWithDrawlBtn(){
        driver.findElement(WithdrawlButton).click();
    }
    public String CheckBalance(){
        return driver.findElement(balance).getText();
    }
    public void ClickOnTransactionBtn(){
        driver.findElement(TransactionsButton).click();
    }


}
