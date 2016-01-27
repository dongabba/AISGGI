package ru.fors.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.fors.utils.PropertyLoader;

public class Page {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebDriverWait wait1;

	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Long.parseLong(PropertyLoader.loadProperty("wait")));
		wait1 = new WebDriverWait(driver, 5);
	}

	public void checkElementBeforeAction(By element) {
		int count = 0;
		while (count < 5) {
			try {
				wait1.until(ExpectedConditions.elementToBeClickable(element));
				count = count + 5;
			} catch (Exception e) {
				count = count + 1;
			}
		}
	}

	public void type(By element, String string) {
		//checkElementBeforeAction(element);
		int i=0;
        while (i<5){
            try{
                driver.findElement(element).click();
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(string);
                break;
            } catch (Exception e){
                i=i+1;
            }
        }
	}

	public void click(By element) {
		checkElementBeforeAction(element);
        int i=0;
        while (i<5){
            try {
                driver.findElement(element).click();
                break;
            } catch (Exception e){
                i=i+1;
            }
        }
	}

	public void clickMenuElement(By element) {
		driver.findElement(element).click();
	}

	public String getElementText(By element) {
		return driver.findElement(element).getText();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void clickOn3Link(By element, By element1, By element2) {
		int count = 0;
		while (count < 5) {
			try {
				click(element);
				wait1.until(ExpectedConditions.elementToBeClickable(element1));
				clickMenuElement(element1);
				wait1.until(ExpectedConditions.elementToBeClickable(element2));
				clickMenuElement(element2);
				break;
			} catch (Exception e) {
				System.out.println("Count: " + count + " click exception");
				count = count + 1;
			}
		}
	}

	public void clickOn2Link(By element, By element1) {
		int count = 0;
		while (count < 5) {
			try {
				click(element);
				wait1.until(ExpectedConditions.elementToBeClickable(element1));
				clickMenuElement(element1);
				break;
			} catch (Exception e) {
				System.out.println("Count: " + count + " click exception");
				count = count + 1;
			}
		}
	}

	public void userSelectValue(By element, String value) {
		int count = 0;
		while (count < 5) {
			try {
				click(element);
				WebDriverWait wait1 = new WebDriverWait(driver, 5);
				wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class*='select2-focused']")));
				break;
			} catch (Exception e) {
				count = count + 1;
			}
		}
		type(By.cssSelector("input[class*='select2-focused']"), value);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span[class='select2-match']"), value));
		int count2 = 0;
		while (count2 < 5) {
			try {
				driver.findElement(By.cssSelector("input[class*='select2-focused']")).sendKeys(Keys.ENTER);
				wait1.until(ExpectedConditions.textToBePresentInElementLocated(element, value));
				break;
			} catch (Exception e) {
				count2 = count2 + 1;
			}
		}
	}

	public void mouseDoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}




}
