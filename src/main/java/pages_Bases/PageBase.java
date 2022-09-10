package pages_Bases;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import pages.BasePage;

public class PageBase {
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	public PageBase(WebDriver driver){
		this.driver= driver;
		wait = new WebDriverWait(driver, 10);
    }
	
	public void clickButton(By button) {
		try {
			safeFind(button).click();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendText(By textBox, String text){
		safeFind(textBox).sendKeys(text);
	}

    public String getText(By element){
        return safeFind(element).getText();
    }

    private WebElement safeFind(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
    



}
