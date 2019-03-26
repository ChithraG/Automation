package FrameworkFullGroupID.FrameworkFullArtifactID;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.BaseClass;

public class ValidateNavBar extends BaseClass{
	@BeforeTest
	public void init() throws IOException
	{
		driver = initDriver();
		driver.get(url);
	}
	@Test
	public void validateNav()
	{
	
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNav().isDisplayed());
	}
	
	@Test
	public void validateNav2()
	{
	
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNav().isDisplayed());
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver = null;
	}

}
