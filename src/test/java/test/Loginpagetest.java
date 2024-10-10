package test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import library.Baseclass;
import library.utilityclass;
import pages.Loginpage;	
public class Loginpagetest extends Baseclass
{
	int TCID;
	Loginpage login;
	@BeforeMethod
	public void setup()
	{
	login=new Loginpage(driver);
	}
	
	@Test(enabled = false)
	public void verifyURL() throws IOException 
	{
		String actURL = login.verifyURL();
		String expURL = utilityclass.readPDFData("URL");
		Assert.assertEquals(actURL, expURL);
	}
	
	@Test(enabled = false)
	public void verifyLogo()
	{
		boolean actlogo = login.verifyLogo();
		Assert.assertEquals(actlogo,true);
	}

	
	@Test(dataProvider="credential",dataProviderClass=utilityclass.class)
	public void verifyLoginFunctionality(String testcase,String username,String password,String result) throws IOException
	{
		login.enterCredentials(username,password);
		if(testcase.equals("valid"))
		{
			TCID=1;
			String actResult = login.verifyURL();
			String expResult = result;
			boolean urlResult = actResult.equals(expResult);
			boolean labelDisplayed = login.verifyProductLabel();
			Assert.assertEquals(urlResult&&labelDisplayed,true);
		}
		else if (testcase.equals("invalid"))
		{
			TCID=2;
			String actResult = login.getErrorMsg();
			String expResult = result;
			Assert.assertEquals(actResult,expResult);
		}
		else if (testcase.equals("empty"))
		{
			TCID=3;
			String actResult = login.getErrorMsg();
			String expResult = result;
			Assert.assertEquals(actResult,expResult);
		}else if (testcase.equals("emptyPWD"))
		{
			TCID=4;
			String actResult = login.getErrorMsg();
			String expResult = result;
			Assert.assertEquals(actResult,expResult);
		}
		
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