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
        documentsPage.userOpenOrder();
        documentsPage.userPrintOrder();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isOrderPrint());
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
        documentsPage.userOpenViewAct();
        documentsPage.userPrintViewAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isViewActPrint());
    }

    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать акта осмотра")
    @Test
    public void printViewActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userSetActCreationTypeViewAct();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenViewAct();
        documentsPage.userPrintViewActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isViewActPrint());
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
        documentsPage.userOpenMonitoringAct();
        documentsPage.userPrintMonitoringAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isMonitoringActPrint());
    }

    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать акта мониторинга")
    @Test
    public void printMonitoringActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userSetActCreationTypeMonitoringAct();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenMonitoringAct();
        documentsPage.userPrintMonitoringActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isMonitoringActPrint());
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
        documentsPage.userOpenAct();
        documentsPage.userPrintAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isActPrint());
    }
    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать акта проверки")
    @Test
    public void printActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAct();
        documentsPage.userPrintActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isActPrint());
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
        documentsPage.userOpenAttachToAct();
        documentsPage.userPrintAttachToAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToActPrint());
    }

    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать приложения к акту проверки")
    @Test
    public void printAttachToActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAttachToAct();
        documentsPage.userPrintAttachToActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToActPrint());
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
        documentsPage.userOpenCheckAct();
        documentsPage.userPrintCheckAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isCheckActPrint());
    }
    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать акта проверки исполнения предписания")
    @Test
    public void printCheckActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenCheckAct();
        documentsPage.userPrintCheckActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isCheckActPrint());
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
        documentsPage.userOpenAttachToCheckAct();
        documentsPage.userPrintAttachToCheckAct();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToCheckActPrint());
    }
    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать приложениея к акту проверки исполнения предписания")
    @Test
    public void printAttachToCheckActWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedActJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenAttachToCheckAct();
        documentsPage.userPrintAttachToCheckActWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isAttachToCheckActPrint());
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
        documentsPage.userOpenPrescription();
        documentsPage.userPrintPrescription();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isPrescriptionPrint());
    }
    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать предписания")
    @Test
    public void printPrescriptionWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToPrescriptionsJournal();
        journalsPage.waitForPagePrescriptionsJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenPrescription();
        documentsPage.userPrintPrescriptionWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isPrescriptionPrint());
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
        documentsPage.userOpenDenyCriminal();
        documentsPage.userPrintDenyCriminal();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isDenyCriminalPrint());
    }

    //для ролей ggi_oap,  kochetkovana_bigboss, laptev_obu не требуется подтверждение
    @Features("Печатные формы")
    @Stories("Печать определение об отказе в возбуждении дела")
    @Test
    public void printDenyCriminalWithoutConfirmTest() throws InterruptedException {
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToCriminalJournal();
        journalsPage.waitForPageCriminalJournalLoaded();
        journalsPage.userFormedJournal();
        DocumentsPage documentsPage = new DocumentsPage(driver);
        documentsPage.waitForSearchIsFinal();
        documentsPage.userOpenDenyCriminal();
        documentsPage.userPrintDenyCriminalWithoutConfirm();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isDenyCriminalPrint());
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
        documentsPage.userOpenRevokePrescription();
        documentsPage.userPrintRevokePrescription();
        assertTrue("Файл с печатной формой не сформировался за 1 минуту", documentsPage.isRevokePrescription());
    }
}
