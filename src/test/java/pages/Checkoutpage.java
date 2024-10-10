package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.Baseclass;

public class Checkoutpage extends Baseclass {

	@FindBy(xpath="//a[@class='btn_action checkout_button']") private WebElement checkoutBtn;
	@FindBy(id="first-name") private WebElement FN;
	@FindBy(id="last-name") private WebElement LN;
	@FindBy(id="postal-code") private WebElement POSTAL_CODE;
	@FindBy(xpath="//input[@class='btn_primary cart_button']") private WebElement continueBtn;
	@FindBy(xpath="//a[@class='btn_action cart_button']") private WebElement finisheBtn;
	@FindBy(xpath="//div[@class='subheader']") private WebElement finish;
	
	
	public Checkoutpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String finishCheckOut() {
		checkoutBtn.click();
		FN.sendKeys("Yuvaraj");
		LN.sendKeys("P");
		POSTAL_CODE.sendKeys("631205");
		continueBtn.click();
		finisheBtn.click();
		return finish.getText();
	}
}
