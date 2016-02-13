package ru.fors.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
	
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String INTERNET_EXPLORER = "ie";
	private static WebDriver webDriver;
	
	public static WebDriver getInstance(Browser browser, String dir) {

		String browserName = browser.getName();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setJavascriptEnabled(true);

		if (CHROME.equals(browserName)) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", dir);
			prefs.put("download.prompt_for_dowload", false);
			options.addArguments("start-maximized");
			options.setExperimentalOption("prefs", prefs);
			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			webDriver = new ChromeDriver(capability);


		} else if (FIREFOX.equals(browserName)) {
			capability = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.dir", dir);
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/excel");
			profile.setPreference("browser.download.panel.shown", true);
			capability.setCapability(FirefoxDriver.PROFILE, profile);
			webDriver = new FirefoxDriver(capability);


		} else if (INTERNET_EXPLORER.equals(browserName)) {
			webDriver = new InternetExplorerDriver();

		}
		return webDriver;
	}

}
