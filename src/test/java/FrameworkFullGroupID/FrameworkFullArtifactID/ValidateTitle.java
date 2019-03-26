package FrameworkFullGroupID.FrameworkFullArtifactID;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.BaseClass;

public class ValidateTitle extends BaseClass {
	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
		driver.get(url);
	}

	@Test
	public void validate() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals("FEATURED COURSES", lp.getTitle().getText());
	}
	@AfterTest
	public void close()
	{
		driver.close();
		driver = null;
	}

}
