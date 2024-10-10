package library;

import java.io.*;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

public class utilityclass extends Baseclass {

	public static String readPDFData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//TestData//config.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static void captureSS(int TCID) throws IOException {
		File dest = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File src = new File(System.getProperty("user.dir")+"//Screenshot//FailedTestCase_"+TCID+".jpg");
		FileHandler.copy(dest, src);
	}
	
	@DataProvider(name="credential")
	public Object[][] getData() throws IOException
	{
		XLUtility excel = new XLUtility(System.getProperty("user.dir")+"//TestData//TestData.xlsx");
		Object[][] data= excel.twoDArray("loginCredentials");
		return data;
	}
}
