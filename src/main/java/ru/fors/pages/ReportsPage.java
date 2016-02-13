package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.fors.utils.PropertyLoader;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

/**
 * Created by gabba on 13.02.16.
 */
public class ReportsPage extends MainMenu{
    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    By dataOfDocEnteredReportTitle = By.xpath("//h3[text()='Данные по введенным в АИС ГЖИ документам, детализированный']");
    By workMGIByYearReportTitle = By.xpath("//h3[text()='Сведения о работе Государственной жилищной инспекции']");
    By facade3ReportTitle = By.xpath("//h3[text()='Форма 3 (Фасады)']");
    By forma1ReportTitle = By.xpath("//h3[text()='Количество многоквартирных домов в которых  устранены нарушения указанные в предписаниях ГЖИ МО (Форма 1)']");
    By weeklyRptOnInspEnforcementActivitiesTitle = By.xpath("//h3[text()='Еженедельный отчет о контрольно-надзорной деятельности']");
    By defectsOfHouseElementsReportTitle = By.xpath("//h3[text()='Сведения о дефектах конструктивных элементов']");
    By rptFor3And2quartalTitle = By.xpath("//h3[text()='Сводный отчет о результатах контрольных мероприятий']");
    By theStatisticOneReportTitle = By.xpath("//h3[text()='Приложение №1 (Статистика)']");
    By totalsOfChecksSmallsMediumBusinessReportTitle = By.xpath("//h3[text()='Итог_Сводная таблица проверки малого и среднего бизнеса']");
    By statisticDataMOReportTitle = By.xpath("//h3[text()='Отчет в прокуратуру МО']");
    By regionalHousingOversightReportTitle = By.xpath("//h3[text()='Информация по осуществлению регионального государственного жилищного надзора']");
    By workGeneralDepartmentMOReportTitle = By.xpath("//h3[text()='Отчет о работе Главного управления Московской области ГЖИ МО (Краткий отчет)']");
    By stateHousingControlReportTitle = By.xpath("//h3[text()='Государственный жилищный контроль']");
    By outInspectionsForProsecutorsReportTitle = By.xpath("//h3[text()='Отчет в прокуратуру МО по выездным проверкам']");
    By forma2ReportTitle = By.xpath("//h3[text()='Форма 2']");
    By explanatoryNoteReportTitle = By.xpath("//h3[text()='Пояснительная записка']");
    By polpredPresidentReportTitle = By.xpath("//h3[text()='Отчет полномочному представителю Президента РФ']");


    By journalOfInspectionsControlsReportTitle = By.xpath("//h3[text()='Журнал учета проверок']");
    By jurRptByArticle19_5Title = By.xpath("//h3[text()='Отчет по статье 19.5']");
    By registryComplusionReportTitle = By.xpath("//h3[text()='Реестр поданных исковых заявлений и понуждении исполнения предписаний']");
    By registryClaimsForCourtsOfGeneralJurisdictionReportTitle = By.xpath("//h3[text()='Реестр исковых заявлений (суды общей юрисдикции)']");
    By registerOfDisqualifiedOfficialsManagingOrganizationsReportTitle = By.xpath("//h3[text()='Реестр дисквалифицированных лиц']");
    By jurManagementRegistryOfPrescriptionsReportTitle = By.xpath("//h3[text()='Реестр предписаний']");
    By jurManagementRegistryOfPrescriptionsMingosuReportTitle = By.xpath("//h3[text()='Реестр предписаний для Мингосуправления МО']");
    By dateFromField = By.cssSelector("input[name='dateInterval:from:date']");
    By dateToField = By.cssSelector("input[name='dateInterval:to:date']");
    By buildButton = By.xpath("//button[text()='Сформировать']");
    By buildButton2 = By.cssSelector("button[class*='left']");

