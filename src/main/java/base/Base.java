package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public Properties prop;
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();

		// Getting the project directory and adding the path to .properties file
		String path = System.getProperty("user.dir") + "\\resources\\data.properties";

		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);

		// Accessing browser name from properties file
		String browserName = prop.getProperty("browser");

		// Invoking the specified WebDriver
		if (browserName.equalsIgnoreCase("Chrome")) {
			// Invoke Chrome Webdriver
			if (prop.getProperty("chromeVersion").isEmpty()) {
				WebDriverManager.chromedriver().setup();
			} else {
				WebDriverManager.chromedriver().version(prop.getProperty("chromeVersion")).setup();
			}

			ChromeOptions options = new ChromeOptions();
			// options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options);
		} 
		else if (browserName.equalsIgnoreCase("Edge")) // Edge Browser
		{
			// Invoke Edge Webdriver

			if (prop.getProperty("edgeVersion").isEmpty()) {
				WebDriverManager.edgedriver().setup();
			} else {
				// System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
				// "\\resources\\msedgedriver.exe");
				WebDriverManager.edgedriver().version(prop.getProperty("edgeVersion")).setup();
			}
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) // Firefox Browser
		{
			// Invoke Firefox Webdriver
			if (prop.getProperty("firefoxVersion").isEmpty()) {
				WebDriverManager.firefoxdriver().setup();
			} else {
				WebDriverManager.firefoxdriver().version(prop.getProperty("firefoxVersion")).setup();
			}
			
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please select a valid WebDriver");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}

}
