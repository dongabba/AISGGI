package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;


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
    By startCheckHours = By.cssSelector("input[name=\"inspectionInfo:checkDuration:container:checkDates:0:from:hours\"]");
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
    By dateTransfer = By.cssSelector("input[name=\"transferInformation:actCopyHandedPersonsTable:actCopyHandedPersons:0:date:date\"]");
    By saveActButton = By.linkText("Сохранить");
    By deleteActButton = By.linkText("Удалить");
    By secondViolationRow = By.xpath("//div[@id='tab5']//table//tbody//tr[2]");
    By createDocLink = By.linkText("Создать документ");
    By prescriptionLink = By.linkText("Предписание");
    By oneDocPrescription = By.xpath("//form[@class='modal-form']//div[@class='find-block_content']/div[1]//input");



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
        DatePicker dp = new DatePicker(driver);
        dp.userSetDate(By.xpath("//form/div[@class='act-panel']//div[@class='act-panel__line clearfix'][4]//img"), By.className("calheader"), By.className("calnavright"), By.className("calnavleft"), By.cssSelector(".calbody"), date);

    }

    public void userSetDocHour(String hours) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(hourDoc, "0"));
        type(hourDoc, hours);
        Thread.sleep(3000);

    }

    public void userSetDocMinutes(String minutes) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(minDoc, "0"));
        type(minDoc, minutes);
        Thread.sleep(3000);

    }

    public void userSetStartCheckDate(String date) throws InterruptedException {
        DatePicker dp = new DatePicker(driver);
        dp.userSetDate(By.xpath("//div[@id='tab2']//div[@class='act-panel']//td[1]//img"), By.xpath("//div[@id='tab2']//td[1]//div[@class='calheader']"), By.className("//div[@id='tab2']//td[1]//div[@class='calnavright']"), By.className("//div[@id='tab2']//td[1]//div[@class='calnavleft']"), By.xpath(".//div[@id='tab2']//div[@class='act-panel']//td[1]//tbody"), date);
    }

    public void userSetStartCheckHours(String hours) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(startCheckHours, "0"));
        type(startCheckHours, hours);
        Thread.sleep(3000);
    }

    public void userSetStartCheckMinutes(String minutes) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(startCheckMinutes, "0"));
        type(startCheckMinutes, minutes);
        Thread.sleep(3000);
    }

    public void userSetFinishCheckDate(String date){
        DatePicker dp = new DatePicker(driver);
        dp.userSetDate(By.xpath("//div[@id='tab2']//div[@class='act-panel']//td[2]//img"), By.xpath("//div[@id='tab2']//td[2]//div[@class='calheader']"), By.xpath("//div[@id='tab2']//td[2]//div[@class='calnavright']"), By.className("//div[@id='tab2']//td[2]//div[@class='calnavleft']"), By.xpath("//div[@id='tab2']//div[@class='act-panel']//td[2]//tbody"), date);
    }

    public void userSetFinishCheckHours(String hours) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(finishCheckHours, "0"));
        type(finishCheckHours, hours);
        Thread.sleep(3000);

    }

    public void userSetFinishCheckMinutes (String minutes) throws InterruptedException {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(finishCheckMinutes, "0"));
        type(finishCheckMinutes, minutes);
        Thread.sleep(3000);
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

    public void addSubject(String name){
        NsiForms nsiForms = new NsiForms(driver);
        nsiForms.userSelectSubject(name);
    }

    public void addSubject2(String name){
        NsiForms nsiForms = new NsiForms(driver);
        nsiForms.userGoToEasySearchTab();
        nsiForms.userSelectSubject(name);
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
                           String name) throws InterruptedException {
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
        userClickAddSubjectButton();
        addSubject(name);
        userSetTransferDate(docDate);
        userSaveAct();
    }

    public PrescriptionPage userClickAddPrescriptionOneDocLink(){
        clickOn2Link(createDocLink, prescriptionLink);
        wait.until(ExpectedConditions.presenceOfElementLocated(oneDocPrescription));
        click(oneDocPrescription);
        click(saveViolationButton);
        return new PrescriptionPage(driver);
    }

    public void waitForActCheckOrder2PageOpen(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Акт проверки исполнения предписания']")));
    }

    @Step("Пользователь создает акт проверки исполнения предписания")
    public void userAddActChekOrder2(String name){
        addSubject2(name);
    }
}
