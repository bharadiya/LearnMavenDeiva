package Utility;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GetScreenShotsAllMethods {
	AShot ashot = new AShot();
	Screenshot sc;
	Date d = new Date();
	public static WebDriver driver=null;
	
	public void getScreenShotWebElement() {
		sc = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")));
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./Screenshots/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getScreenShotWebElement(WebElement element) {
		sc = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, element);
		String dateinString = d.toString();
		dateinString = dateinString.replaceAll("\\s|\\:", "_");
		System.out.println(dateinString);
		try {
			ImageIO.write(sc.getImage(), "png", new File("./ScreenShotImages/" + dateinString + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getScreenShotWindowSize() {
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

	public void getScreenShotEntirePage() {
		sc = ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
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
