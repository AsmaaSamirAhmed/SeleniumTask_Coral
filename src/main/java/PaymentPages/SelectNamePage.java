package PaymentPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectNamePage
{
    WebDriver driver;
    By NameDropDown= By.id("userSelect");
    By LoginButton=By.xpath("//button[@class='btn btn-default']");
    public SelectNamePage(WebDriver driver)
    {//super(driver);
        this.driver=driver;
    }
    public void SelectName(String name)
    {
        driver.findElement(NameDropDown).click();
        Select NamesList= new Select(driver.findElement(NameDropDown));
        NamesList.selectByVisibleText(name);
    }
    public void ClickLogin(){
        driver.findElement(LoginButton).click();
    }

}
