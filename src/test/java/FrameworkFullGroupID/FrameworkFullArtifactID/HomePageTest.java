package FrameworkFullGroupID.FrameworkFullArtifactID;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Login;
import resources.BaseClass;
import resources.ReadExcelData;

public class HomePageTest extends BaseClass {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
	}


	@Test(dataProvider = "getData")
	public void enterCreds(String username, String password) throws IOException {
		driver.get(url);
		HomePage hp = new HomePage(driver);
		hp.getLogin().click();
		Login l = new Login(driver);
		l.getUserId().sendKeys(username);
		l.clickNext().click();
		l.getPassword().sendKeys(password);
		l.clickSubmit().click();
		//Assert.assertTrue(driver.getTitle().equals("Dashboard"),"Incorrect Title found");

	}

	@DataProvider
	public Object[][] getData() {
		ReadExcelData rd = new ReadExcelData("C:\\CPQWorkspace\\FrameworkFullArtifactID\\TestData\\Book2.xlsx");
		int rows = rd.getRows(0);
		Object[][] data = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			data[i][0] = rd.getData(0, i, 0);
			data[i][1] = rd.getData(0, i, 1);
		}
		return data;
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver = null;
	}

}
