package ru.fors.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String INTERNET_EXPLORER = "ie";
	
	public static WebDriver getInstance(Browser browser) {

		WebDriver webDriver = null;
		String browserName = browser.getName();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setJavascriptEnabled(true);


		if (CHROME.equals(browserName)) {
			webDriver = new ChromeDriver(capability);

		} else if (FIREFOX.equals(browserName)) {
			FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
			webDriver = new FirefoxDriver(profile);

		} else if (INTERNET_EXPLORER.equals(browserName)) {
			webDriver = new InternetExplorerDriver(capability);

		} return webDriver;
	}

}
