package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.fors.utils.PropertyLoader;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

/**
 * Created by Alexander Zhaleyko on 01.03.2016.
 */
public class DocumentsPage extends Page {
    public DocumentsPage(WebDriver driver) {
        super(driver);
    }

    By prescriptionPageTitle = By.xpath("//h3[text()='Предписание']");
    By viewActsPageTitle = By.xpath("//h3[text()='Акт осмотра']");
    By monitoringActsPageTitle = By.xpath("//h3[text()='Акт мониторинга']");
    By actPageTitle = By.xpath("//h3[text()='Акт проверки']");
    By orderPageTitle = By.xpath("//h3[text()='Распоряжение']");
    By attachToActPageTitle = By.xpath("//h3[text()='Приложение к акту проверки']");
    By checkActPageTitle = By.xpath("//h3[text()='Акт проверки исполнения предписания']");
    By attachToCheckActPageTitle = By.xpath("//h3[text()='Приложение к акту проверки исполнения предписания']");
    By denyCriminalPageTitle = By.xpath("//h3[text()='Определение об отказе в возбуждении дела']");
    By revokePrescriptionPageTitle = By.xpath("//h3[text()='Решение об отзыве предписания']");

    By printDocumentButton = By.linkText("Печать");
    By printOrderButton = By.linkText("Распоряжения");
    By printViewActButton = By.linkText("Акта осмотра");
    By printMonitoringActButton = By.linkText("Акта мониторинга");
    By printActButton = By.linkText("Акта проверки");
    By printAttachToActButton = By.linkText("Приложения к акту проверки");
    By printCheckActButton = By.linkText("Акта проверки исполнения предписания");
    By printAttachToCheckActButton = By.linkText("Приложения к акту проверки исполнения предписания");
    By printPrescriptionButton = By.linkText("Предписания");
    By printDenyCriminalButton = By.linkText("Определение об отказе в возбуждении дела");
    By printRevokePrescriptionButton = By.linkText("Решение об отзыве предписания");

    By resultSearchField = By.xpath("//div[@class='table-wrap']//tbody/tr[1]/td[2]");
    By secondPage = By.linkText("2");
    By navigatorLabel = By.className("navigatorLabel");

    public void ensureOrderPageOpen(){
        wait.until(ExpectedConditions.presenceOfElementLocated(orderPageTitle));
    }

    public void userPrintDocument(By element){
        clickOn2Link(printDocumentButton, element);
    }
    @Step("Пользователь печатает распоряжение")
    public void userPrintOrder(){
        userPrintDocument(printOrderButton);
    }

