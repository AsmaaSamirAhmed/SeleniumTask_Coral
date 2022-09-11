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
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CSTPaymentStepDef extends TestBase
{
    HomePage homePage;
    SelectNamePage namePage;
    AccountPage accountPage;
    TransactionsPage transactionsPage;
    WebDriverWait wait=new WebDriverWait(driver,1000);

    @Given("Customer Click on CustomerLogin button in HomePage")
    public void customer_click_on_customer_login_button_in_home_page() {
        homePage=new HomePage(driver);
        homePage.clickOnCustomerLoginButton();
    }
    @And("Select {string} then press login")
    public void select_then_press_login(String Name) {
        namePage=new SelectNamePage(driver);
        accountPage=new AccountPage(driver);
        namePage.SelectName(Name);
        namePage.ClickLogin();
        Assert.assertEquals(accountPage.CheckSuccessAccount(),Name);;
    }
    @When("User make a deposit {string}")
    public void user_make_a_deposit(String DepositeAmount) {
        accountPage=new AccountPage(driver);
        accountPage.ClickOnDepositeBtn();
        accountPage.InserAmountToDeducted(DepositeAmount);
        accountPage.Confirmation();
        Assert.assertEquals(accountPage.CheckActionDone(),"Deposit Successful");

    }
    @And("User make	Withdraw {string}")
    public void user_make_withdraw(String WithdrawlAmount) {
        accountPage=new AccountPage(driver);
        accountPage.ClickOnWithDrawlBtn();

        wait.until(ExpectedConditions.textToBe(By.xpath("//label"),"Amount to be Withdrawn :"));
        accountPage.InserAmountToDeducted(WithdrawlAmount);
        accountPage.Confirmation();
        Assert.assertEquals(accountPage.CheckActionDone(),"Transaction successful");

    }
    @Then("balance should be changed to {string}")
    public void balance_should_be_changed_to(String balance) {
        accountPage=new AccountPage(driver);
        Assert.assertEquals(accountPage.CheckBalance(),balance);
    }
    @And("The {string} for withdraw is Debit")
    public void the_for_withdraw_is_debit(String transactionType) {
        accountPage=new AccountPage(driver);
        transactionsPage=new TransactionsPage(driver);
        wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='error ng-binding']"),"Transaction successful"));
        accountPage.ClickOnTransactionBtn();
        Assert.assertEquals(transactionsPage.GetWithdrawTransactionType(),transactionType);
    }
}