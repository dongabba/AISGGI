package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class DocsSearchPage extends MainMenu {
    public DocsSearchPage(WebDriver driver) {
        super(driver);
    }

    By docsSearchPageTitle = By.xpath("//h3[text()='Документы инспекционной деятельности']");
    By searchButton = By.xpath("//button[text()='Искать']");
    By resultsTable = By.xpath("//*[@class='table-wrap']//tbody/tr[1]");
    By documentTypeSelect = By.cssSelector("select[name='documentType']");
    By createdDocFrom = By.cssSelector("input[name='created:from:date']");
    By lastUpdateDoc = By.cssSelector("input[name='updated:from:date']");

    public void waitForDocsSearchPageLoaded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(docsSearchPageTitle));
    }

    public void userFormedPage(){
        click(searchButton);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isPageDocsSearchFormed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void userSetDocType(String docType){
        Select select = new Select(driver.findElement(documentTypeSelect));
        select.selectByValue(docType);

    }
    @Step("Пользователь устанавливает значение поля тип документа в значение \"Решение об отзыве предписания\"")
    public void userSetDocType(){
        userSetDocType("7");
    }

    @Step("Пользователь устанавливает дату документа в значение \"01.01.2015\"")
    public void userSetStartDocDate(){
        userSetDate(createdDocFrom, "01.01.2015");
    }

    @Step("Пользователь устанавливает дату последнего изменения документа в значение \"01.01.2015\"")
    public void userSetLastChangeDocDate(){
        userSetDate(lastUpdateDoc, "01.01.2015");
    }

    public void userFormedPageWithConditions(){
        userSetDocType();
        userSetStartDocDate();
        userSetLastChangeDocDate();
        userFormedPage();
    }
}
