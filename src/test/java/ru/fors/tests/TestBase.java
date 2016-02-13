package ru.fors.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ru.fors.pages.LoginPage;
import ru.fors.pages.MainPage;
import ru.fors.utils.Browser;
import ru.fors.utils.PropertyLoader;
import ru.fors.utils.WebDriverFactory;

public class TestBase {
	
	protected static WebDriver driver;
	public String baseUrl;
	public String dir;

	DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
	Date startDate = new Date(System.currentTimeMillis()-604800000);
	Date finishDate = new Date(System.currentTimeMillis()-432000000);
	Date docDate = new Date(System.currentTimeMillis()-345600000);
	Date prescripDate = new Date(System.currentTimeMillis()-259200000);
	Date startOrder2Date = new Date(System.currentTimeMillis()-172800000);
	Date dateFrom = new Date(System.currentTimeMillis()-1296000000);
	Date dateTo = new Date(System.currentTimeMillis());

	@BeforeTest
	public void init(){
		baseUrl = PropertyLoader.loadProperty("site.url");
		dir = PropertyLoader.loadProperty("downloadDir");
		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		driver = WebDriverFactory.getInstance(browser, dir);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
	}
	
	

	@AfterTest
	public static void tearDown() {
		if (driver !=null) {
			driver.quit();
			driver = null;
		}
	}

	public void userLogin(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = loginPage.userLogin(username, password);
		mainPage.waitForPageLoaded();
	}
	
	public static WebDriver getWebDriver(){
		return driver;
	}
	
	
	

}
