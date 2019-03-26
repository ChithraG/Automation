package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//section[@id='content']/div/div/h2");
	By bar = By.xpath("//nav[@class='navbar-collapse collapse']/ul");
	//By bar = By.linkText("Contact");

	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNav()
	{
		return driver.findElement(bar);
	}
}
