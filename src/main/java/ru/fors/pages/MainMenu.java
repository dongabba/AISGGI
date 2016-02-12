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

    //=======Меню юридическое управление========
    By jurReports = By.linkText("Юридическое управление");

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


}
