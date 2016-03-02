package ru.fors.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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
        //System.out.println("Is directory exists "+ file.exists());
        //System.out.println("Total files in directory: " +dir+" "+ file.listFiles().length);
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
    @Stories("Отчет \"Печать распоряжения\"")
    @Test
    public void printOrderTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToInstructionsJournal();
        journalsPage.waitForPageInstructionsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenOrder();
        documentsPage.userPrintOrder();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isOrderPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать акта осмотра\"")
    @Test
    public void printViewActTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenViewAct();
        documentsPage.userPrintViewAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isViewActPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать акта проверки\"")
    @Test
    public void printActTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAct();
        documentsPage.userPrintAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isActPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать приложения к акту проверки\"")
    @Test
    public void printAttachToActTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAttachToAct();
        documentsPage.userPrintAttachToAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToActPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать акта проверки исполнения предписания\"")
    @Test
    public void printCheckActTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenCheckAct();
        documentsPage.userPrintCheckAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isCheckActPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать приложениея к акту проверки исполнения предписания\"")
    @Test
    public void printAttachToCheckActTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAttachToCheckAct();
        documentsPage.userPrintAttachToCheckAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToCheckActPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать предписания\"")
    @Test
    public void printPrescriptionTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToPrescriptionsJournal();
        journalsPage.waitForPagePrescriptionsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenPrescription();
        documentsPage.userPrintPrescription();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isPrescriptionPrint());
    }

    @Features("Печатные формы")
    @Stories("Отчет \"Печать определение об отказе в возбуждении дела\"")
    @Test
    public void printDenyCriminalTests() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToCriminalJournal();
        journalsPage.waitForPageCriminalJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenDenyCriminal();
        documentsPage.userPrintDenyCriminal();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isDenyCriminalPrint());
    }
}
