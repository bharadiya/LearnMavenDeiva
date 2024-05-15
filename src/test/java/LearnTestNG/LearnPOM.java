package LearnTestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import Utility.ReadConfig;
import Utility.XLUtils;

public class LearnPOM {
	@Test(enabled = false)
	public void testAutomationPracticeBlogspot() {
		System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ReadConfig rc = new ReadConfig("./src\\test\\resources\\ConfigurationFiles\\config.properties");
		driver.get(rc.getValue("baseurl"));

		HomePage hp = new HomePage(driver);
		hp.setName(rc.getValue("name"));
		hp.setEmail(rc.getValue("email"));
		String automationTitle = driver.getTitle();
		SoftAssert a = new SoftAssert();
		// Going to fail
		// a.assertEquals("automation Testing Practice", automationTitle);
		a.assertTrue(true);
		a.assertTrue(true);
		a.assertFalse(false);

		// Assert all would be last line of method or program
		// Assert all works like "AND" operation if even 1 assert is failing > it will
		// mark entire test as fail
		a.assertAll();

	}

	@Test
	public void readExcelData() throws IOException {
		String filePath = "C:\\Users\\poona\\eclipse-workspace\\LearnFrameworkWithMaven\\src\\test\\java\\ConfigurationFiles\\Test.xlsx";
		XLUtils x = new XLUtils(filePath, "Sheet1");
		int rows = x.rowCount();
		int column = x.coloumnCount();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				System.out.println(x.getSheetDAta(0, i, j));
			}
		}
	}
}
