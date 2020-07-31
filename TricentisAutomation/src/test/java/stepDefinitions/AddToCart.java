package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	
	WebDriver driver;
	//Capture the logs
	Logger log = Logger.getLogger(Login.class);
	
	//Reading OR from properties files
	Properties prop = new Properties();
	
	FileInputStream inp = new FileInputStream("src/main/resources/config.properties");
	prop.load(inp);
	
	
	@Given("Select the Menu of Prodcuts {string}")
	public void select_the_menu_of_prodcuts(String menu) {
	
		driver.findElement(By.xpath(prop.getProperty("menu_xpath") + menu +"')]")).click();
		
	    throw new io.cucumber.java.PendingException();
	}

	@When("List of products are displayed")
	public void list_of_products_are_displayed(String product) {
	
		WebElement product_Link;
		WebDriverWait wait=null;
		product_Link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(prop.getProperty("productGrid_classname"))));
		Assert.assertTrue("List of Products are not displayed", product_Link.isDisplayed());
	    throw new io.cucumber.java.PendingException();
	}

	@And("Select the product to be added {string}")
	public void select_the_product_to_be_added(String product) {
	    
		driver.findElement(By.linkText(product)).click();
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button-13")));
		Assert.assertTrue("Add to Cart not displayed on screen",wait.isDisplayed());
		wait.click();
		   log.info("Product is selected to be added to cart");
		throw new io.cucumber.java.PendingException();
		
	}

	@Then("Click on Add to Cart")
	public void click_on_add_to_cart() {
		
		WebElement notification = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf((WebElement) By.className("bar-notification success")));
		Assert.assertTrue("Product not added to cart",notification.isDisplayed());
	    log.info("Product is added to cart");
	    throw new io.cucumber.java.PendingException();
	}

}
