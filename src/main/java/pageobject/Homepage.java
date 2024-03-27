package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	@FindBy(linkText ="Login")
	private WebElement loginoption;
	
public void clickonmyaccountdropmenu() {
	myAccountDropMenu.click();
	
}
public void clickonloginmethod() {
	loginoption.click();
}
}
