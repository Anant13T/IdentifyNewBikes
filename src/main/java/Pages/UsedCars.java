package Pages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.CommonMethods;

public class UsedCars 
{
	By usedCarsNav=By.xpath("//a[@data-track-label='used-cars']");
	By searchFilter=By.xpath("//input[@id='usedCarCity']");
	By city=By.xpath("//a[@class='ui-corner-all' and contains(text(),'Chennai')]");
	By cityLoading=By.xpath("//a[@href='https://www.zigwheels.com/used-car/Chennai' and @class='a']");
	By popular=By.xpath("//div[@class='zm-cmn-colorBlack ml-30 mob-nonclick div-h3 mt-20 mb-10']");
	By popularModelCars=By.xpath("//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]//child::li");
	
	WebDriver driver=null;
	CommonMethods methods=new CommonMethods();
	
	public UsedCars(WebDriver d)
	{
		driver=d;
	}
	
	public void usedCarCity()
	{
		driver.findElement(usedCarsNav).click();
		methods.ExplicitWait(searchFilter, driver);
		driver.findElement(searchFilter).clear();
		driver.findElement(searchFilter).sendKeys("Chennai");
		methods.ExplicitWait(city, driver);
		driver.findElement(city).click();
		methods.ExplicitWait(cityLoading, driver);
	}
	
	public void popular()
	{
		methods.ScrollDown(popular, driver);
		List<WebElement> carElementList=driver.findElements(popularModelCars);
		List<String> carNameList=new ArrayList<>();
		for(WebElement element:carElementList)
		{
			String text=element.getText();
			carNameList.add(text);
		}
		System.out.println(carNameList);
	}
	
}
