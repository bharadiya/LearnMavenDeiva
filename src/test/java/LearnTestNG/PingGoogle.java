package LearnTestNG;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utility.GetScreenShotsAllMethods;
import Utility.LearningAshot;
import Utility.ReadConfig;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class PingGoogle {
	@Test
	public void pingGoogle() {
		System.setProperty("webdriver.chrome.driver", "./src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		ReadConfig rc = new ReadConfig("./src\\test\\resources\\ConfigurationFiles\\config.properties");
		driver.get(rc.getValue("baseurl"));
		
		AShot ashot = new AShot();
		Screenshot sc;
		Date d = new Date();
		sc = ashot.takeScreenshot(driver);
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./ScreenShotImages/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
