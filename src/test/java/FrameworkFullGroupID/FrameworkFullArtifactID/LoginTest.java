package FrameworkFullGroupID.FrameworkFullArtifactID;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseClass;
import resources.ReadExcel;
import resources.ReadExcelData;

public class LoginTest extends BaseClass {
	@BeforeTest
	public void init() throws IOException {
		driver = initDriver();
	}
	
@Test(dataProvider="getData")
	public void login(String userId, String password) throws IOException {
		driver.get(url);
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getUserId().sendKeys(userId);
		lp.getPassword().sendKeys(password);
		System.out.print("test");
		lp.clickSubmit().click();
		//Assert.assertTrue("Incorrect Title found",driver.getTitle().equals("Dashboard"));
		
	}
	
/*	@Test
	public void loginExcel() throws IOException
	{
		driver.get(url);
		ReadExcel read = new ReadExcel();
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		ArrayList<String> creds = read.getData("Case1");
		System.out.println("inside login");
		lp.getUserId().sendKeys(creds.get(0));
		lp.getPassword().sendKeys(creds.get(1));
		lp.clickSubmit().click();
	}*/
	
	@DataProvider
	public Object[][] getData()
	{
		ReadExcelData rd = new ReadExcelData("C:\\CPQWorkspace\\FrameworkFullArtifactID\\TestData\\Book2.xlsx");
		int rows = rd.getRows(0);
		Object[][] data = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			data[i][0] = rd.getData(0, i, 0);
			data[i][1] = rd.getData(0, i, 1);
		}
		/*data[0][0] = "abc@gmail.com";
		data[0][1] = "Test@123";
		data[0][2] = "Restricted User";
		data[1][0] = "xyz@gmail.com";
		data[1][1] = "Test@987";
		data[1][2] = "Non-Restricted User";*/
		
		return data;
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver = null;
	}
}
