package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public WebDriver driver;
	
	By username = By.xpath("//input[@id='usernameOrEmail']");
	By next = By.xpath("//button[@type='submit']");
	By password = By.xpath("//input[@id='password']");
	By login = By.xpath("//button[contains(.,'Log In')]");

	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUserId()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickNext()
	{
		return driver.findElement(next);
	}
	
	public WebElement clickSubmit()
	{
		return driver.findElement(login);
	}

	

}
