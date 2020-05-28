package tVagrant.com.tVagrant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.GoodreadsPage;
import pageObjects.GoodreadsSearchResultsPage;
import pageObjects.GoodreadsUserAccountMainPage;

public class FindaBook extends Base {

	public GoodreadsPage grLandingPage;
	public GoodreadsUserAccountMainPage grMain;
	public GoodreadsSearchResultsPage grSResults;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		System.out.println("driver=" + driver);
		driver.get(prop.getProperty("url"));

		grLandingPage = new GoodreadsPage(driver);
		grMain = new GoodreadsUserAccountMainPage(driver);
		grSResults = new GoodreadsSearchResultsPage(driver);
	}

	@Test
	public void WhatsThatBookName() throws Exception {

		// Login on Landing page
		grLandingPage.loginToAccount(prop.getProperty("userId"),prop.getProperty("password"));

		System.out.println("=================== Finding a Book ======================");

		System.out.println("\nBook details known (Go to resources -> data.properties to modify the input) \n"+prop.getProperty("bookHint"));

		//Searching for a book using the given hint
		grMain.searchBook(prop.getProperty("bookHint"));

		try {
			
			String urlToShare = grSResults.firstResult.getAttribute("href");

			String Title = grSResults.firstResult.getText();

			System.out.println("\nI guess the book title is "+"\""+Title+"\"");

			System.out.println("\nBook is avilable at \n"+urlToShare+"\n");
		}
		catch(Exception e)
		{
			System.out.println("\nNo Book is available with the details provided \n");
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}