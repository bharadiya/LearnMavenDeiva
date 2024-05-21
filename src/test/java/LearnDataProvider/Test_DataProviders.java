package LearnDataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.XLUtils;

public class Test_DataProviders {

	WebDriver driver = null;

	@Parameters({ "browserName", "url" })
	@BeforeTest
	public void openBrowser(@Optional("chrome") String browserName, String url) throws InterruptedException {
		chooseBrowser(browserName);
		driver.get(url);
	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		driver.close();
	}

	@Test(dataProvider = "shashank")
	public void doLogin(String uname, String pwd) throws InterruptedException {
		Test_PageObjects p = new Test_PageObjects(driver);
		p.setUserName(uname);
		p.setPassword(pwd);
		p.clickLoginBtn();
		Thread.sleep(3000);
		p.clickOptionMenuBtn();
		Thread.sleep(3000);
		p.clickLogoutBtn();
	}

	@DataProvider(name = "shashank")
	public Object[][] getDataFromExcelFile() throws IOException {
		XLUtils x = new XLUtils("./src\\test\\resources\\ConfigurationFiles\\Test.xlsx", "Sheet1");
		return x.fetchAllCellvalue();
	}

	public void chooseBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./src\\test\\resources\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("no such browser");
			break;
		}
	}
}
