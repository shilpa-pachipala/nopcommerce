package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Basepage {
	
	public MyAccountpage(WebDriver driver) 
	{
		super(driver);
		
	}

	//locators
	

@FindBy(xpath="//h2[normalize-space()='Welcome to our store']")
WebElement welcomemsg;

@FindBy(xpath="//a[normalize-space()='Log out']")
WebElement logout;

@FindBy(xpath="//input[@id='small-searchterms']")
WebElement Searchoption;
@FindBy(xpath="//button[normalize-space()='Search']")
WebElement searchbtn;

@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")
WebElement ClickProduct;
@FindBy(xpath="//button[@id='add-to-cart-button-18']")
WebElement Addtocart;
@FindBy(xpath="//span[@class='cart-label']")
WebElement clickonshoppingcart;

@FindBy(xpath="//div[@id='quantity-up-11225']")
WebElement Qtyincrease;
@FindBy(xpath="//button[normalize-space()='Continue shopping']")
WebElement Continueshopping;



public boolean iswelcomemsgExists()
{
	try 
	{
		return welcomemsg.isDisplayed();
	}
	catch(Exception e)
	{
		return false;
	}
	
}
public void clicklogout()
{
logout.click();

}
public void Searchproduct(String productname)
{
	Searchoption.sendKeys(productname);
}
public void clickSearch()
{
	searchbtn.click();	
}
public void clickproduct()
{
	ClickProduct.click();
	
}
public void addtocart()
{
	Addtocart.click();
}
public void clickcontinueshop()
{
	clickonshoppingcart.click();
	
}
public void increaseqty()
{
	Qtyincrease.click();
}
public void continuetoshop()
{
	Continueshopping.click();
}
}
	

