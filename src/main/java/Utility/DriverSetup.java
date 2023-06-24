package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup 
{
	public WebDriver setUp(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.zigwheels.com/");
		return driver;
	}
}
