package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Homepage;
import pageobjects.Loginpage;
import pageobjects.MyAccountpage;
import testbase.BaseClass;

public class TC_003_MyAccountpage extends BaseClass{
	
	@Test(groups= {"regression","sanity"})
	public void verifyMyaccountpage() 
	
	{
		Homepage hp=new Homepage(driver);
		hp.clickLogin();
		Loginpage lp=new Loginpage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clicklog();  
		
		MyAccountpage mypg=new MyAccountpage(driver);
		boolean msgexistsornot=mypg.iswelcomemsgExists();
		if(msgexistsornot==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
			
		}
		mypg.Searchproduct(p.getProperty("searchProductName"));
		mypg.clickSearch();
		mypg.clickproduct();
		
	}
	

}
