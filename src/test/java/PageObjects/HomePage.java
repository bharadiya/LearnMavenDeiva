package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	static WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='name']")
	WebElement name;

	@FindBy(how = How.ID, using = "email")
	WebElement email;

	public void setName(String n) {
		name.sendKeys(n);
	}

	public void setEmail(String mailID) {
		email.sendKeys(mailID);
	}
	
	public boolean isNameDisplayed()
	{
		return name.isDisplayed();
	}
	
	public boolean isEmailDisplayed()
	{
		return email.isDisplayed();
	}
}
//- every particular webelement of that particular page will be placed inside this class
