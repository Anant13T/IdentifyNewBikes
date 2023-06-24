package Utility;


import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class CommonMethods 
{	
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void ExplicitWait(By object,WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(object));
	}
	
	public void ScrollDown(By object,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement toScrollTill=driver.findElement(object);
		js.executeScript("arguments[0].scrollIntoView();",toScrollTill);
	}
	
	public void ScrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,0)");
	}
	
	public void storeInExcel(String sheetName,List<String> l1) throws IOException
	{
		Excel e1=new Excel();
		e1.putData(sheetName, l1);
	}
	
}
