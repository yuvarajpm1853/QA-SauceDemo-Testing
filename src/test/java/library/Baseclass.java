package library;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
public class Baseclass 
{
	public static WebDriver driver;
	@BeforeMethod
    public void IntiliazeBrowser() throws IOException 
    {
		String URL = utilityclass.readPDFData("URL");
		driver=BrowserFactory.startApplication(driver, "firefox", URL);
    	
    }
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
}