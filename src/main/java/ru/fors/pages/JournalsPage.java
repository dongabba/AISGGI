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
    By orderNumberSearchField = By.xpath("//div[contains(@class, 'span40')]/div[4]//a");

    By findButton = By.xpath("//button[text()='Искать']");
    By orderNumberInTable = By.xpath("//div[@class='table-wrap']//tbody//td[2]");
    By orderStatusInTable = By.xpath("//div[@class='table-wrap']//tbody//td[8]");

    public void waitForPageInstructionsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(instructionsJournalTitle));
    }

    public void userSetOrderNumber(String number){
        userSelectValue(orderNumberSearchField, number);
    }

    public void userClickFindButton(){
        click(findButton);
    }

    public String userGetFindOrderNumber(){
        return getElementText(orderNumberInTable);
    }

    public String userGetFindOrderStatus(){
        return getElementText(orderStatusInTable);
    }

    public void userSearchOrder(String number){
        userSetOrderNumber(number);
        userClickFindButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberInTable));
    }

    public OrderPage userOpenOrder(){
        mouseDoubleClick(driver.findElement(By.xpath("//div[@class='table-wrap']//tbody//td[2]")));
        return new OrderPage(driver);
    }
}
