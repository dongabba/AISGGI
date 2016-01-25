package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Random;

/**
 * Created by Alexander Zhaleyko on 20.01.2016.
 */
public class OrderPage extends Page{

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    Random random = new Random();
    String orderNumb;
    By pageTitle = By.xpath("//h3[text()='Распоряжение']");
    By data = By.name("date:date"); //дата документа
    By fullN = By.cssSelector("input[name='number:fullNum.num']");
    By signedBy = By.xpath("//form/div[@class='act-panel']/div[4]//a"); //должностное лицо
    By orderReason = By.cssSelector("select[name='instruction:foundation']"); //основание распоряжения
    By against = By.xpath("//div[@id='tab1']//div[@class='act-panel']/div[3]//a"); //в отношении
    By checkTarget = By.cssSelector("select[name='instruction:checkTarget']"); //цель проверки
    By checkTasks = By.cssSelector("textarea[name='instruction:checkTasks:joinedValues']"); //задачи проверки
    By checkStartDate = By.cssSelector("input[name*=\"checkStart:date\"]");
    By calculateTermButton = By.xpath("//button[text()='Рассчитать']");
    By jurDocs = By.linkText("Правовые основания проведения проверки:"); //Правовые основания проведения проверки
    By jurAct = By.cssSelector("input[name*='repeater:16']"); //Гражданский Кодекс Российской Федерации
    By admReglament = By.cssSelector("input[name='instruction:checkReglament']"); //Административные регламенты
    By checkMethod = By.cssSelector("select[name='instruction:checkMethod']"); //проверка проведена
    By preparerField = By.xpath("//div[@id='tab1']//div[@class='act-panel']/div[19]//a"); //Исполнитель
    By checkAddressLink = By.linkText("Адреса проверки"); //Адреса проверки
    By checkAddressField = By.xpath("//div[@id='tab2']//div[@class='act-panel__line clearfix'][2]//a"); //поле для выбора адресов проверки
    By saveButton = By.linkText("Сохранить"); //сохранить распоряжение
    By deleteOrderButton = By.linkText("Удалить"); //удалить распоряжение
    By transfToWorkButton = By.linkText("Передать в работу"); //передать в работу
    By returnOrderButton = By.linkText("Вернуть на доработку"); //Вернуть на доработку
    By closeOrderButton = By.linkText("Возврат в список");
    By createDocButton = By.linkText("Создать документ");

    //===================================
    By createActButton = By.linkText("Акт проверки");

    public void waitForOrderPageLoaded(){
        wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
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
        select.selectByIndex(1);
    }

    @Step("Выбираем юридическое лицо")
    public void userSetAgainst (String userAgainst){
        userSelectValue(against, userAgainst);
    }

    @Step("Устанавливаем значение поля \"Цель проведения проверки\" = План проведения плановых проверок юридических лиц и индивидуальных предпринимателей ГЖИ")
    public void userSetCheckTarget(){
        Select select = new Select(driver.findElement(checkTarget));
        select.selectByIndex(1);
    }

    @Step("Указываем задачи проверки")
    public void userSetCheckTasks(){
        type(checkTasks, "Проверка задач_АТ");
    }

    public void userSetCheckStartDate(String date){
        type(checkStartDate, date);
    }
    @Step("Нажимаем кнопку \"Расчитать\"")
    public void userClickCalculateTermButton(){
        click(calculateTermButton);
    }

    @Step("Выбираем административные регламенты")
    public void userSetAdmReglament(){
        int i=0;
        while (i<5){
            try{
                click(admReglament);
                break;
            }catch (Exception e){
                i=i+1;
            }
        }

    }

    @Step("Устанавливаем значение поля \"Проверка проведена\" = Индивидуально")
    public void userSetCheckMethod(){
        Select select = new Select(driver.findElement(checkMethod));
        select.selectByIndex(1);
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
    public String userCreateOrderP(String date, String user, String userAgainst, String preparer, String address){
        String fullNumb = String.valueOf(random.nextInt(99999));
        orderNumb = "39ОГ-"+fullNumb+"-1-9-2016";
        userSetDate(date);
        type(fullN, fullNumb);
        userSetSignedBy(user);
        userSetOrderReason();
        userSetAgainst(userAgainst);
        userSetCheckTarget();
        userSetCheckTasks();
        userSetCheckStartDate(date);
        userClickCalculateTermButton();
        userSetJurDocs();
        userSetAdmReglament();
        userSetCheckMethod();
        userSetPreparer(preparer);
        userGotoCheckAddress();
        userSetCheckAdress(address);
        userSaveOrder();
        return orderNumb;
    }

    public boolean isOrderCreated(){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(deleteOrderButton));
            return true;
        } catch (Exception e){
            return false;
        }
    }
    @Step("Выходим на главную страницу")
    public MainPage userGoToMainPage (){
        click(closeOrderButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Обратите внимание']")));
        return new MainPage(driver);
    }

    public void userChangeOrderStatusToTransfToWork(){
        click(transfToWorkButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(returnOrderButton));
    }

    public JournalsPage userCloseOrder(){
        click(closeOrderButton);
        return new JournalsPage(driver);
    }

    public ActPage userClickCreateActButton(){
        clickOn2Link(createDocButton, createActButton);
        return new ActPage(driver);
    }
}
