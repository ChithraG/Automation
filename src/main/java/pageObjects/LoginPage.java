package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By username = By.xpath("//input[@id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By submit = By.xpath("//input[@name='commit']");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}	
	public WebElement getUserId()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickSubmit()
	{
		return driver.findElement(submit);
	}

}
