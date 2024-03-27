package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
WebDriver driver;
public Loginpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(id ="input-email")
private WebElement emailadddressfield;
@FindBy(id ="input-password")
private WebElement passwordfiled;
@FindBy(xpath ="//input[@value='Login']")
private WebElement loginbutton;

	

public void enteremailAddress(String emailtext) {
	emailadddressfield.sendKeys(emailtext);
}
public void enterpassword(String password) {
	passwordfiled.sendKeys(password);
}
public void clickonlogin()
{
	loginbutton.click();	
}

}