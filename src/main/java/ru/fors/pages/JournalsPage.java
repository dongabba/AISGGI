package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Alexander Zhaleyko on 22.01.2016.
 */
public class JournalsPage extends Page{

    public JournalsPage(WebDriver driver) {
        super(driver);
    }
    //=======Инспекционные журналы========
    By instructionsJournalTitle = By.xpath("//h3[text()='Распоряжения']");
    By orderNumberSearchField = By.xpath("//div[contains(@id, 'id_number')]/a");

    public void waitForPageInstructionsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(instructionsJournalTitle));
    }

    public void userSetOrderNumber(String number){
        userSelectValue(orderNumberSearchField, number);
    }
}
