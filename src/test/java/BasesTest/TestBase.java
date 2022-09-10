package BasesTest;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    protected static Properties props;

    @BeforeSuite
    public static void setUp() {
         props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/test/Inputs/Utility_data.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
       /* DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability("nativeEvents", false);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);*/
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(props.getProperty("url"));
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

   /* @AfterSuite
      public void tearDown(){
        driver.quit();
    }
*/
}
