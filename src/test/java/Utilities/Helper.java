package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	// Method to take screenshot when the test cases fail
		public static void captureScreenshot(WebDriver driver,String screenshotname)
		{
			
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	        try {
	            FileUtils.copyFile(file, new File("./ScreenShots/"+screenshotname+timestamp+".png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
//			Path dest = Paths.get("./Screenshots",screenshotname+System.currentTimeMillis()+".png");
//			try {
//				Files.createDirectories(dest.getParent());
//				FileOutputStream out = new FileOutputStream(dest.toString());
//				out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//				out.close();
//			} catch (IOException e) {
//				System.out.println("Excpetion while taking screenshot"+ e.getMessage());
//			}
			
		}
}
