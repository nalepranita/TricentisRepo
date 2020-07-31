package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utility.Utilities;


public class CheckOrderDetails {
	
	
	WebDriver driver;
	//Capture the logs
	Logger log = Logger.getLogger(Login.class);
	
	//Reading OR from properties files
	Properties prop = new Properties();
	
	FileInputStream inp = new FileInputStream("src/main/resources/config.properties");
	prop.load(inp);
	

	
	
	@Given("Order is booked already")
	public void order_is_booked_already() {
		
		//Verify if the order is booked
		WebElement orderMsg = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("thankyouMsg_xpath"))));
		Assert.assertTrue("Thank You - Order Message is displayed",orderMsg.isDisplayed());
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Capture Order information")
	public void capture_order_information() {
	    
		//Print the Order Number
		String orderNumber = driver.findElement(By.xpath(prop.getProperty("orderNumber_xpath"))).getText();
		log.info(orderNumber);
		//Take Screenshot
		Utilities objScreenshot = new Utilities();
		objScreenshot.screenshot(driver, System.currentTimeMillis());
		log.info("Screenshot Taken");
		
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Logout link is visible")
	public void logout_link_is_visible() {
		Boolean blnresult = driver.findElement(By.xpath(prop.getProperty("orderNumber_xpath"))).isEnabled();
		Assert.assertTrue("Logout linkis not visible on screen",blnresult);
	    throw new io.cucumber.java.PendingException();
	}

	@When("Clicks on Logout")
	public void clicks_on_logout() {
	   
		//Click on Logout
		driver.findElement(By.xpath(prop.getProperty("orderNumber_xpath"))).click();
		
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is logged out")
	public void user_is_logged_out() {
	    
		Boolean emailAcc = driver.findElement(By.className("account")).isDisplayed();
		Assert.assertFalse("User not Logged out", emailAcc);
	    throw new io.cucumber.java.PendingException();
	}

}
