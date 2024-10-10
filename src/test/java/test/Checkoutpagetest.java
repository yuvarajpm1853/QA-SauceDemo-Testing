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
import pages.Checkoutpage;
import pages.Loginpage;

public class Checkoutpagetest extends Baseclass  {

	Productpage product;
	Loginpage login;
	Checkoutpage checkout;
	
	int TCID;
	
	@BeforeMethod
	public void setup()
	{
		product=new Productpage(driver);
		login=new Loginpage(driver);
		checkout=new Checkoutpage(driver);
	}
		
	@Test
	public void checkoutFunctionality() throws IOException 
	{
		TCID=6;
		login.enterDefCredentials();
		product.addProdOne();
		product.clickOnCart();
		String actText = checkout.finishCheckOut();
		String expText = "Finish";
		Assert.assertEquals(actText, expText);
	}
	
	@AfterMethod
	public void TCfailure(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			utilityclass.captureSS(TCID);
		}
		
	}
}
