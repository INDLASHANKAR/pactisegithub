package base1;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base11 {
	public Properties prop;
	public WebDriver openBrowserAndApplicationURL(String browserName) {
		 prop = new Properties();
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources1\\data.properties");
		try {
		FileInputStream fis  = new FileInputStream(file);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	WebDriver driver = null ;
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		 if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

}
