package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utility.CommonMethods;

public class LoginPage 
{
	By homePagePath=By.xpath("//a[@class='zw i-b mt-10 pt-2']");
	By loginSignUp=By.xpath("//div[@id='forum_login_div_lg']");
	By googleLogo=By.xpath("//span[@class='lgn-sp s ggle']");
	By emailField=By.xpath("//input[@type='email']");
	By errorMsg=By.xpath("//div[@class='o6cuMc Jj6Lae']");
	
	WebDriver driver=null;
	CommonMethods methods=new CommonMethods();
	
	public LoginPage(WebDriver d)
	{
		driver=d;
	}
	
	public void login() throws IOException
	{
		driver.findElement(homePagePath).click();
		String parentWindow=driver.getWindowHandle();
		methods.ExplicitWait(loginSignUp, driver);
		driver.findElement(loginSignUp).click();
		methods.ExplicitWait(googleLogo, driver);
		driver.findElement(googleLogo).click();
		Set<String> childWindows=driver.getWindowHandles();
		for(String handle:childWindows)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				methods.ExplicitWait(emailField, driver);
				driver.findElement(emailField).sendKeys("bdewjnd a");
				driver.findElement(emailField).sendKeys(Keys.ENTER);
				methods.ExplicitWait(errorMsg, driver);
				String errorText=driver.findElement(errorMsg).getText();
				System.out.println("The Error Message is");
				System.out.println(errorText);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    String path = System.getProperty("user.dir") + "\\screenshot\\Error.png";
			    FileUtils.copyFile(scrFile, new File(path));
			}
		}
		driver.switchTo().window(parentWindow);
	}
}
