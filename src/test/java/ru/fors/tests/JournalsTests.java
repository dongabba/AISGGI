package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.JournalsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class JournalsTests extends TestBase{

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

    @Features("Журналы и реестры")
    @Stories("Журнал распоряжений")
    @Test
    public void instructionsJournalTest() throws InterruptedException {
        System.out.println("Start: instructionsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToInstructionsJournal();
        journalsPage.waitForPageInstructionsJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isInstructionsJournalFormed());
        System.out.println("Finish: instructionsJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал актов проверок")
    @Test
    public void actsJournalTest() throws InterruptedException {
        System.out.println("Start: actsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToActsJournal();
        journalsPage.waitForPageActsJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isActsJournalFormed());
        System.out.println("Finish: actsJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал предписаний")
    @Test
    public void prescriptionsJournalTest() throws InterruptedException {
        System.out.println("Start: prescriptionsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToPrescriptionsJournal();
        journalsPage.waitForPagePrescriptionsJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isPrescriptionsJournalFormed());
        System.out.println("Finish: prescriptionsJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал актов осмотра")
    @Test
    public void viewActsJournalTest() throws InterruptedException {
        System.out.println("Start: viewActsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToViewActsJournal();
        journalsPage.waitForPageViewActsJournalTitleLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isViewActsJournalJournalFormed());
        System.out.println("Finish: viewActsJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал определений об отказе в возбуждении дела")
    @Test
    public void criminalJournalTest() throws InterruptedException {
        System.out.println("Start: criminalJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToCriminalJournal();
        journalsPage.waitForPageCriminalJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isCriminalJournalFormed());
        System.out.println("Finish: criminalJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал мероприятий")
    @Test
    public void eventsJournalTest() throws InterruptedException {
        System.out.println("Start: eventsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToEventsJournal();
        journalsPage.waitForPageEventsJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isEventsJournalFormed());
        System.out.println("Finish: eventsJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал заявлений в прокуратуру")
    @Test
    public void claimProsecutorJournalTest() throws InterruptedException {
        System.out.println("Start: claimProsecutorJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToClaimProsecutorJournal();
        journalsPage.waitForPageClaimProsecutorJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isСlaimProsecutorJournalFormed());
        System.out.println("Finish: claimProsecutorJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал протоколов")
    @Test
    public void protocolsJournalTest() throws InterruptedException {
        System.out.println("Start: protocolsJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToProtocolsJournal();
        journalsPage.waitForPageProtocolsJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isProtocolsJournalFormed());
        System.out.println("Finish: protocolsJournalTest");
    }
    @Features("Журналы и реестры")
    @Stories("Журнал дел об АП")
    @Test
    public void apDealJournalTest() throws InterruptedException {
        System.out.println("Start: apDealJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToApDealJournal();
        journalsPage.waitForPageApDealJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isApDealJournalFormed());
        System.out.println("Finish: apDealJournalTest");
    }
    @Features("Журналы и реестры")
    @Stories("Журнал постановлений")
    @Test
    public void decreeJournalTest() throws InterruptedException {
        System.out.println("Start: decreeJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToDecreeJournal();
        journalsPage.waitForPageDecreeJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isDecreeJournalFormed());
        System.out.println("Finish: decreeJournalTest");
    }
    @Features("Журналы и реестры")
    @Stories("Журнал определений")
    @Test
    public void adjunctJournalTest() throws InterruptedException {
        System.out.println("Start: adjunctJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToAdjunctJournal();
        journalsPage.waitForPageAdjunctJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isAdjunctJournalFormed());
        System.out.println("Finish: adjunctJournalTest");
    }
    @Features("Журналы и реестры")
    @Stories("Журнал жалоб")
    @Test
    public void claimJournalTest() throws InterruptedException {
        System.out.println("Start: claimJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToClaimJournal();
        journalsPage.waitForPageClaimJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isClaimJournalFormed());
        System.out.println("Finish: claimJournalTest");
    }
    @Features("Журналы и реестры")
    @Stories("Журнал уведомлений о составлении протокола")
    @Test
    public void notificationAboutProtocolJournalTest() throws InterruptedException {
        System.out.println("Start: notificationAboutProtocolJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToNotificationAboutProtocolJournal();
        journalsPage.waitForPageNotificationAboutProtocolJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isNotificationAboutProtocolJournalFormed());
        System.out.println("Finish: notificationAboutProtocolJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал реестров")
    @Test
    public void registryJournalTest() throws InterruptedException {
        System.out.println("Start: registryJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToRegistryJournal();
        journalsPage.waitForPageRegistryJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isRegistryJournalFormed());
        System.out.println("Finish: registryJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал обращений")
    @Test
    public void referencesJournalTest() throws InterruptedException {
        System.out.println("Start: referencesJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToReferencesJournal();
        journalsPage.waitForPageReferencesJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isReferencesJournalFormed());
        System.out.println("Finish: referencesJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал сопроводительных писем в суд")
    @Test
    public void lettersToCourtJournalTest() throws InterruptedException {
        System.out.println("Start: lettersToCourtJournalJournalTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToLettersToCourtJournal();
        journalsPage.waitForPageLettersToCourtJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isLettersToCourtJournalFormed());
        System.out.println("Finish: lettersToCourtJournalJournalTest");
    }

    @Features("Журналы и реестры")
    @Stories("Журнал сопроводительных писем в ССП")
    @Test
    public void lettersToSSPJournalTest() throws InterruptedException {
        System.out.println("Start: coverLettersJournalFormedTest");
        JournalsPage journalsPage = new JournalsPage(driver);
        journalsPage.userGoToLettersToSSPJournal();
        journalsPage.waitForPageLettersToSSPJournalLoaded();
        journalsPage.userFormedJournal();
        assertTrue("Журнал не сформировался или в нем нет данных", journalsPage.isLettersToSSPJournalFormed());
        System.out.println("Finish: lettersToSSPJournalTest");
    }
}
