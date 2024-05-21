package LearnDataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Test_PageObjects {
	WebDriver driver;

	public Test_PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='user-name']")
	WebElement username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@id='login-button']")
	WebElement loginBtn;

	@FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
	WebElement menuOption;

	@FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']")
	WebElement logOutBtn;

	public void setUserName(String uname) {
		username.clear();
		username.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}

	public void clickOptionMenuBtn() {
		menuOption.click();
	}

	public void clickLogoutBtn() {
		logOutBtn.click();
	}
}
