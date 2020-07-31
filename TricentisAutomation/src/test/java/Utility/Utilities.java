package Utility;



import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import stepDefinitions.Login;


public class Utilities {
	//Capture the logs
		Logger log = Logger.getLogger(Login.class);
	public void screenshot(WebDriver driver, long ms)
	{

	try {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source, new File("/target/Results"+ms+"OrderConfirmation.png"));
	    log.info("ScreenShot Taken");
	} 
	catch (Exception e) 
	{
	    System.out.println("Exception while taking ScreenShot "+e.getMessage());
	}


	}
	
		
		
	
}
