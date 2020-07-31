package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProducts {

	WebDriver driver= null;
	//Reading OR from properties files
	  
	Properties prop = new Properties();
	FileInputStream inp = new FileInputStream(System.getProperty("src/main/resources/config.properties"));
	prop.load(inp);
	
	
	
	//Capture the logs
	Logger log = Logger.getLogger(Login.class);
	
	@Given("The Search Bar is visible")
	public void the_search_bar_is_visible() throws InterruptedException {
		
		Boolean bln_result = driver.findElement(By.id("small-searchterms")).isDisplayed();
		Assert.assertTrue(bln_result);
		throw new io.cucumber.java.PendingException();
	}
	
	@When("User Enters {string} to be searched")
	public void user_enters_to_be_searched(String product) {
		 driver.findElement(By.id("small-searchterms")).sendKeys(product);
		throw new io.cucumber.java.PendingException();
	}
	@And("Clicks on Search Button")
	public void clicks_on_search_button() {
		
		driver.findElement(By.xpath(prop.getProperty("searchButton_xpath")));
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		throw new io.cucumber.java.PendingException();
		
	}
	@Then("User is displayed with list of items")
	public void user_is_displayed_with_list_of_items() {
		
		//if the results are not found
		WebElement searchNotound = (WebElement) driver.findElements(By.xpath(prop.getProperty("searchNotFound_xpath")));
		if (searchNotound.isDisplayed()){
			log.info("No products were found that matched your criteria");
		}else{
		//if the results are found
		List<WebElement> searchList = driver.findElements(By.xpath(prop.getProperty("searchResults_xpath")));
		log.info("total no of value"+searchList.size());
        for (WebElement product : searchList) {
        	log.info(product.getText());
        } 
        }
		throw new io.cucumber.java.PendingException();
		
	}
	
}
