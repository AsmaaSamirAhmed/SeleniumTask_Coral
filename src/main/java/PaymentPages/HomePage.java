package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages_Bases.PageBase;

public class HomePage// extends PageBase
{
    WebDriver driver;
    public HomePage(WebDriver driver){
       // super(driver);
        this.driver=driver;
    }
By CST_LoginButton=By.xpath("//button[@ng-click='customer()']");

public void clickOnCustomerLoginButton()
{
   //clickButton(CST_LoginButton);
    driver.findElement(CST_LoginButton).click();
}
}
