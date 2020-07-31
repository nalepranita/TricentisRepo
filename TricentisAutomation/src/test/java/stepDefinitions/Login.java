package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login  {
		
		WebDriver driver=null;
		//Capture the logs
		Logger log = Logger.getLogger(Login.class);
		
		//Reading OR from properties files
		Properties prop = new Properties();
		FileInputStream inp = new FileInputStream("src/main/resources/config.properties");
		prop.load(inp);

		@Given("The Tricentis DemoWebShop website is opened")
		public void the_tricentis_demo_web_shop_website_is_opened() throws InterruptedException {
			log.info("Launching the website");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver_path"));
			driver= new ChromeDriver();
			driver.navigate().to(prop.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			//Verify if the website is opened or not
			WebElement HomeLbl = driver.findElement(By.xpath(prop.getProperty("homePage_xpath")));
			Assert.assertEquals(true,HomeLbl.isDisplayed());
			
			throw new io.cucumber.java.PendingException();
		}


		@When("User Enters {string} and {string}")
		public void user_enters_and(String username, String password) {
			
			driver.findElement(By.className("ico-login")).click();
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.name("Password")).sendKeys(password);
			
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			
		    throw new io.cucumber.java.PendingException();
		}
		@When("Clicks on Login Button")
		public void clicks_on_login_button() {
			driver.findElement(By.xpath(prop.getProperty("Login_xpath"))).click();
			
		    throw new io.cucumber.java.PendingException();
		}
		@Then("User is navigated to HomePage with {string} displayed")
		public void user_is_navigated_to_home_page(String username) {
			//Verify if login is successfull
			String emailAcc = driver.findElement(By.className("account")).getText();
			Assert.assertEquals(emailAcc,username);
		    throw new io.cucumber.java.PendingException();
		}




}//closing the class
