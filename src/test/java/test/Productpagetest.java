package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import library.Baseclass;
import library.utilityclass;
import pages.Productpage;
import pages.Loginpage;
public class Productpagetest extends Baseclass {

	Productpage product;
	Loginpage login;
	public int TCID;
	
	@BeforeMethod
	public void setup()
	{
		product=new Productpage(driver);
		login=new Loginpage(driver);
	}
	
	@Test
	public void logoutFunctionality() throws IOException 
	{
		TCID=5;
		login.enterDefCredentials();
		String actURL = product.logout();
		String expURL = utilityclass.readPDFData("URL");
		Assert.assertEquals(actURL, expURL);
	}
	@AfterMethod
	public void TCfailure(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			utilityclass.captureSS(3);
		}
	}
	}
