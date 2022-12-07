package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	private WebDriver driver;

	public WebDriver WebDriverManager() {

		FileInputStream fis = null;
		Properties props = new Properties();

		try {
			fis = new FileInputStream("src/test/resources/global.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			props.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver == null) {
			if (props.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}
			if (props.getProperty("browser").equalsIgnoreCase("firefox")) {
				// firefox code
			}
			driver.get(props.getProperty("qa-url"));
		}
		return driver;
	}

}