    public ReportsPage waitForReportLoaded(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }
    @Step("Устанавливаем дату с")
    public void userSetDataFrom(String date){
        type(dateFromField, date);
    }
    @Step("Устанавливаем дату по")
    public void userSetDataTo(String date){
        type(dateToField, date);
    }
    @Step("Строим отчет")
    public void userBuildReport(){
        click(buildButton);
    }
    @Step("Строим отчет")
    public void userBuildReport2(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("button[class*='left']"))).click().perform();
    }

    public void userBuildDataOfDocEnteredReport() throws InterruptedException {
        waitForReportLoaded(dataOfDocEnteredReportTitle);
        userBuildReport2();
    }

    public void userBuildWorkMGIByYearReport() throws InterruptedException {
        waitForReportLoaded(workMGIByYearReportTitle);
        userBuildReport();
    }

    public void userBuildFacade3Report() throws InterruptedException {
        waitForReportLoaded(facade3ReportTitle);
        userBuildReport();
    }

    public void userBuildForma1Report(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(forma1ReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildWeeklyRptOnInspEnforcementActivities() throws InterruptedException {
        waitForReportLoaded(weeklyRptOnInspEnforcementActivitiesTitle);
        userBuildReport();
    }

    public void userBuildDefectsOfHouseElementsReport() throws InterruptedException {
        waitForReportLoaded(defectsOfHouseElementsReportTitle);
        userBuildReport();
    }

    public void userBuildRptFor3And2quartal(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(rptFor3And2quartalTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildTheStatisticOneReport() throws InterruptedException {
        waitForReportLoaded(theStatisticOneReportTitle);
        userBuildReport();
    }

    public void userBuildTotalsOfChecksSmallsMediumBusinessReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(totalsOfChecksSmallsMediumBusinessReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildStatisticDataMOReport() throws InterruptedException {
        waitForReportLoaded(statisticDataMOReportTitle);
        userBuildReport();
    }

    public void userBuildRegionalHousingOversightReport() throws InterruptedException {
        waitForReportLoaded(regionalHousingOversightReportTitle);
        userBuildReport();
    }

    public void userBuildWorkGeneralDepartmentMOReport() throws InterruptedException {
        waitForReportLoaded(workGeneralDepartmentMOReportTitle);
        userBuildReport();
    }

    public void userBuildStateHousingControlReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(stateHousingControlReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildOutInspectionsForProsecutorsReport() throws InterruptedException {
        waitForReportLoaded(outInspectionsForProsecutorsReportTitle);
        userBuildReport();
    }

    public void userBuildForma2Report() throws InterruptedException {
        waitForReportLoaded(forma2ReportTitle);
        userBuildReport();
    }

    public void userBuildExplanatoryNoteReport() throws InterruptedException {
        waitForReportLoaded(explanatoryNoteReportTitle);
        userBuildReport();
    }

    public void userBuildPolpredPresidentReport() throws InterruptedException{
        waitForReportLoaded(polpredPresidentReportTitle);
        userBuildReport();
    }

    public void userBuildJournalOfInspectionsControlsReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(journalOfInspectionsControlsReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildJurRptByArticle19_5() throws InterruptedException {
        waitForReportLoaded(jurRptByArticle19_5Title);
        userBuildReport();
    }

    public void userBuildRegistryComplusionReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(registryComplusionReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildRegistryClaimsForCourtsOfGeneralJurisdictionReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(registryClaimsForCourtsOfGeneralJurisdictionReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildRegisterOfDisqualifiedOfficialsManagingOrganizationsReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(registerOfDisqualifiedOfficialsManagingOrganizationsReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildJurManagementRegistryOfPrescriptionsReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(jurManagementRegistryOfPrescriptionsReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public void userBuildJurManagementRegistryOfPrescriptionsMingosuReport(String dateFrom, String dateTo) throws InterruptedException {
        waitForReportLoaded(jurManagementRegistryOfPrescriptionsMingosuReportTitle);
        userSetDataFrom(dateFrom);
        userSetDataTo(dateTo);
        userBuildReport();
    }

    public boolean isReportFormed(String reportName) throws InterruptedException {
        File file = new File(PropertyLoader.loadProperty("downloadDir"));
        //System.out.println("This is isReportFormed method. Search files in directory: "+PropertyLoader.loadProperty("downloadDir"));
        int count=0;
        for (int time = 0; time<118; time++) {
            File [] files = file.listFiles();
            //System.out.println("This is isReportFormed method: Total files in directory: " +files.length);
            for (int i = 0; i < files.length; i++) {
                File f1 = files[i];
                //System.out.println("This is isReportFormed method: File name: " + i+" " + f1.getName());
                if (f1.getName().startsWith(reportName)) {
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

    @Step("Проверяем наличие файла с отчетом")
    public boolean isDataOfDocEnteredReportFormed()throws InterruptedException {
        return isReportFormed("dataOfDocsEnteredDetailed");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isWorkMGIByYearReportFormed()throws InterruptedException {
        return isReportFormed("workMGI_byYear");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isFacade3ReportFormed()throws InterruptedException {
        return isReportFormed("facade3");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isForma1ReportFormed()throws InterruptedException {
        return isReportFormed("forma_1");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isWeeklyRptOnInspEnforcementActivitiesFormed()throws InterruptedException {
        return isReportFormed("weeklyRptOnInspEnforcementActivities");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isDefectsOfHouseElementsReportFormed()throws InterruptedException {
        return isReportFormed("defectsOfHouseElements");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isRptFor3And2quartalFormed()throws InterruptedException {
        return isReportFormed("rptFor3And2quartal");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isTheStatisticOneReportFormed()throws InterruptedException {
        return isReportFormed("theStatisticOne");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isTotalsOfChecksSmallsMediumBusinessReportFormed()throws InterruptedException {
        return isReportFormed("totalsOfChecksSmallsMediumBusiness");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isStatisticDataMOReportFormed()throws InterruptedException {
        return isReportFormed("statisticData");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isRegionalHousingOversightReportFormed()throws InterruptedException {
        return isReportFormed("regionalHousingOversight");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isWorkGeneralDepartmentMOReportFormed()throws InterruptedException {
        return isReportFormed("workGeneralDepartmentMO");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isStateHousingControlReportFormed()throws InterruptedException {
        return isReportFormed("stateHousingControl");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isOutInspectionsForProsecutorsReportFormed()throws InterruptedException {
        return isReportFormed("outInspectionsForProsecutors");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isForma2ReportFormed()throws InterruptedException {
        return isReportFormed("forma_2");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isExplanatoryNoteReportFormed()throws InterruptedException {
        return isReportFormed("explanatoryNote");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isPolpredPresidentReportFormed()throws InterruptedException {
        return isReportFormed("polpredPresidentReport");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isJournalOfInspectionsControlsReportFormed()throws InterruptedException {
        return isReportFormed("journalOfInspectionsControls");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isJurRptByArticle19_5Formed()throws InterruptedException {
        return isReportFormed("jurRptByArticle19.5");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isRegistryComplusionReportFormed()throws InterruptedException {
        return isReportFormed("registryComplusion");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isRegistryClaimsForCourtsOfGeneralJurisdictionReportFormed()throws InterruptedException {
        return isReportFormed("registryClaimsForCourtsOfGeneralJurisdiction");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isRegisterOfDisqualifiedOfficialsManagingOrganizationsReportFormed()throws InterruptedException {
        return isReportFormed("registerOfDisqualifiedOfficialsManagingOrganizations");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isJurManagementRegistryOfPrescriptionsReportFormed()throws InterruptedException {
        return isReportFormed("jurManagementRegistryOfPrescriptions");
    }

    @Step("Проверяем наличие файла с отчетом")
    public boolean isJurManagementRegistryOfPrescriptionsMingosuReportFormed()throws InterruptedException {
        return isReportFormed("jurManagementRegistryOfPrescriptionsMingosu");
    }
}
