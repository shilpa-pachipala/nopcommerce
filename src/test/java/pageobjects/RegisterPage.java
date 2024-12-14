package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Basepage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	

@FindBy(xpath="//input[@id='gender-male']")
WebElement gender;

@FindBy(xpath="//input[@id='FirstName']")
WebElement Firstname;
@FindBy(xpath="//input[@id='LastName']")
WebElement Lastname;
@FindBy(xpath="//input[@id='Email']")
WebElement Email;

@FindBy(xpath="//input[@id='Password']")
WebElement Password;

@FindBy(xpath="//input[@id='ConfirmPassword']")
WebElement cnfrmpassword;

@FindBy(xpath="//button[@id='register-button']")
WebElement clickRegister;

@FindBy(xpath="//*[normalize-space()='Your registration completed']")
WebElement regcompleted;

@FindBy(xpath="//a[normalize-space()='Continue']")
WebElement Continue;


         
        public void clickgender() 
        {
        	gender.click();
        	
        }

        public void setFirstname(String firstname)
        {
        	Firstname.sendKeys(firstname);
        }
        public void setLastName(String lastname)
        {
        	Lastname.sendKeys(lastname);
        }
        public void setEmail(String email)
        {
        	Email.sendKeys(email);
        }
        public void setpassword(String password)
        {
        	Password.sendKeys(password);
        }
        public void setconfirmpassword(String cnfrmpswd)
        {
        	cnfrmpassword.sendKeys(cnfrmpswd);
        }
        public void clickRegister()
        {
        	clickRegister.click();
        }
        public void Clickcontinue()
        {
        	Continue.click();
        	
        }
        public String registrationdonemsz()
        {
        	try 
        	{
        		return(regcompleted.getText());
        		
        	}
        	catch(Exception e)
        	{
        		return(e.getMessage());
        	}
        }


}
