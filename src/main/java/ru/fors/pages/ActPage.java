package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by gabba on 22.01.16.
 */
public class ActPage extends Page {
    public ActPage(WebDriver driver) {
        super(driver);
    }

    By pageTitle = By.xpath("//h3[text()='Акт проверки']");
    By checkInfoTab = By.linkText("Информация о проведении проверки");
    By violationTab = By.linkText("Нарушения");
    By dateDoc = By.cssSelector("input[name=\"date:date\"]");
    By hourDoc = By.cssSelector("input[name=\"date:hours\"]");
    By minDoc = By.cssSelector("input[name=\"date:minutes\"]");
    By startCheckDate = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:from:date\" ]");
    By startCheckHours = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:from:hours]");
    By startCheckMinutes = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:from:minutes\"]");
    By finishCheckDate = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:to:date\"]");
    By finishCheckHours = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:to:hours\"]");
    By finishCheckMinutes = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:to:minutes\"]");
    By addViolationButton = By.xpath("//div[@id='tab5']//a[@title='Добавить']");
    By addViolationPageTitle = By.xpath("//h3[text()='Добавление нарушения']");
    By violationName = By.xpath("//form[@class='modal-form']//div[@class='find-block_content']/div[1]/div[3]//a");
    By violationArticle = By.xpath("//form[@class='modal-form']//div[@class='find-block_content']/div[1]/div[5]//span[4]//a");
    By saveViolationButton = By.cssSelector("button[name='ok']");
    By infoAboutTransferToSubTab = By.linkText("Информация о передаче акта субъекту");
    By addSubjectButton = By.xpath("//div[@id='tab7']//a[@title='Добавить']");
    By addSubjectWindowTitle = By.xpath("//h3[text()='Поиск физических лиц']");
    By subjectName = By.cssSelector("input[name=\"content:form:searchConditionPanel:searchConditionForm:searchConditionTabs:panel:fio\"]");
    By findSubjectButton = By.linkText("Искать");
    By firstSearchResultInAddSubjectWindow = By.xpath("//div[@class='nsi-result-find']//td[2]");
    By selectButton = By.linkText("Выбрать");
    By dateTransfer = By.cssSelector("input[name=\"transferInformation:actCopyHandedPersonsTable:actCopyHandedPersons:0:date:date]");
    By saveActButton = By.linkText("Сохранить");
    By deleteActButton = By.linkText("Удалить");
    By secondViolationRow = By.xpath("//div[@id='tab5']//table//tbody//tr[2]");



    public void waitForActPageLoaded(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
    }

    public void userOpenCheckInfoTabs(){
        click(checkInfoTab);
        waitForCheckInfoTabsOpen();
    }

    public void userOpenViolationTab(){
        click(violationTab);
        waitForViolationTabOpen();
    }

    private void waitForViolationTabOpen() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addViolationButton));
    }

    public void waitForCheckInfoTabsOpen(){
        wait.until(ExpectedConditions.presenceOfElementLocated(startCheckDate));
    }

    public void userSetDocDate(String date){
        type(dateDoc, date);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(dateDoc, date));
        driver.findElement(dateDoc).sendKeys(Keys.ENTER);
    }

    public void userSetDocHour(String hours){
        type(hourDoc, hours);
        driver.findElement(hourDoc).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(hourDoc, hours));
    }

    public void userSetDocMinutes(String minutes){
        type(minDoc, minutes);
        driver.findElement(minDoc).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(minDoc, minutes));
    }

    public void userSetStartCheckDate(String date){
        type(startCheckDate, date);
        driver.findElement(startCheckDate).sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(startCheckDate, date));
    }

    public void userSetStartCheckHours(String hours){
        type(startCheckHours, hours);
        driver.findElement(startCheckHours).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(startCheckHours, hours));
    }

    public void userSetStartCheckMinutes(String minutes){
        type(startCheckMinutes, minutes);
        driver.findElement(startCheckMinutes).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(startCheckMinutes, minutes));
    }

    public void userSetFinishCheckDate(String date){
        type(finishCheckDate, date);
        driver.findElement(finishCheckDate).sendKeys(Keys.ENTER);
        //wait.until(ExpectedConditions.textToBePresentInElementLocated(finishCheckDate, date));
    }

    public void userSetFinishCheckHours(String hours){
        type(finishCheckHours, hours);
        driver.findElement(finishCheckHours).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(finishCheckHours, hours));
    }

    public void userSetFinishCheckMinutes (String minutes){
        type(finishCheckMinutes, minutes);
        driver.findElement(finishCheckMinutes).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(finishCheckMinutes, minutes));
    }

    public void userClickAddViolationButton(){
        click(addViolationButton);
    }

    public void userSelectViolationName(String violation){
        userSelectValue(violationName, violation);
    }

    public void userSelectViolationArticle(String article){
        userSelectValue(violationArticle, article);
    }

    public void userSaveViolation(){
        click(saveViolationButton);
    }

    public void userAddViolation(String violation, String article){
        userClickAddViolationButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(addViolationPageTitle));
        userSelectViolationName(violation);
        //userSelectViolationArticle(article);
        userSaveViolation();
        wait.until(ExpectedConditions.presenceOfElementLocated(secondViolationRow));
    }

    public void userClickInfoAboutTransferToSubTab(){
        click(infoAboutTransferToSubTab);
    }

    public void userGoToInfoAboutTransferToSubTab(){
        userClickInfoAboutTransferToSubTab();
        waitForInfoAboutTransferToSubTabOpen();
    }

    private void waitForInfoAboutTransferToSubTabOpen() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addSubjectButton));
    }

    public void userClickAddSubjectButton(){
        click(addSubjectButton);
    }

    public void userSelectSubject(String name){
        userClickAddSubjectButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(addSubjectWindowTitle));
        type(subjectName, name);
        click(findSubjectButton);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(firstSearchResultInAddSubjectWindow, name));
        click(firstSearchResultInAddSubjectWindow);
        click(selectButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(dateTransfer));
    }

    public void userSetTransferDate(String date){
        click(dateTransfer);
        type(dateTransfer, date);
    }

    public void userClickSaveActButton(){
        click(saveActButton);
    }
    public void userSaveAct(){
        userClickSaveActButton();
        wait.until(ExpectedConditions.presenceOfElementLocated(deleteActButton));
    }

    public void userAddAct(String docDate,
                           String docHours,
                           String docMinutes,
                           String startDate,
                           String startHours,
                           String startMinutes,
                           String finishDate,
                           String finishHours,
                           String finishMinutes,
                           String violation,
                           String article,
                           String name){
        waitForActPageLoaded();
        userSetDocDate(docDate);
        //userSetDocHour(docHours);
        //userSetDocMinutes(docMinutes);
        userOpenCheckInfoTabs();
        userSetStartCheckDate(startDate);
        //userSetStartCheckHours(startHours);
        //userSetStartCheckMinutes(startMinutes);
        userSetFinishCheckDate(finishDate);
        //userSetFinishCheckHours(finishHours);
        //userSetFinishCheckMinutes(finishMinutes);
        userOpenViolationTab();
        userAddViolation(violation, article);
        userGoToInfoAboutTransferToSubTab();
        userSelectSubject(name);
        userSetTransferDate(docDate);
        userSaveAct();

    }
}
