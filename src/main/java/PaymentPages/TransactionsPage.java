package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages_Bases.PageBase;

public class TransactionsPage extends PageBase {
    public TransactionsPage(WebDriver driver){
        super(driver);
    }
    By TransactionType= By.xpath("//tr[@id='anchor1']//td[3]/text()");
    public String GetWithdrawTransactionType(){
       return getText(TransactionType);
    }
}
