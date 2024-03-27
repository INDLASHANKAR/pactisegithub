package framework;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v120.fedcm.model.Account;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base1.Base11;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Accountpage;
import pageobject.Homepage;
import pageobject.Loginpage;
import util.DataUtil;
import util.MyXLSReader;

public class newlogin extends Base11 {
	WebDriver driver;
	MyXLSReader excelReader;
	
	@Test(dataProvider="supply")
public void login(HashMap<String,String> hMap) {
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "TestCases")||hMap.get("Runmode").equals("N")) {
			throw new SkipException("Run mode is set to N, hence not executed");
		}
	//WebDriverManager.chromedriver().setup();
	 //driver = new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver = openBrowserAndApplicationURL(hMap.get("Browser"));
	Homepage homepage = new Homepage(driver);
	homepage.clickonmyaccountdropmenu();
	homepage.clickonloginmethod();
	Loginpage login = new Loginpage(driver);
	login.enteremailAddress(hMap.get("username"));
	login.enterpassword("password");
	login.clickonlogin();
	Accountpage accountpage = new Accountpage(driver);
	
	driver.get(prop.getProperty("url"));
	
	String expectedResult = hMap.get("ExpectedResult");
	boolean expectedConvertedResults = false;
	if(expectedResult.equalsIgnoreCase("Success")) {
		expectedConvertedResults = true;
	}else if(expectedResult.equalsIgnoreCase("Failure")) {
		expectedConvertedResults =false;
	}
	boolean actualResult =false;
	
	 actualResult = accountpage.verifythedisplayofedityouraccountinformationoption();

	
	
	
	Assert.assertEquals(actualResult,expectedConvertedResults);
	//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	driver.quit();
	
}
	@DataProvider(name ="supply")
	public Object[][] datasupply()  {
		Object[][] data = null;
		try {
		excelReader = new MyXLSReader("src\\test\\resources1\\ninja.xlsx");
	
	 data= DataUtil.getTestData(excelReader,"LoginTest" , "Data");
		}catch(Exception e) {
			e.printStackTrace();
		
	}
	return data;
	}
	
}
