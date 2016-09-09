package ru.fors.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.DocsSearchPage;
import ru.fors.pages.DocumentsPage;
import ru.fors.pages.JournalsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleyko on 02.03.2016.
 */
public class PrintFormsTests extends TestBase {
    @BeforeClass
    public void cleanWorkingDirectory() {
        File file = new File(dir);
        if (file.isDirectory()){
            System.out.println("Directory exist");
        }else{
            file.mkdirs();
            System.out.println("Directory created");
        }
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f1 = files[i];
            //System.out.println("Delete file: "+ f1.getName());
            f1.delete();
        }
    }

    @BeforeMethod
    @Parameters({"username", "password"})
    public void testStatus(String username, String password){
        if (driver == null){
            init();
            userLogin(username, password);
        } if (driver.getTitle().contains("вход")){
            userLogin(username, password);
        }
    }

    @Features("Печатные формы")
    @Stories("Печать распоряжения")
    @Test
    public void printOrderTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToInstructionsJournal();
        journalsPage.waitForPageInstructionsJournalLoaded();
        journalsPage.userFormedJournal();
        //journalsPage.userFormedPrescriptionJournal(dateFormat.format(startDate));
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenOrder();
        documentsPage.userPrintOrder();
        assertTrue("Файл с печатной формой документа №: " + docNumb +" не сформировался за 1 минуту", documentsPage.isOrderPrint());
    }

    @Features("Печатные формы")
    @Stories("Печать акта осмотра")
    @Test
    public void printViewActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userSetActCreationTypeViewAct();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenViewAct();
        documentsPage.userPrintViewAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isViewActPrint());
    }


    @Features("Печатные формы")
    @Stories("Печать акта мониторинга")
    @Test
    public void printMonitoringActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userSetActCreationTypeMonitoringAct();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenMonitoringAct();
        documentsPage.userPrintMonitoringAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isMonitoringActPrint());
    }


    @Features("Печатные формы")
    @Stories("Печать акта проверки")
    @Test
    public void printActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenAct();
        documentsPage.userPrintAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isActPrint());
    }


    @Features("Печатные формы")
    @Stories("Печать приложения к акту проверки")
    @Test
    public void printAttachToActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenAttachToAct();
        documentsPage.userPrintAttachToAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isAttachToActPrint());
    }


    @Features("Печатные формы")
    @Stories("Печать акта проверки исполнения предписания")
    @Test
    public void printCheckActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenCheckAct();
        documentsPage.userPrintCheckAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb+ " не сформировался за 1 минуту", documentsPage.isCheckActPrint());
    }

    @Features("Печатные формы")
    @Stories("Печать приложениея к акту проверки исполнения предписания")
    @Test
    public void printAttachToCheckActTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedActJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenAttachToCheckAct();
        documentsPage.userPrintAttachToCheckAct();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isAttachToCheckActPrint());
    }

    @Features("Печатные формы")
    @Stories("Печать предписания")
    @Test
    public void printPrescriptionTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToPrescriptionsJournal();
        journalsPage.waitForPagePrescriptionsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenPrescription();
        documentsPage.userPrintPrescription();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isPrescriptionPrint());
    }

    @Features("Печатные формы")
    @Stories("Печать определение об отказе в возбуждении дела")
    @Test
    public void printDenyCriminalTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToCriminalJournal();
        journalsPage.waitForPageCriminalJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenDenyCriminal();
        documentsPage.userPrintDenyCriminal();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isDenyCriminalPrint());
    }


    @Features("Печатные формы")
    @Stories("Печать решение об отзыве предписания")
    @Test
    public void printRevokePrescriptionTest() throws InterruptedException {
        DocsSearchPage docsSearchPage = new DocsSearchPage(driver);
        docsSearchPage.userGoToDocsSearchPage();
        docsSearchPage.waitForDocsSearchPageLoaded();
        docsSearchPage.userFormedPageWithConditions();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        String docNumb = documentsPage.userOpenRevokePrescription();
        documentsPage.userPrintRevokePrescription();
        assertTrue("Файл с печатной формой документа №: " + docNumb + " не сформировался за 1 минуту", documentsPage.isRevokePrescription());
    }
}
