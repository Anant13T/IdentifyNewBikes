package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.CommonMethods;

public class HomePage 
{
	By searchBar=By.xpath("//input[@id='headerSearch']");
	By selectValue=By.xpath("//a[@data-track-label='did-you-mean-1']");
	By brands=By.xpath("//select[@id='makeId']");
	By bikeType=By.xpath("//li[@id='Cruiser']");
	By bikeList=By.xpath("//li[@data-body-type='Cruiser']");
	
	public static WebDriver driver=null;
	CommonMethods methods=new CommonMethods();
	
	public HomePage(WebDriver d)
	{
		driver=d;
	}
	
	public void upComingBikes()
	{
		methods.ImplicitWait(driver);
		driver.findElement(searchBar).sendKeys("Upcoming Bikes");
		driver.findElement(searchBar).sendKeys(Keys.ENTER);
		methods.ExplicitWait(selectValue, driver);
		driver.findElement(selectValue).click();
		methods.ExplicitWait(brands, driver);
		Select brandName=new Select(driver.findElement(brands));
		brandName.selectByVisibleText("Honda");
		methods.ExplicitWait(bikeType, driver);
		driver.findElement(bikeType).click();
	}
	
	public void bikeDetails() throws IOException
	{
		List<WebElement> availableBikeElements=driver.findElements(bikeList);
		List<String> bikeDetailsList=new ArrayList<>();
		for(WebElement element:availableBikeElements)
		{
			String text=element.getText().replace("Alert Me When Launched","");
			bikeDetailsList.add(text);
		}
		System.out.println("Bike Details are");
		System.out.println(bikeDetailsList);
		methods.storeInExcel("sheet1", bikeDetailsList);
	}
	
}
