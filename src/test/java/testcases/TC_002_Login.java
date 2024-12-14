package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import testbase.BaseClass;

public class TC_002_Login extends BaseClass{ 
	
	@Test (groups= {"regression","master"})
	public void verifylogintest()
	
	{
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
		Loginpage lp= new Loginpage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));;
		lp.clicklog();
		String welcomelabelexists=lp.welcomeconfirmation();
		Assert.assertEquals(welcomelabelexists,"Welcome to our store" );
		
				
	}
	
	
	
	

}
