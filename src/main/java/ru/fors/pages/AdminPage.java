package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by gabba on 13.02.16.
 */
public class AdminPage extends MainMenu{
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    By helpInfoPageTitle = By.xpath("h3[text()='Справочная информация']");
    By table = By.xpath("//div[text()='внеплановых проверок']");

    public void waitForHelpInfoPageLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(helpInfoPageTitle));
    }

    public boolean isHelpPageFormed(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(table));
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
