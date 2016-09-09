package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class MainMenu extends Page {
    public MainMenu(WebDriver driver) {
        super(driver);
    }
    //=======Меню Журналы и реестры========
    By journalsAnrRegistryLink = By.linkText("Журналы и реестры");

    //=======Инспекционные журналы=======
    By inspJourlalsLink = By.linkText("Инспекционные журналы");
    By instructionsJournal = By.linkText("Журнал распоряжений");
    By actsJournal = By.linkText("Журнал актов проверок");
    By prescriptionsJournal = By.linkText("Журнал предписаний");
    By viewActsJournal = By.linkText("Журнал актов осмотра");
    By criminalJournal = By.linkText("Журнал определений об отказе в возбуждении дела");
    By eventsJournal = By.linkText("Журнал мероприятий");
    By claimProsecutorJournal = By.linkText("Журнал заявлений в прокуратуру");

    //=======Административная практика=======
    By adminPracticsLink = By.linkText("Административная практика");
    By protocolsJournal = By.linkText("Журнал протоколов");
    By apDealJournal = By.linkText("Журнал дел об АП");
    By decreeJournal = By.linkText("Журнал постановлений");
    By adjunctJournal = By.linkText("Журнал определений");
    By claimJournal = By.linkText("Журнал жалоб");
    By notificationAboutProtocolJournal = By.linkText("Журнал уведомлений о составлении протокола");
    By lettersToCourtJournal = By.linkText("Журнал сопроводительных писем в суд");
    By lettersToSSPJournal = By.linkText("Журнал сопроводительных писем в ССП");
    By registryOfDecision = By.linkText("Журнал Реестры решений");
    By registryOfDeal = By.linkText("Журнал дел, поступивших по подведомственности");

    //=======Журнал реестров=======
    By registryJournal = By.linkText("Журнал реестров");

    //=======Журнал обращений=======
    By referencesJournal = By.linkText("Журнал обращений");

    //=======Финансовый контроль=======
    By finControlLink = By.linkText("Финансовый контроль");
    By profit = By.linkText("Начисления");
    By payments = By.linkText("Платежи");
    By applicationsForRefund = By.linkText("Заявки на возврат");
    By profitAndpaymentsLink = By.linkText("Связывание начислений и платежей");
    By finance = By.linkText("Финансовые показатели");

    //=======Поиск документов=======
    By docsSearch = By.linkText("Поиск документов");

    //=======План проведения проверок=======
    By inspectionsPlanLink = By.linkText("План проведения проверок");

    //=======Меню Отчеты=========
    By reportsLink = By.linkText("Отчеты");

    //=======Меню инспекционные========
    By inspReportsPage = By.linkText("Инспекционные");
    By dataOfDocEnteredReport = By.linkText("Данные по введенным в АИС ГЖИ документам, детализированный");
    By workMGIByYearReport = By.linkText("Сведения о работе Государственной жилищной инспекции");
    By facade3Report = By.linkText("Справка о результатах проверки (Формы 3-6)");
    By forma1Report = By.linkText("Количество многоквартирных домов в которых устранены нарушения указанные в предписаниях ГЖИ МО (Форма 1)");
    By weeklyRptOnInspEnforcementActivities = By.linkText("Еженедельный отчет о контрольно-надзорной деятельности");
    By defectsOfHouseElementsReport = By.xpath("//a[contains(.,'дефектах')]");
    By rptFor3And2quartal = By.linkText("Отчет о результатах контрольных мероприятий");
    By theStatisticOneReport = By.linkText("Приложение №1 (Статистика)");
    By totalsOfChecksSmallsMediumBusinessReport = By.xpath("//a[contains(.,'Итог')]");
    By statisticDataMOReport = By.linkText("Отчет в прокуратуру МО");
    By regionalHousingOversightReport = By.linkText("Информация по осуществлению регионального государственного жилищного надзора");
    By workGeneralDepartmentMOReport = By.linkText("Отчет о работе Главного управления Московской области ГЖИ МО (Краткий отчет)");
    By stateHousingControlReport = By.linkText("Государственный жилищный контроль");
    By outInspectionsForProsecutorsReport = By.linkText("Отчет в прокуратуру МО по выездным проверкам");
    By forma2Report = By.linkText("Форма 2");
    By explanatoryNoteReport = By.linkText("Пояснительная записка");
    By polpredPresidentReport = By.linkText("Отчет полномочному представителю Президента РФ");
    By dataOfDocEnteredReport2 = By.linkText("Данные по документам, введенным в АИС ГЖИ");

    //=======Меню общие========
    By commonReports = By.linkText("Общие");
    By journalOfInspectionsControlsReport = By.linkText("Журнал учета проверок");
    By jurRptByArticle19_5 = By.linkText("Отчет по статье 19.5");
    By registryComplusionReport = By.linkText("Реестр поданных исковых заявлений и понуждении исполнения предписаний");
    By registryClaimsForCourtsOfGeneralJurisdictionReport = By.linkText("Реестр исковых заявлений (суды общей юрисдикции)");
    By registerOfDisqualifiedOfficialsManagingOrganizationsReport = By.linkText("Реестр дисквалифицированных лиц");
    By jurManagementRegistryOfPrescriptionsReport = By.linkText("Реестр предписаний");
    By jurManagementRegistryOfPrescriptionsMingosuReport = By.linkText("Реестр предписаний для Мингосуправления МО");

    //=====Меню Администрирование=====
    By administrationsMenuLink = By.linkText("Администрирование");
    By helpersLink = By.linkText("Справочники");
    By helpInfoLink = By.linkText("Справочная информация");

    //Журнал распоряжений
    @Step("Переходим на страницу \"Журнал распоряжений\"")
    public JournalsPage userGoToInstructionsJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, instructionsJournal);
        return new JournalsPage(driver);
    }

    //Журнал мероприятий
    @Step("Переходим на страницу \"Журнал мероприятий\"")
    public JournalsPage userGoToEventsJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, eventsJournal);
        return new JournalsPage(driver);
    }

    //Журнал актов проверок
    @Step("Переходим на страницу \"Журнал актов проверок\"")
    public JournalsPage userGoToActsJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, actsJournal);
        return new JournalsPage(driver);
    }

    //Журнал предписаний
    @Step("Переходим на страницу \"Журнал предписаний\"")
    public JournalsPage userGoToPrescriptionsJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, prescriptionsJournal);
        return new JournalsPage(driver);
    }

    //Журнал актов осмотра
    @Step("Переходим на страницу \"Журнал актов осмотра\"")
    public JournalsPage userGoToViewActsJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, viewActsJournal);
        return new JournalsPage(driver);
    }

    //Журнал определений об отказе в возбуждении дела
    @Step("Переходим на страницу \"Журнал определений об отказе в возбуждении дела\"")
    public JournalsPage userGoToCriminalJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, criminalJournal);
        return new JournalsPage(driver);
    }

    //Журнал заявлений в прокуратуру
    @Step("Переходим на страницу \"Журнал заявлений в прокуратуру\"")
    public JournalsPage userGoToClaimProsecutorJournal(){
        clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, claimProsecutorJournal);
        return new JournalsPage(driver);
    }

    //Журнал протоколов
    @Step("Переходим на страницу \"Журнал протоколов\"")
    public JournalsPage userGoToProtocolsJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, protocolsJournal);
        return new JournalsPage(driver);
    }

    //Журнал дел об АП
    @Step("Переходим на страницу \"Журнал дел об АП\"")
    public JournalsPage userGoToApDealJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, apDealJournal);
        return new JournalsPage(driver);
    }

    //"Журнал постановлений
    @Step("Переходим на страницу \"Журнал постановлений\"")
    public JournalsPage userGoToDecreeJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, decreeJournal);
        return new JournalsPage(driver);
    }

    //Журнал определений
    @Step("Переходим на страницу \"Журнал определений\"")
    public JournalsPage userGoToAdjunctJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, adjunctJournal);
        return new JournalsPage(driver);
    }

    //Журнал жалоб
    @Step("Переходим на страницу \"Журнал жалоб\"")
    public JournalsPage userGoToClaimJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, claimJournal);
        return new JournalsPage(driver);
    }

    //Журнал Реестры решений
    @Step("Переходим на страницу \"Журнал Реестры решений\"")
    public JournalsPage userGoToRegistryOfDecisionsJournals(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, registryOfDecision);
        return new JournalsPage(driver);
    }

    //Журнал дел, поступивших по подведомственности
    @Step("Переходим на страницу \"Журнал дел, поступивших по подведомственности\"")
    public JournalsPage userGoToRegistryOfDealJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, registryOfDeal);
        return new JournalsPage(driver);
    }



    //Журнал уведомлений о составлении протокола
    @Step("Переходим на страницу \"Журнал уведомлений о составлении протокола\"")
    public JournalsPage userGoToNotificationAboutProtocolJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, notificationAboutProtocolJournal);
        return new JournalsPage(driver);
    }

    //Журнал сопроводительных писем в суд
    @Step("Переходим на страницу \"Журнал сопроводительных писем в суд\"")
    public JournalsPage userGoToLettersToCourtJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, lettersToCourtJournal);
        return new JournalsPage(driver);
    }

    //Журнал сопроводительных писем в ССП
    @Step("Переходим на страницу \"Журнал сопроводительных писем в ССП\"")
    public JournalsPage userGoToLettersToSSPJournal(){
        clickOn3Link(journalsAnrRegistryLink, adminPracticsLink, lettersToSSPJournal);
        return new JournalsPage(driver);
    }

    //Журнал реестров
    @Step("Переходим на страницу \"Журнал реестров\"")
    public JournalsPage userGoToRegistryJournal(){
        clickOn2Link(journalsAnrRegistryLink, registryJournal);
        return new JournalsPage(driver);
    }

    //Журнал обращений
    @Step("Переходим на страницу \"Журнал обращений\"")
    public JournalsPage userGoToReferencesJournal(){
        clickOn2Link(journalsAnrRegistryLink, referencesJournal);
        return new JournalsPage(driver);
    }

    //Начисления
    @Step("Переходим на страницу \"Финансовый контроль\" -> \"Начисления\"")
    public FinControlPage userGoToProfitPage(){
        clickOn2Link(finControlLink, profit);
        return new FinControlPage(driver);
    }

    //Платежи
    @Step("Переходим на страницу \"Финансовый контроль\" -> \"Платежи\"")
    public FinControlPage userGoToPaymentsPage(){
        clickOn2Link(finControlLink, payments);
        return new FinControlPage(driver);
    }

    //Заявки на возврат
    @Step("Переходим на страницу \"Финансовый контроль\" -> \"Заявки на возврат\"")
    public FinControlPage userGoToApplicationsForRefundPage(){
        clickOn2Link(finControlLink, applicationsForRefund);
        return new FinControlPage(driver);
    }

    //Связывание начислений и платежей
    @Step("Переходим на страницу \"Финансовый контроль\" -> \"Связывание начислений и платежей\"")
    public FinControlPage userGoToProfitAndPaymentsPage(){
        clickOn2Link(finControlLink, profitAndpaymentsLink);
        return new FinControlPage(driver);
    }

    //Финансовые показатели
    @Step("Переходим на страницу \"Финансовый контроль\" -> \"Финансовые показатели\"")
    public FinControlPage userGoToFinancePage(){
        clickOn2Link(finControlLink, finance);
        return new FinControlPage(driver);
    }

    //Поиск документов
    @Step("Переходим на страницу \"Поиск документов\"")
    public DocsSearchPage userGoToDocsSearchPage(){
        click(docsSearch);
        return new DocsSearchPage(driver);
    }

    //План проверок ЮЛ/ИП
    @Step("Переходим на страницу \"План проведения проверок\"")
    public InspectionsPlanPage userGoToJurAndIpPlanPage(){
        click(inspectionsPlanLink);
        return new InspectionsPlanPage(driver);
    }

    //=====Отчеты=====
    //Данные по введенным в АИС ГЖИ документам, детализированный
    @Step("Переходим к отчету \"Данные по введенным в АИС ГЖИ документам, детализированный\"")
    public ReportsPage userGoToDataOfDocEnteredReport(){
        clickOn3Link(reportsLink, inspReportsPage, dataOfDocEnteredReport);
        return new ReportsPage(driver);

    }

    //Данные по введенным в АИС ГЖИ документам
    @Step("Переходим к отчету \"Данные по введенным в АИС ГЖИ документам\"")
    public ReportsPage userGoToDataOfDocEnteredReport2(){
        clickOn3Link(reportsLink, inspReportsPage, dataOfDocEnteredReport2);
        return new ReportsPage(driver);

    }

    //Сведения о работе Государственной жилищной инспекции
    @Step("Переходим к отчету \"Сведения о работе Государственной жилищной инспекции\"")
    public ReportsPage userGoToWorkMGIByYearReport(){
        clickOn3Link(reportsLink, inspReportsPage, workMGIByYearReport);
        return new ReportsPage(driver);

    }

    //Справка о результатах проверки (Формы 3-6)
    @Step("Переходим к отчету \"Справка о результатах проверки (Формы 3-6)\"")
    public ReportsPage userGoToFacade3Report(){
        clickOn3Link(reportsLink, inspReportsPage, facade3Report);
        return new ReportsPage(driver);

    }

    //Количество многоквартирных домов в которых устранены нарушения указанные в предписаниях ГЖИ МО (Форма 1)
    @Step("Переходим к отчету \"Количество многоквартирных домов в которых устранены нарушения указанные в предписаниях ГЖИ МО (Форма 1)\"")
    public ReportsPage userGoToForma1Report(){
        clickOn3Link(reportsLink, inspReportsPage, forma1Report);
        return new ReportsPage(driver);

    }

    //Еженедельный отчет о контрольно-надзорной деятельности
    @Step("Переходим к отчету \"Еженедельный отчет о контрольно-надзорной деятельности\"")
    public ReportsPage userGoToWeeklyRptOnInspEnforcementActivities(){
        clickOn3Link(reportsLink, inspReportsPage, weeklyRptOnInspEnforcementActivities);
        return new ReportsPage(driver);

    }

    //Сведения о дефекта конструктивных элементов
    @Step("Переходим к отчету \"Сведения о дефекта конструктивных элементов\"")
    public ReportsPage userGoToDefectsOfHouseElementsReport(){
        clickOn3Link(reportsLink, inspReportsPage, defectsOfHouseElementsReport);
        return new ReportsPage(driver);

    }

    //Отчет о результатах контрольных мероприятий
    @Step("Переходим к отчету \"Отчет о результатах контрольных мероприятий\"")
    public ReportsPage userGoToRptFor3And2quartal(){
        clickOn3Link(reportsLink, inspReportsPage, rptFor3And2quartal);
        return new ReportsPage(driver);

    }

    //Приложение №1 (Статистика)
    @Step("Переходим к отчету \"Приложение №1 (Статистика)\"")
    public ReportsPage userGoToTheStatisticOneReport(){
        clickOn3Link(reportsLink, inspReportsPage, theStatisticOneReport);
        return new ReportsPage(driver);

    }

    //Итог_Сводная таблица проверки малого и  среднего бизнеса
    @Step("Переходим к отчету \"Итог_Сводная таблица проверки малого и  среднего бизнеса\"")
    public ReportsPage userGoToTotalsOfChecksSmallsMediumBusinessReport(){
        clickOn3Link(reportsLink, inspReportsPage, totalsOfChecksSmallsMediumBusinessReport);
        return new ReportsPage(driver);
    }

    //Отчет в прокуратуру МО
    @Step("Переходим к отчету \"Отчет в прокуратуру МО\"")
    public ReportsPage userGoToStatisticDataMOReport(){
        clickOn3Link(reportsLink, inspReportsPage, statisticDataMOReport);
        return new ReportsPage(driver);
    }

    //Информация по осуществлению регионального государственного жилищного надзора
    @Step("Переходим к отчету \"Информация по осуществлению регионального государственного жилищного надзора\"")
    public ReportsPage userGoToRegionalHousingOversightReport(){
        clickOn3Link(reportsLink, inspReportsPage, regionalHousingOversightReport);
        return new ReportsPage(driver);
    }

    //Отчет о работе Главного управления Московской области ГЖИ МО (Краткий отчет)
    @Step("Переходим к отчету \"Отчет о работе Главного управления Московской области ГЖИ МО (Краткий отчет)\"")
    public ReportsPage userGoToWorkGeneralDepartmentMOReport(){
        clickOn3Link(reportsLink, inspReportsPage, workGeneralDepartmentMOReport);
        return new ReportsPage(driver);
    }

    //Государственный жилищный контроль
    @Step("Переходим к отчету \"Государственный жилищный контроль\"")
    public ReportsPage userGoToStateHousingControlReport(){
        clickOn3Link(reportsLink, inspReportsPage, stateHousingControlReport);
        return new ReportsPage(driver);
    }

    //Отчет в прокуратуру МО по выездным проверкам
    @Step("Переходим к отчету \"Отчет в прокуратуру МО по выездным проверкам\"")
    public ReportsPage userGoToOutInspectionsForProsecutorsReport(){
        clickOn3Link(reportsLink, inspReportsPage, outInspectionsForProsecutorsReport);
        return new ReportsPage(driver);
    }

    //Форма 2
    @Step("Переходим к отчету \"Форма 2\"")
    public ReportsPage userGoToOutForma2Report(){
        clickOn3Link(reportsLink, inspReportsPage, forma2Report);
        return new ReportsPage(driver);
    }

    //Пояснительная записка
    @Step("Переходим к отчету \"Пояснительная записка\"")
    public ReportsPage userGoToOutExplanatoryNoteReport(){
        clickOn3Link(reportsLink, inspReportsPage, explanatoryNoteReport);
        return new ReportsPage(driver);
    }

    //Отчет полномочному представителю Президента РФ
    @Step("Переходим к отчету \"Отчет полномочному представителю Президента РФ\"")
    public ReportsPage userGoToPolpredPresidentReport(){
        clickOn3Link(reportsLink, inspReportsPage, polpredPresidentReport);
        return new ReportsPage(driver);
    }
    //=====Юридическое управление=====
    //Журнал учета проверок
    @Step("Переходим к отчету \"Журнал учета проверок\"")
    public ReportsPage userGoToJournalOfInspectionsControlsReport(){
        clickOn3Link(reportsLink, commonReports, journalOfInspectionsControlsReport);
        return new ReportsPage(driver);
    }

    //Отчет по статье 19.5
    @Step("Переходим к отчету \"Отчет по статье 19.5\"")
    public ReportsPage userGoToJurRptByArticle19_5(){
        clickOn3Link(reportsLink, commonReports, jurRptByArticle19_5);
        return new ReportsPage(driver);
    }

    //Реестр поданных исковых заявлений и понуждении исполнения предписаний
    @Step("Переходим к отчету \"Реестр поданных исковых заявлений и понуждении исполнения предписаний\"")
    public ReportsPage userGoToRegistryComplusionReport(){
        clickOn3Link(reportsLink, commonReports, registryComplusionReport);
        return new ReportsPage(driver);
    }

    //Реестр исковых заявлений (суды общей юрисдикции)
    @Step("Переходим к отчету \"Реестр исковых заявлений (суды общей юрисдикции)\"")
    public ReportsPage userGoToRegistryClaimsForCourtsOfGeneralJurisdictionReport(){
        clickOn3Link(reportsLink, commonReports, registryClaimsForCourtsOfGeneralJurisdictionReport);
        return new ReportsPage(driver);
    }

    //Реестр дисквалифицированных лиц
    @Step("Переходим к отчету \"Реестр дисквалифицированных лиц\"")
    public ReportsPage userGoToRegisterOfDisqualifiedOfficialsManagingOrganizationsReport(){
        clickOn3Link(reportsLink, commonReports, registerOfDisqualifiedOfficialsManagingOrganizationsReport);
        return new ReportsPage(driver);
    }

    //Реестр предписаний
    @Step("Переходим к отчету \"Реестр предписаний\"")
    public ReportsPage userGoToJurManagementRegistryOfPrescriptionsReport(){
        clickOn3Link(reportsLink, commonReports, jurManagementRegistryOfPrescriptionsReport);
        return new ReportsPage(driver);
    }

    //Реестр предписаний для Мингосуправления МО
    @Step("Переходим к отчету \"Реестр предписаний для Мингосуправления МО\"")
    public ReportsPage userGoToJurManagementRegistryOfPrescriptionsMingosuReport(){
        clickOn3Link(reportsLink, commonReports, jurManagementRegistryOfPrescriptionsMingosuReport);
        return new ReportsPage(driver);
    }

    //Справочная информация
    @Step("Переходина страницу \"Справочная информация\"")
    public AdminPage userGoToHelpInfoPage(){
        clickOn3Link(administrationsMenuLink, helpersLink, helpInfoLink);
        return new AdminPage(driver);
    }
}
