package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass{
	 public static WebDriver driver;
	 public Properties p;
	 public Logger logger;
	 
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	
	public void setup(String os,String br) throws IOException
	{
		//loading properties file
		FileReader file=new FileReader(".//src/test/resources/Config.properties");
		p=new Properties();
		p.load(file);
		
		//reading log file
		//logger=LogManager.getLogger(this.getClass());
		
		 /*if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
				
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
			capabilities.setPlatform(Platform.MAC)	;
			}
			else
			{
				System.out.println("no matching os");
				return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");
			case "firefox": capabilities.setBrowserName("firefox");
			default: System.out.println("no matching browser");
			return;
			
			} */
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser"); return;
			}
			
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
if(p.getProperty("execution_env").equalsIgnoreCase("env_local"));
{
			
			
	
			
		}
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver(); break;
		case "Edge": driver=new EdgeDriver();break;
		default:System.out.println("Invalid Browser name");
		return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://demo.nopcommerce.com/");
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity","regression","master"})
	public void teardown()
	{
		driver.close();
		
	}
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
		
	}
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(7);
		return generatedString;
		
			
	}
	public String randomeAlphaNumeric()
	{
		 String str=RandomStringUtils.randomAlphabetic(3);
		 String num=RandomStringUtils.randomNumeric(4);
		 return(str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}