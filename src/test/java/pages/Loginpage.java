package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.Baseclass;
import library.utilityclass;

public class Loginpage extends Baseclass
{
	@FindBy(xpath="//div[@class='login_logo']") private WebElement logo;
	@FindBy(id="user-name") private WebElement UN;
	@FindBy(id="password") private WebElement PWD;
	@FindBy(id="login-button") private WebElement loginBTN;
	@FindBy(xpath="//h3[@data-test='error']") private WebElement errorMsg;
	@FindBy(xpath="//div[@class='product_label']") private WebElement label;
	public Loginpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyURL()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	public boolean verifyLogo()
	{
		boolean lg = logo.isDisplayed();
		return lg;
	}
	public boolean verifyProductLabel()
	{
		boolean labelDisplay = label.isDisplayed();
		return labelDisplay;
	}
	
	public void enterCredentials(String username, String password)
	{
		UN.sendKeys(username);
		PWD.sendKeys(password);
		loginBTN.click();
	}
	
	public void enterDefCredentials() throws IOException
	{
		String username = utilityclass.readPDFData("Username");
		String password = utilityclass.readPDFData("password");
		enterCredentials(username,password);
	}
	public String getErrorMsg()
	{
		return errorMsg.getText();
	}
}