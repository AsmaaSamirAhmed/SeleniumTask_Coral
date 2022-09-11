package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionsPage {
    WebDriver driver;
    By TransactionType= By.xpath("//tr[@id='anchor1']//td[3]");
    public TransactionsPage(WebDriver driver){
       this.driver=driver;
    }
    public String GetWithdrawTransactionType(){
        return driver.findElement(TransactionType).getText();
    }
}
