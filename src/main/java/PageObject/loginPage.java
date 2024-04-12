package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	private  WebDriver driver;
	
	//Locators
	 public  By username = By.cssSelector("input[id=user-name]");
	 public  By password =By.cssSelector("input[id=password]");
	 public  By click =By.cssSelector("input[id=login-button]");
	 //driver.findElement(By.cssSelector("input[id=user-name]")).sendKeys("standard_user");
		//driver.findElement(By.cssSelector("input[id=password]")).sendKeys("secret_sauce");
		
	 // Constructor
	    public loginPage(WebDriver driver) {
	        this.driver = driver;
	    }
     //Method
	    public void enterUsername() {
	        WebElement usernm = driver.findElement(username);
	        usernm.sendKeys("standard_user");
	    }

	    public void enterPassword() {
	        WebElement passwrd = driver.findElement(password);
	        passwrd.sendKeys("secret_sauce");
	    }
	    public void clicked() {
	        WebElement enter = driver.findElement(click);
	        enter.click();
	    }
}
