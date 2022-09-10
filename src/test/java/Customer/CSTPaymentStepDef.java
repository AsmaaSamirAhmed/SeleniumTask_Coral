package Customer;

import BasesTest.TestBase;
import PaymentPages.AccountPage;
import PaymentPages.HomePage;
import PaymentPages.SelectNamePage;
import PaymentPages.TransactionsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CSTPaymentStepDef extends TestBase
{
    HomePage homePage;
    SelectNamePage namePage;
    AccountPage accountPage;
    TransactionsPage transactionsPage;
    @Given("Customer Click on CustomerLogin button in HomePage")
    public void customer_click_on_customer_login_button_in_home_page() {
        homePage=new HomePage(driver);
        homePage.clickOnCustomerLoginButton();
    }
    @And("Select {string} then press login")
    public void select_then_press_login(String Name) {
        namePage=new SelectNamePage(driver);
        namePage.SelectName(Name);
        namePage.ClickLogin();
        accountPage=new AccountPage(driver);
        accountPage.CheckSuccessAccount(Name);
    }
    @When("User make a deposit {string}")
    public void user_make_a_deposit(String DepositeAmount) throws InterruptedException {
        accountPage=new AccountPage(driver);
        accountPage.ClickOnDepositeBtn();
        Thread.sleep(10000);
        System.out.println("Deposite Amount->"+DepositeAmount);

        accountPage.InserAmountToDeducted(DepositeAmount);
     /*   FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        wait.withTimeout(50000, TimeUnit.MILLISECONDS);
//Sepcify polling time
        wait.pollingEvery(250, TimeUnit.MILLISECONDS);
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);*/

//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        //  wait.until(ExpectedConditions.presenceOfElementLocated());
        Thread.sleep(10000);
        accountPage.Confirmation();
        Thread.sleep(10000);

    }
    @And("User make	Withdraw {string}")
    public void user_make_withdraw(String WithdrawlAmount) throws InterruptedException {
        accountPage=new AccountPage(driver);
        accountPage.ClickOnWithDrawlBtn();
        Thread.sleep(10000);
        System.out.println("withdrawl Amount->"+WithdrawlAmount);
        Thread.sleep(10000);
        accountPage.InserAmountToDeducted(WithdrawlAmount);
        Thread.sleep(10000);
        accountPage.Confirmation();
        Thread.sleep(10000);
    }
    @Then("Check the transaction type of the withdraw")
    public void check_the_transaction_type_of_the_withdraw() {
        accountPage=new AccountPage(driver);
        accountPage.ClickOnTransactionBtn();
        transactionsPage.GetWithdrawTransactionType();
    }
}