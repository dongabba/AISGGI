package ru.fors.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.File;
import java.text.DateFormat;

import static org.junit.Assert.assertTrue;

/**
 * Created by gabba on 13.02.16.
 */
public class ReportsTests extends TestBase {
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
        } if (driver.getTitle().equals("Главное управление «Государственная жилищная инспекция Московской области» - вход")){
            userLogin(username, password);
        }
    }

    @Features("Отчеты")
    @Stories("Отчет \"Данные по документам, введенным в АИС ГЖИ\"")
    @Test
    public void dataOfDocEnteredReport2Test() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToDataOfDocEnteredReport2();
        reportsPage.userBuildDataOfDocEnteredReport2(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isDataOfDocEnteredReport2Formed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Данные по введенным в АИС ГЖИ документам, детализированный\"")
    @Test
    public void dataOfDocEnteredReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToDataOfDocEnteredReport();
        reportsPage.userBuildDataOfDocEnteredReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isDataOfDocEnteredReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Сведения о работе Государственной жилищной инспекции\"")
    @Test
    public void workMGIByYearReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToWorkMGIByYearReport();
        reportsPage.userBuildWorkMGIByYearReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isWorkMGIByYearReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Справка о результатах проверки (Формы 3-6)\"")
    @Test
    public void facade3ReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToFacade3Report();
        reportsPage.userBuildFacade3Report();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isFacade3ReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Количество многоквартирных домов в которых устранены нарушения указанные в предписаниях ГЖИ МО (Форма 1)\"")
    @Test
    public void forma1ReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToForma1Report();
        reportsPage.userBuildForma1Report(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isForma1ReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Еженедельный отчет о контрольно-надзорной деятельности\"")
    @Test
    public void weeklyRptOnInspEnforcementActivitiesTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToWeeklyRptOnInspEnforcementActivities();
        reportsPage.userBuildWeeklyRptOnInspEnforcementActivities();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isWeeklyRptOnInspEnforcementActivitiesFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Сведения о дефекта конструктивных элементов\"")
    @Test
    public void defectsOfHouseElementsReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToDefectsOfHouseElementsReport();
        reportsPage.userBuildDefectsOfHouseElementsReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isDefectsOfHouseElementsReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет о результатах контрольных мероприятий\"")
    @Test
    public void rptFor3And2quartalTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToRptFor3And2quartal();
        reportsPage.userBuildRptFor3And2quartal(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isRptFor3And2quartalFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Приложение №1 (Статистика)\"")
    @Test
    public void theStatisticOneReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToTheStatisticOneReport();
        reportsPage.userBuildTheStatisticOneReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isTheStatisticOneReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Итог_Сводная таблица проверки малого и  среднего бизнеса\"")
    @Test
    public void totalsOfChecksSmallsMediumBusinessReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToTotalsOfChecksSmallsMediumBusinessReport();
        reportsPage.userBuildTotalsOfChecksSmallsMediumBusinessReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isTotalsOfChecksSmallsMediumBusinessReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет в прокуратуру МО\"")
    @Test
    public void statisticDataMOReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToStatisticDataMOReport();
        reportsPage.userBuildStatisticDataMOReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isStatisticDataMOReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Информация по осуществлению регионального государственного жилищного надзора\"")
    @Test
    public void regionalHousingOversightReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToRegionalHousingOversightReport();
        reportsPage.userBuildRegionalHousingOversightReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isRegionalHousingOversightReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет о работе Главного управления Московской области ГЖИ МО (Краткий отчет)\"")
    @Test
    public void workGeneralDepartmentMOReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToWorkGeneralDepartmentMOReport();
        reportsPage.userBuildWorkGeneralDepartmentMOReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isWorkGeneralDepartmentMOReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Государственный жилищный контроль\"")
    @Test
    public void stateHousingControlReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToStateHousingControlReport();
        reportsPage.userBuildStateHousingControlReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isStateHousingControlReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет в прокуратуру МО по выездным проверкам\"")
    @Test
    public void outInspectionsForProsecutorsReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToOutInspectionsForProsecutorsReport();
        reportsPage.userBuildOutInspectionsForProsecutorsReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isOutInspectionsForProsecutorsReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Форма 2\"")
    @Test
    public void forma2ReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToOutForma2Report();
        reportsPage.userBuildForma2Report();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isForma2ReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Пояснительная записка\"")
    @Test
    public void explanatoryNoteReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToOutExplanatoryNoteReport();
        reportsPage.userBuildExplanatoryNoteReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isExplanatoryNoteReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет полномочному представителю Президента РФ\"")
    @Test
    public void polpredPresidentReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToPolpredPresidentReport();
        reportsPage.userBuildPolpredPresidentReport();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isPolpredPresidentReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Журнал учета проверок\"")
    @Test
    public void journalOfInspectionsControlsReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToJournalOfInspectionsControlsReport();
        reportsPage.userBuildJournalOfInspectionsControlsReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isJournalOfInspectionsControlsReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Отчет по статье 19.5\"")
    @Test
    public void jurRptByArticle19_5Test() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToJurRptByArticle19_5();
        reportsPage.userBuildJurRptByArticle19_5();
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isJurRptByArticle19_5Formed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Реестр поданных исковых заявлений и понуждении исполнения предписаний\"")
    @Test
    public void registryComplusionReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToRegistryComplusionReport();
        reportsPage.userBuildRegistryComplusionReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isRegistryComplusionReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Реестр исковых заявлений (суды общей юрисдикции)\"")
    @Test
    public void registryClaimsForCourtsOfGeneralJurisdictionReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToRegistryClaimsForCourtsOfGeneralJurisdictionReport();
        reportsPage.userBuildRegistryClaimsForCourtsOfGeneralJurisdictionReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isRegistryClaimsForCourtsOfGeneralJurisdictionReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Реестр дисквалифицированных лиц\"")
    @Test
    public void registerOfDisqualifiedOfficialsManagingOrganizationsReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToRegisterOfDisqualifiedOfficialsManagingOrganizationsReport();
        reportsPage.userBuildRegisterOfDisqualifiedOfficialsManagingOrganizationsReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isRegisterOfDisqualifiedOfficialsManagingOrganizationsReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Реестр предписаний\"")
    @Test
    public void jurManagementRegistryOfPrescriptionsReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToJurManagementRegistryOfPrescriptionsReport();
        reportsPage.userBuildJurManagementRegistryOfPrescriptionsReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isJurManagementRegistryOfPrescriptionsReportFormed());
    }

    @Features("Отчеты")
    @Stories("Отчет \"Реестр предписаний для Мингосуправления МО\"")
    @Test
    public void jurManagementRegistryOfPrescriptionsMingosuReportTest() throws InterruptedException {
        ReportsPage reportsPage = new ReportsPage(driver);
        reportsPage.userGoToJurManagementRegistryOfPrescriptionsMingosuReport();
        reportsPage.userBuildJurManagementRegistryOfPrescriptionsMingosuReport(dateFormat.format(dateFrom), dateFormat.format(dateTo));
        assertTrue("Файл с отчетом не сформировался за 1 минуту", reportsPage.isJurManagementRegistryOfPrescriptionsMingosuReportFormed());
    }

}
