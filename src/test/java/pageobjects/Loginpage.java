package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{
	WebDriver driver;
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators

@FindBy(xpath="//input[@id='Email']")
WebElement Email;

@FindBy(xpath="//input[@id='Password']")
WebElement Password;

@FindBy(xpath="//button[normalize-space()='Log in']")
WebElement clicklogin;

@FindBy(xpath="//h2[normalize-space()='Welcome to our store']")
WebElement welcomemsg;



//Actionmethods

public void setemail(String email)
{
	Email.sendKeys(email);
	
}
public void setpassword(String password)
{
	Password.sendKeys(password);
}

	public void clicklog()
	{
		clicklogin.click();
		
	}
	public String welcomeconfirmation()
	{
		try 
		{
		return(welcomemsg.getText());	
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
 
}