    public boolean isDocumentPrint(String docName) throws InterruptedException {
        File file = new File(PropertyLoader.loadProperty("downloadDir"));
        //System.out.println("This is isReportFormed method. Search files in directory: "+PropertyLoader.loadProperty("downloadDir"));
        int count=0;
        for (int time = 0; time<118; time++) {
            File [] files = file.listFiles();
            //System.out.println("This is isReportFormed method: Total files in directory: " +files.length);
            for (int i = 0; i < files.length; i++) {
                File f1 = files[i];
                //System.out.println("This is isReportFormed method: File name: " + i+" " + f1.getName());
                if (f1.getName().startsWith(docName)) {
                    f1.delete();
                    count++;
                    break;
                }
            }
            Thread.sleep(500);
            if (count>0)break;
        }
        if (count>0){
            return true;

        }else{
            return false;
        }
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isOrderPrint()throws InterruptedException {
        return isDocumentPrint("Распоряжение");
    }

    public String userOpenDocument(By element1, By element2) {
        int i=0;
        String docNumb = "";
        while (i<5) {
            try {
                docNumb = getElementText(element1);
                mouseDoubleClick(driver.findElement(element1));
                wait1.until(ExpectedConditions.presenceOfElementLocated(element2));
                break;
            } catch (Exception e){
                i=i+1;
            }
        }
        return docNumb;
    }

    public void userConfirmPrint(){
        if (isConfirmAlertExist()==true){
            click(By.cssSelector("button[name='ok']"));
        }
    }

    public void waitForSearchIsFinal(){
        wait.until(ExpectedConditions.presenceOfElementLocated(resultSearchField));
    }
    @Step("Пользователь открывает ордер")
    public String userOpenOrder(){
        return userOpenDocument(resultSearchField, orderPageTitle);
    }

    @Step("Пользователь открывает акт осмотра")
    public String userOpenViewAct(){
        return userOpenDocument(resultSearchField, viewActsPageTitle);
    }

    @Step("Пользователь печатает акт осмотра")
    public void userPrintViewAct() {
        userPrintDocument(printViewActButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isViewActPrint()throws InterruptedException {
        return isDocumentPrint("Акт+осмотра");
    }

    @Step("Пользователь открывает акт проверки")
    public String userOpenAct(){
        String docNumb = findAndOpenAct("акт проверки");
        //userOpenDocument(resultSearchField, actPageTitle);
        return docNumb;
    }

    @Step("Пользователь печатает акт проверки")
    public void userPrintAct() {
        userPrintDocument(printActButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isActPrint()throws InterruptedException {
        return isDocumentPrint("Акт+проверки");
    }

    public String findAndOpenAct(String name) {
        String docNumb = "";
        int i;
        boolean isActFind = false;
        for (i = 1; i <= 10; i++) {
            WebElement element = driver.findElement(By.xpath("//div[@class='table-wrap']//tbody/tr[" + i + "]/td[11]"));
            String text = element.getText();
            System.out.println(text);
            if (text.equals(name)) {
                docNumb = getElementText(By.xpath("//div[@class='table-wrap']//tbody/tr[" + i + "]/td[2]"));
                mouseDoubleClick(element);
                isActFind = true;
                break;
            }
        }
        if (isActFind == false) {
            int page = 2;
            int p = 10;
            boolean nextPage = true;
            while(isActFind == false){
                By element1 = By.linkText(""+page+"");
                click(element1);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element1));
                String label = getElementText(navigatorLabel).substring(17, 19);
                int count = Integer.parseInt(label);
                for (int c = 1; c <= count - p; c++) {
                    WebElement element = driver.findElement(By.xpath("//div[@class='table-wrap']//tbody/tr[" + c + "]/td[11]"));
                    String text = element.getText();
                    System.out.println(text);
                    if (text.equals(name)) {
                        docNumb = getElementText(By.xpath("//div[@class='table-wrap']//tbody/tr[" + c + "]/td[2]"));
                        mouseDoubleClick(element);
                        isActFind = true;
                        nextPage = false;
                        break;
                    }
                }
                if (nextPage==true) {
                    page = page + 1;
                    p = p + 10;
                    try {
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("" + page + "")));
                    } catch (Exception e) {
                        break;
                    }
                }
            }
        }
        return docNumb;
    }

    @Step("Пользователь открывает приложение к акту проверки")
    public String userOpenAttachToAct(){
        String docNumb = findAndOpenAct("приложение к акту проверки");
        wait.until(ExpectedConditions.presenceOfElementLocated(attachToActPageTitle));
        return docNumb;
    }

    @Step("Пользователь печатает приложение к акту проверки")
    public void userPrintAttachToAct() {
        userPrintDocument(printAttachToActButton);
        userConfirmPrint();
    }

    public boolean isConfirmAlertExist(){
        try {
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Подтверждение']")));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isAttachToActPrint()throws InterruptedException {
        return isDocumentPrint("Приложение+к+акту+проверки");
    }

    @Step("Пользователь открывает акт проверки исполнения предписания")
    public String userOpenCheckAct(){
        String docNumb = findAndOpenAct("акт проверки исполнения предписания");
        wait.until(ExpectedConditions.presenceOfElementLocated(checkActPageTitle));
        return docNumb;
    }

    @Step("Пользователь печатает акт проверки исполнения предписания")
    public void userPrintCheckAct() {
        userPrintDocument(printCheckActButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isCheckActPrint()throws InterruptedException {
        return isDocumentPrint("Акт+проверки+исполнения+предписания");
    }

    @Step("Пользователь открывает приложение к акту проверки исполнения предписания")
    public String userOpenAttachToCheckAct(){
        String docNumb = findAndOpenAct("приложение к акту проверки исполнения предписания");
        wait.until(ExpectedConditions.presenceOfElementLocated(attachToCheckActPageTitle));
        return docNumb;
    }

    @Step("Пользователь печатает приложение к акту проверки исполнения предписания")
    public void userPrintAttachToCheckAct() {
        userPrintDocument(printAttachToCheckActButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isAttachToCheckActPrint()throws InterruptedException {
        return isDocumentPrint("Приложение+к+акту+проверки+исполнения+предписания");
    }

    @Step("Пользователь открывает предписание")
    public String userOpenPrescription(){
        return userOpenDocument(resultSearchField, prescriptionPageTitle);
    }

    @Step("Пользователь печатает предписание")
    public void userPrintPrescription() {
        userPrintDocument(printPrescriptionButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isPrescriptionPrint()throws InterruptedException {
        return isDocumentPrint("Предписание");
    }

    @Step("Пользователь открывает определение об отказе в возбуждении дела")
    public String userOpenDenyCriminal(){
        return userOpenDocument(resultSearchField, denyCriminalPageTitle);
    }

    @Step("Пользователь печатает определение об отказе в возбуждении дела")
    public void userPrintDenyCriminal() {
        userPrintDocument(printDenyCriminalButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isDenyCriminalPrint()throws InterruptedException {
        return isDocumentPrint("refusial_definition");
    }

    @Step("Пользователь открывает Решение об отзыве предписания")
    public String userOpenRevokePrescription(){
        return userOpenDocument(resultSearchField, revokePrescriptionPageTitle);
    }

    @Step("Пользователь печатает Решение об отзыве предписания")
    public void userPrintRevokePrescription() {
        userPrintDocument(printRevokePrescriptionButton);
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isRevokePrescription()throws InterruptedException {
        return isDocumentPrint("decision");
    }

    @Step("Пользователь открывает акт мониторинга")
    public String userOpenMonitoringAct(){
        return userOpenDocument(resultSearchField, monitoringActsPageTitle);
    }

    @Step("Пользователь печатает акт мониторинга")
    public void userPrintMonitoringAct() {
        userPrintDocument(printMonitoringActButton);
        userConfirmPrint();
    }

    @Step("Проверяем наличие печатной формы")
    public boolean isMonitoringActPrint()throws InterruptedException {
        return isDocumentPrint("Акт+мониторинга");
    }
}
