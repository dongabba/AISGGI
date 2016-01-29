package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 28.01.2016.
 */
public class PrescriptionPage extends Page{
    public PrescriptionPage(WebDriver driver) {
        super(driver);
    }
    By pageTitle = By.xpath("//h3[text()='Предписание']");
    By selectFunctionary = By.linkText("Выбрать");
    By editViolationEvent = By.cssSelector("a[title='Редактировать']");
    By violationEventWindowTitle = By.xpath("//h3[text()='Добавление/редактирование мероприятия']");
    By violationEventTextBox = By.cssSelector("textarea[name='content:actionWorks']");
    By executionDate = By.cssSelector("input[name=\"content:executionDate:date\"]");
    By saveViolationEventButton = By.xpath("//span[text()='Сохранить']");
    By deletePrescriptionButton = By.linkText("Удалить");
    By savePrescriptionButton = By.linkText("Сохранить");
    By createDocButton = By.linkText("Создать документ");
    By createOrder2Button = By.linkText("Распоряжение");


    @Step("Ожидаем открытия страницы создания предписания")
    public void waitForPrescriptionPageLoaded(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
    }

    @Step("Открываем окно выбора должностного лица")
    public void userClickSelectButton(){
        click(selectFunctionary);
    }

    @Step("Создаем предписание")
    public boolean userCreatePrescription(String name, String date){
        userClickSelectButton();
        userAddFunctionary(name);
        userEditEvent(date);
        return userSavePrescription();
    }

    @Step("Открываем окно \"Добавление/редактирование мероприятия\"")
    public void userOpenViolationEventWindow(){
        click(editViolationEvent);
        wait.until(ExpectedConditions.presenceOfElementLocated(violationEventWindowTitle));
    }

    @Step("Указываем предписанные мероприятия")
    public void userSetActionWorks(){
        click(violationEventTextBox);
        type(violationEventTextBox, "Исправить нарушения");
    }

    @Step("Указываем дату исполнения")
    public void userSetExecutionDate(String date){
        click(executionDate);
        type(executionDate, date);
    }

    @Step("Сохраняем мероприятие")
    public void userSaveEvent(){
        click(saveViolationEventButton);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(violationEventWindowTitle));
    }

    @Step("Выбираем должностное лицо")
    public void userAddFunctionary(String name){
        NsiForms nsiForms = new NsiForms(driver);
        nsiForms.userSelectSubject(name);
    }

    @Step("Сохраняем предписание")
    public boolean userSavePrescription(){
        try{
            click(savePrescriptionButton);
            wait.until(ExpectedConditions.presenceOfElementLocated(deletePrescriptionButton));
            return true;
        } catch (Exception e){
            return false;
        }

    }

    @Step("Редактируем мероприятие")
    public void userEditEvent(String date){
        userOpenViolationEventWindow();
        userSetActionWorks();
        userSetExecutionDate(date);
        userSaveEvent();
    }

    @Step("Переходим на страницу создания распоряжения о проверке исполнения предписания")
    public OrderPage userClickCreateOrder2Button(){
        clickOn2Link(createDocButton, createOrder2Button);
        return new OrderPage(driver);
    }


}

