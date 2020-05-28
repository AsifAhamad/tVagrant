package tVagrant.com.tVagrant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.GoodreadsPage;

public class LandingPageValidation extends Base {	
	
	public GoodreadsPage gp;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		System.out.println("driver=" + driver);
		driver.get(prop.getProperty("url"));
		gp = new GoodreadsPage(driver);
	}

	@Test
	public void LoginPageUIValidation() throws IOException, InterruptedException {
		
		// Verifying the login page UI
		gp.loginToAccount(prop.getProperty("userId"),prop.getProperty("password"));
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}