package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Helper.BrowserSelection;
import Helper.ReadExcel;
import Helper.captureScreenShot;
import TestScript.Page1;

public class verifyPage1 {
	WebDriver driver=null;
	Page1 page1;
	@BeforeMethod
	public void setUp() {
		//cross browser testing
		BrowserSelection browser=new BrowserSelection();
		driver=browser.getBrowser("chrome", "https://www.facebook.com/");
//		String browservalue= ReadDetails.getPropertiesDetails("browser");
//		String urlValue=ReadDetails.getPropertiesDetails("url");
//		browser.getBrowser(browservalue, urlValue);
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		page1=new Page1(driver);
	}

	@Test(dataProvider = "info", priority = 1)
	public void loginTc(String u1, String p1) {
		page1.getLogin(u1, p1);
		Assert.assertEquals(0, 0);
	}

	 @DataProvider
	    public Object[][] info()
	    {
	    	ReadExcel ex= new ReadExcel();
	    	int rowcnt = ex.getRowCount(0);
	    	int colcnt = ex.getColumnCount(0);
	    	System.out.println("Rows: " + rowcnt + "Columns: " + colcnt);
	    	
	    	Object[][] dataobj = new Object[rowcnt+1][colcnt];
	    	for(int r=0; r <= rowcnt; r++) {
	    		for(int c=0; c < colcnt; c++) {
	    			dataobj[r][c] = ex.getdata(0, r, c);
	    		}
	    	}
	    	return dataobj;
	    				
	    }
	 
	@Test(priority = 2)
	public void verifyForgetPwd() {
		
		page1.getRecoverPassword();

		
		//Assert.assertEquals(10, 20);
	}
	
	@AfterMethod
	public void tearDown(ITestResult r) {
		int actualStatus = r.getStatus();
		int exceptStatus = ITestResult.FAILURE;
		//fail
		if (actualStatus == exceptStatus) {
			captureScreenShot screenshot = new captureScreenShot();
			screenshot.getErrorScreenshot(driver);
		}
		driver.quit();
	}
}
