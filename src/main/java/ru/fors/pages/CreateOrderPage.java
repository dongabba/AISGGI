package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 20.01.2016.
 */
public class CreateOrderPage extends Page{

    public CreateOrderPage(WebDriver driver) {
        super(driver);
    }

    By data = By.name("date:date"); //дата документа
    By signedBy = By.xpath("//span[contains(@id, 'signedBy')]//a"); //должностное лицо
    By orderReason = By.cssSelector("select[name='instruction:foundation']"); //основание распоряжения
    By against = By.xpath("//span[contains(@id, 'signedBy')]//a"); //в отношении
    By checkTarget = By.cssSelector("select[name='instruction:checkTarget']"); //цель проверки
    By checkTasks = By.cssSelector("textarea[name='instruction:checkTasks:joinedValues']"); //задачи проверки
    By calculateTermButton = By.cssSelector("button[id*='calculateTerm']");
    By jurDocs = By.linkText("Правовые основания проведения проверки:"); //Правовые основания проведения проверки
    By jurAct = By.cssSelector("input[name*='repeater:16']"); //Гражданский Кодекс Российской Федерации
    By admReglament = By.cssSelector("input[name='instruction:checkReglament']"); //Административные регламенты
    By checkMethod = By.cssSelector("select[name='instruction:checkMethod']"); //проверка проведена
    By preparerField = By.xpath("//span[contains(@id, 'preparer')]//a"); //Исполнитель
    By checkAddressLink = By.linkText("Адреса проверки"); //Адреса проверки
    By checkAddressField = By.xpath("//div[contains(@id, 'id_address')]/a"); //поле для выбора адресов проверки
    By saveButton = By.linkText("Сохранить"); //сохранить распоряжение







    public void userSelectValue(By element, String value){
            click(element);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select2-input")));
            click(By.cssSelector(".select2-input"));
            type(By.cssSelector(".select2-input"), value);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select2-result-label")));
            click(By.cssSelector(".select2-result-label"));
            wait.until(ExpectedConditions.textToBePresentInElementValue(element, value));
    }
    @Step("Устанавливаем значение поля \"Правовые основания проведения проверки\" = Гражданский Кодекс Российской Федерации")
    public void userSetJurDocs(){
        click(jurDocs);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Нормативные акты']")));
        click(jurAct);
        click(By.cssSelector("button[name='ok']"));
    }
    @Step("Переходим на вкладку \"Адреса проверки\"")
    public void userGotoCheckAddress(){
        click(checkAddressLink);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Адреса проверки']")));
    }
    @Step("Устанавливаем дату распоряжния")
    public void userSetDate(String date){
        type(data, date);
    }

    @Step("Выбираем должностное лицо")
    public void userSetSignedBy(String user){
        userSelectValue(signedBy, user);
    }

    @Step("Устанавливаем значение поля \"Основание распоряжения\" = Ежегодный план проведения плановых проверок")
    public void userSetOrderReason(){
        Select select = new Select(driver.findElement(orderReason));
        select.deselectAll();
        select.selectByIndex(0);
    }

    @Step("Выбираем юридическое лицо")
    public void userSetAgainst (String userAgainst){
        userSelectValue(against, userAgainst);
    }

    @Step("Устанавливаем значение поля \"Цель проведения проверки\" = План проведения плановых проверок юридических лиц и индивидуальных предпринимателей ГЖИ")
    public void userSetCheckTarget(){
        Select select = new Select(driver.findElement(checkTarget));
        select.deselectAll();
        select.selectByIndex(1);
    }

    @Step("Указываем задачи проверки")
    public void userSetCheckTasks(){
        type(checkTasks, "Проверка задач_АТ");
    }

    @Step("Нажимаем кнопку \"Расчитать\"")
    public void userClickCalculateTermButton(){
        click(calculateTermButton);
    }

    @Step("Выбираем административные регламенты")
    public void userSetAdmReglament(){
        click(admReglament);
    }

    @Step("Устанавливаем значение поля \"Проверка проведена\" = Индивидуально")
    public void userSetCheckMethod(){
        Select select = new Select(driver.findElement(checkMethod));
        select.deselectAll();
        select.selectByIndex(0);
    }

    @Step("Выбираем исполнителя")
    public void userSetPreparer(String preparer){
        userSelectValue(preparerField, preparer);
    }

    @Step("Выбираем адрес проверки")
    public void userSetCheckAdress (String address){
        userSelectValue(checkAddressField, address);
    }

    @Step("Сохраняем распоряжение")
    public void userSaveOrder (){
        click(saveButton);
    }
    @Step("Создаем распоряжение")
    public void userCreateOrderP(String date, String user, String userAgainst, String preparer, String address){
        userSetDate(date);
        userSetSignedBy(user);
        userSetOrderReason();
        userSetAgainst(userAgainst);
        userSetCheckTarget();
        userSetCheckTasks();
        userClickCalculateTermButton();
        userSetJurDocs();
        userSetAdmReglament();
        userSetCheckMethod();
        userSetPreparer(preparer);
        userGotoCheckAddress();
        userSetCheckAdress(address);
        userSaveOrder();
    }
}
