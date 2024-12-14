package testcases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.MyAccountpage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_loginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	
public void verifyloginDDT(String email,String pswd,String exp)
{ 
		
		
		//homepage
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
		//loginpage
		Loginpage lp=new Loginpage(driver);
		lp.setemail(email);
		lp.setpassword(pswd);
		
		lp.clicklog();
		//myaccountpage
		MyAccountpage mypg=new MyAccountpage(driver);
		boolean targetpage=mypg.iswelcomemsgExists();
		/*data is valid -login success-testpass-logout
		                 loginfail-testfail
		                 
		  data invalid -login success-tesfail-logout
		                loginfail-testfail
		                 
		                 */
		                 
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				mypg.clicklogout();
				Assert.assertTrue(true);
				
			
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{

			if(targetpage==true)
			{
				mypg.clicklogout();
				Assert.assertTrue(false);
				
			
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
}
}
