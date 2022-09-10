package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages_Bases.PageBase;

public class AccountPage extends PageBase {
    WebDriver driver;
    By CheckName=By.xpath("//span[@class='fontBig ng-binding']");
    By DepositButton =By.xpath("//button[@ng-click='deposit()']");
    By WithdrawlButton=By.xpath("//button[@ng-click='withdrawl()']");
    By TransactionsButton=By.xpath("//button[@ng-click='transactions()']");
    By AmountTobeDeducted=By.xpath("//input[@type='number']");
    By ConfirmBtn =By.xpath("//button[@type='submit']");

    public AccountPage(WebDriver driver){
     //   this.driver=driver;
        super(driver);
    }
    public void CheckSuccessAccount(String name){
       // String LoggedInName=driver.findElement(CheckName).getText();
        String LoggedInName=getText(CheckName);
        Assert.assertEquals(LoggedInName,name);
    }
    public void ClickOnDepositeBtn(){
        //driver.findElement(DepositButton).click();
        clickButton(DepositButton);
    }
    public void InserAmountToDeducted(String amount){
     //   driver.findElement(AmountTobeDeducted).sendKeys(amount);
        sendText(AmountTobeDeducted,amount);
    }
    public void Confirmation(){
      //  driver.findElement(ConfirmBtn).click();
        clickButton(ConfirmBtn);
    }
    public void ClickOnWithDrawlBtn(){
        //driver.findElement(WithdrawlButton).click();
        clickButton(WithdrawlButton);
    }
    public void ClickOnTransactionBtn(){
//        driver.findElement(TransactionsButton).click();
        clickButton(TransactionsButton);
    }

}
