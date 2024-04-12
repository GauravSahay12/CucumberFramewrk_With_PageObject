package StepDefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.runner.RunWith;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import PageObject.loginPage;


@RunWith(Cucumber.class)
public class LoginStepsDefination {
	static WebDriver driver;
	public loginPage loginPage;
	
	@Before
	public void setup()  {
		System.out.println("Before Hook step");
		
		
		driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
		  loginPage = new loginPage(driver);
	}
	
	@After
	public void tearup() {
		driver.quit();
		System.out.println("After Hook step");
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   //driver= new ChromeDriver();
	   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) ;
	   //driver.get("https://www.saucedemo.com/v1/");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
	"C:\\Users\\SahaY\\eclipse-workspace\\CucumberProject4\\src\\main\\java\\Resource\\Data.property");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
			   }

	@When("User enter valid username and passwrd")
	public void user_enter_valid_username_and_passwrd() {
	    // Write code here that turns the phrase above into concrete actions
	
		loginPage.enterUsername();
		loginPage.enterPassword();
		
		 //driver.findElement(By.cssSelector("input[id=user-name]")).sendKeys("standard_user");
		//driver.findElement(By.cssSelector("input[id=password]")).sendKeys("secret_sauce");
		
	
	}

	@And("Click on login button")
	public void click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		//driver.findElement(By.cssSelector("input[id=login-button]")).click();
		 loginPage.clicked();
	}

	@Then("User should be navigate to homepage")
	public void user_should_be_navigate_to_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		//Here we navigate to another page where new element is found
		
	  Assert.assertTrue(driver.findElements(By.xpath("//div[@id='header_container']/div[1]")).size()>0,"User navigate to homepage");
	}

	@And("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
		
	}




}
