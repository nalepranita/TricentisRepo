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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout  {

	WebDriver driver;
	//Capture the logs
	Logger log = Logger.getLogger(Login.class);

	//Reading OR from properties files
	Properties prop = new Properties();

	FileInputStream inp = new FileInputStream("src/main/resources/config.properties");
	prop.load(inp);

	@Given("User should be in the Shopping Cart")
	public void user_should_be_in_the_shopping_cart() {
		
		WebElement shoppingCart = driver.findElement(By.xpath(prop.getProperty("shoppingCart_xpath")));
		Boolean blnresult = shoppingCart.isEnabled();
		Assert.assertTrue("Unable to Find Shopping cart", blnresult);
		shoppingCart.click();
		
		throw new io.cucumber.java.PendingException();
	}

	@When("User Clicks on Checkout Button")
	public void user_clicks_on_checkout_button() {
		
		driver.switchTo().alert().dismiss();
		driver.findElement(By.id("termsofservice")).click();

		WebElement checkoutBtn = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.id("checkout")));
		Assert.assertTrue("Checkout Button not displayed on screen",checkoutBtn.isDisplayed());
		checkoutBtn.click();
		
		
		
		throw new io.cucumber.java.PendingException();
	}

	@Then("Enter Billing Address {string},{string},{string},{string},{string}")
	public void enter_billing_address(String country, String city, String Address1, String Zipcode, String phoneNumber) {
		
		Select select_Address= new Select(driver.findElement(By.cssSelector("#billing-address-select")));
		select_Address.selectByVisibleText("New Address");
		//Enter the Billing Address
		Select select_country= new Select(driver.findElement(By.cssSelector("#BillingNewAddress_CountryId")));
		select_country.selectByVisibleText(country);
		//Enter the city
		driver.findElement(By.id("#BillingNewAddress_City")).sendKeys(city);
		//Enter the Address1
		driver.findElement(By.id("#BillingNewAddress_Address1")).sendKeys(Address1);
		//Enter the Zipcode
		driver.findElement(By.id("#BillingNewAddress_ZipPostalCode")).sendKeys(Zipcode);
		//Enter the phone number
		driver.findElement(By.id("#BillingNewAddress_PhoneNumber")).sendKeys(phoneNumber);
		
		//click on Continue
		driver.findElement(By.xpath(prop.getProperty("billingContinue_xpath"))).click();
		

		//click on Continue- Shipping Address
		driver.findElement(By.xpath(prop.getProperty("ShippingContinue_xpath"))).click();
		
		throw new io.cucumber.java.PendingException();
	}

	@And("Enter Shipping Method {string}")
	public void enter_shipping_method(String ShippingMethod) {

		WebElement shipCheckBox = driver.findElement(By.cssSelector("//label[contains(text(),'"+ShippingMethod+"')]"));
		shipCheckBox.click();
		
		throw new io.cucumber.java.PendingException();
	}

	@Then("Click Continue")
	public void click_continue() {
		
		//click on Continue- Shipping Method
		driver.findElement(By.xpath(prop.getProperty("ShipMethodContinue_xpath"))).click();
		
		throw new io.cucumber.java.PendingException();
	}

}
