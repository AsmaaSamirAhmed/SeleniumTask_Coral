package BasesTest;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase1 extends AbstractTestNGCucumberTests {
	protected WebDriver driver;
	protected static Properties props;
	@BeforeSuite
	@Parameters({"BrowserType"})
	public void OpenBrowser(@Optional("chrome")String browser)
	{
		props = System.getProperties();
		try {
		props.load(new FileInputStream(new File("src/test/Inputs/Utility_data.properties")));
		} catch(Exception e) {
		e.printStackTrace();
		System.exit(-1);
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--lang=en-ca");
			driver=new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions FireOptions=new FirefoxOptions();
			FireOptions.addArguments("--lang=en-ca");
			driver=new FirefoxDriver(FireOptions);
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to(props.getProperty("url"));
		//assert that the URL opened successfully
		System.out.println("current url-->"+driver.getCurrentUrl());
		//Assert.assertEquals(driver.getCurrentUrl(), props.getProperty("url"));
	}
	 // take screenshot when test case fail and add it in the Screenshot folder
 	@AfterMethod
 	public void screenshotOnFailure(ITestResult result) 
 	{
 		if (result.getStatus() == ITestResult.FAILURE)
 		{
 			System.out.println("Failed!");
 			System.out.println("Taking Screenshot....");
 			Helper.captureScreenshot(driver,result.getName());
 		}
 	}
	/*@AfterSuite

	public void CloseBrowser()
	{
		driver.quit();
	}*/
}
