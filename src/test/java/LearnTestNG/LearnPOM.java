package LearnTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Utility.ReadConfig;

public class LearnPOM {
	@Test
	public void testAutomationPracticeBlogspot() {
		System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ReadConfig rc = new ReadConfig("./src\\test\\java\\ConfigurationFiles\\config.properties");
		driver.get(rc.getValue("baseurl"));
		
		HomePage hp= new HomePage(driver);
		hp.setName(rc.getValue("name"));
		hp.setEmail(rc.getValue("email"));
	}
}
