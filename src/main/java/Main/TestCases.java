package Main;

import Utility.*;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UsedCars;

public class TestCases 
{
	WebDriver driver=null;
	
	
	@BeforeClass
	@Parameters("browser")
	public void driverSetUp(String browser)
	{	
		DriverSetup ds=new DriverSetup();
		driver=ds.setUp(browser);
	}
	
	@Test(enabled=true)
	public void test1() throws IOException
	{
		HomePage hp=new HomePage(driver);
		hp.upComingBikes();
		hp.bikeDetails();
	}
	
	@Test(enabled=true,dependsOnMethods={"test1"})
	public void test2()
	{
		UsedCars uc=new UsedCars(driver);
		uc.usedCarCity();
		uc.popular();
	}
	
	@Test(enabled=true,dependsOnMethods={"test2"})
	public void test3() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.login();
	}
	
	@AfterClass
	public void closeDriver()
	{
		driver.navigate().to("https://www.zigwheels.com/");
		//System.out.println("Hi");
		driver.quit();
	}
}
