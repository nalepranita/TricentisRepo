package stepDefinitions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentProcessing {

	WebDriver driver;
	//Capture the logs
	Logger log = Logger.getLogger(Login.class);
	
	//Reading OR from properties files
	Properties prop = new Properties();
	
	FileInputStream inp = new FileInputStream("src/main/resources/config.properties");
	prop.load(inp);

@Given("User should be in Payment Method section")
public void user_should_be_in_payment_method_section() {
	//Validate the payment method screen
	WebElement paymentMethod;
	WebDriverWait wait=null;
	paymentMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("paymentScreen_xpath"))));
	Assert.assertTrue("Payement Method screen not displayed", paymentMethod.isDisplayed());
	
    throw new io.cucumber.java.PendingException();
}



@When("User Enter Payment Information {string},{string},{string},{string},{string},{string},{string},{string}")
public void enter_payment_information(String paymentType, String cardType, String cardHolderName, String cardNumber, String expirationMonth, String expirationYear,String cardCode,String PO_Number) {
	
	//Select the Payment Type
	driver.findElement(By.cssSelector("[value='"+paymentType+"'][type='radio']")).click();
	//Click on Continue
	driver.findElement(By.xpath(prop.getProperty("paymentContinue_xpath"))).click();
    throw new io.cucumber.java.PendingException();
    
     
       switch (paymentType) 
       { 
       case "Credit Card": 
    	 WebElement lblCredit = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("lblCreditCard"))));
   		Assert.assertTrue("Credit Card information Page not displayed",lblCredit.isDisplayed());
       	//Select the Card Type
       	Select select_Address= new Select(driver.findElement(By.xpath(prop.getProperty("paymentScreen_xpath"))));
   		select_Address.selectByVisibleText(cardType);
   		//Enter the Cardholder Name
   		driver.findElement(By.id("CardholderName")).sendKeys(cardHolderName);
   		//Enter card number
   		driver.findElement(By.id("CardNumber")).sendKeys(cardNumber);
   		//Enter hte Expiration Month
   		driver.findElement(By.id("ExpireMonth")).sendKeys(expirationMonth);
   		//Enter Expiration Year
   		driver.findElement(By.id("ExpireYear")).sendKeys(expirationYear);
   		//Enter Card Code
   		driver.findElement(By.id("CardCode")).sendKeys(expirationYear);
   		
           break; 
       case "Purchase Order": 
    	   WebElement lblPoNumber = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("lblPoNumber_xpath"))));
    	   Assert.assertTrue("PO Number information Page not displayed",lblPoNumber.isDisplayed());
    	   //Enter the PO Number
    	   driver.findElement(By.id("PurchaseOrderNumber")).sendKeys(PO_Number);
           break; 
       case "Cash On Delivery (COD) (7.00)": 
    	   WebElement codMessage = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("cod_xpath"))));
    	   Assert.assertTrue("Money order information Page not displayed",codMessage.isDisplayed());
           break; 
       case "Check / Money Order (5.00)": 
    	   WebElement moneyOrder = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("moneyOrder_xpath"))));
    	   Assert.assertTrue("Money order information Page not displayed",moneyOrder.isDisplayed());
           break; 
       } 
       //Click Continue
  		driver.findElement(By.xpath(prop.getProperty("paymentContinue"))).click();
	
    throw new io.cucumber.java.PendingException();
}

private void Switch(String paymentType) {
	// TODO Auto-generated method stub
	
}

@Then("Review Order and Click Confirm Order {string}")
public void click_confirm_order(String product) {

	WebElement reviewOrder = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("orderReview_xpath"))));
	Assert.assertTrue("Product order information Page not displayed",reviewOrder.isDisplayed());
    throw new io.cucumber.java.PendingException();
    
    //Verify the product
    String productText = driver.findElement(By.className("product-name")).getText();
    Assert.assertTrue("Product not found on order screen!", productText.contains(product));
    
    //Click on Confirm
    driver.findElement(By.xpath(prop.getProperty("cofirmOrder_xpath"))).click();;
    
    
}


	
	
}//closing of class
