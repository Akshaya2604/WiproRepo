package Helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenShot {
	WebDriver driver;
	public void getErrorScreenshot(WebDriver driver) {
		this.driver=driver;
		Date d = new Date();
		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		String time = dtf.format(d);
		System.out.println(time);

		File x = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File y = new File("src\\test\\java\\ScreenShots\\screen" + time + ".png");
		try {
			FileUtils.copyFile(x, y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
