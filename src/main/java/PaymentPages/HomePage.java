package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
    WebDriver driver;
    By CST_LoginButton=By.xpath("//button[@ng-click='customer()']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }
public void clickOnCustomerLoginButton()
{
    driver.findElement(CST_LoginButton).click();
}
}
