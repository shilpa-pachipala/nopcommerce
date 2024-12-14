package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{
	
	WebDriver driver;
	//constructor
	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	


@FindBy(xpath="//a[normalize-space()='Register']")
WebElement Register;

@FindBy(xpath="//a[normalize-space()='Log in']")
WebElement Login;

	
	
	//action methods

public void clickRegister()
{
	Register.click();
}
public void clickLogin()
{
	Login.click();
	
}
}
