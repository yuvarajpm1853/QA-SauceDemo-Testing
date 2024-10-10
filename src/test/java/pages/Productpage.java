package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import library.Baseclass;

public class Productpage extends Baseclass{
	
	@FindBy(xpath="//div[@class='bm-burger-button']") private WebElement burgerBtn;
	@FindBy(xpath="//div[@class='shopping_cart_container']") private WebElement cartBtn;
	@FindBy(id="logout_sidebar_link") private WebElement logout;
	@FindBy(xpath="/html/body/div/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/a/div") private WebElement prodOne;
	@FindBy(xpath="//button[@class='btn_primary btn_inventory']") private WebElement addToBtn;
	
	public Productpage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCart() {
		cartBtn.click();
	}

	public String logout()
	{
		burgerBtn.click();
		logout.click();
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public void addProdOne() {
		prodOne.click();
		addToBtn.click();		
	}
	
}
