package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.RegisterPage;
import testbase.BaseClass;
public  class TC_001_Register extends BaseClass{
	
 
	@Test(groups= {"sanity","master"})
	public void verifyRegisterpage() throws InterruptedException
	{
		try {
		//logger.info("****Starting tc_001_Registerpage*****"); 
		Homepage hp=new Homepage(driver);
		hp.clickRegister();
		//logger.info("**clicked on Register option****");
		
		RegisterPage regpage=new RegisterPage(driver);
		regpage.clickgender();
		
		//logger.info("**Providing all user information**"); 
		regpage.setFirstname(randomeString());
		regpage.setLastName(randomeNumber());
		regpage.setEmail(randomeString()+"@gmail.com");
		String password=randomeAlphaNumeric();
		
		regpage.setpassword(password);
		regpage.setconfirmpassword(password);
		regpage.clickRegister();
		
		//logger.info("**validating confirmation message**");
		
		String confirmregistration=regpage.registrationdonemsz();
		Assert.assertEquals(confirmregistration, "Your registration completed");
		regpage.Clickcontinue();
		Thread.sleep(10000);
		}
		catch(Exception e)
		{
			logger.error("test failed");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		//logger.info("**Test case completed**");
	}
	
}

