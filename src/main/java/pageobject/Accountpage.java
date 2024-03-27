package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	WebDriver driver;
public Accountpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(linkText="Edit your account information")
private WebElement edityouraccountinformation;

public boolean verifythedisplayofedityouraccountinformationoption() {
	boolean displayStatus  =false;
	
	try {
		displayStatus = edityouraccountinformation.isDisplayed();
		} catch(Throwable e) {
			 displayStatus = false;
		}
		return displayStatus;
		
}
}