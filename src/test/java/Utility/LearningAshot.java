package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LearningAshot {
	private static WebDriver driver;

/**
 * Takes Screenshot of window size
 * 1.Create object of AShot
 * 2.Define ShootingStrategy
 * 		a.shootingStrategy(ShootingStrategies.viewportPasting(2000))
 * 3.Now we will take screenshot using AShot of entire view port
 * 4.a.takeScreenshot(driver)
 * 5.Now save created image using ImageIO.write class of Java which has 3 parameters sc.getImage(),<File type>,<File Path>
 * @param @code AShot a
 * @param @code ScreenShot sc
 */
	public static void takeScreenShotWindowSize(AShot a, Screenshot sc) {
		Date d = new Date();
		try {
			ImageIO.write(sc.getImage(), "PNG", new File(
					"./ScreenShotImages/" + d.toString() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	This takes screenshot of entire webpage.
	public static void takeScreenShotEntireWebPage(AShot a, Screenshot sc) {
		Date d = new Date();
		sc = a.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		try {
			ImageIO.write(sc.getImage(), "JPG", new File(
					"./ScreenShotImages/" + d.toString() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.timesofindia.com");
		AShot a = new AShot();
		Screenshot sc = a.takeScreenshot(driver);
		takeScreenShotEntireWebPage(a, sc);
	}
}
