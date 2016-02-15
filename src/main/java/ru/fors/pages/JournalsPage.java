package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 22.01.2016.
 */
public class JournalsPage extends MainMenu{

    public JournalsPage(WebDriver driver) {
        super(driver);
    }
    //=======Инспекционные журналы========
    By instructionsJournalTitle = By.xpath("//h3[text()='Распоряжения']");
    By actsJournalTitle = By.xpath("//h3[text()='Акты проверок']");
    By prescriptionsJournalTitle = By.xpath("//h3[text()='Предписания']");
    By viewActsJournalTitle = By.xpath("//h3[text()='Акты осмотров / Акты']");
    By criminalJournalTitle = By.xpath("//h3[text()='Определения об отказе в возбуждении дела']");
    By eventsJournalTitle = By.xpath("//h3[text()='Список мероприятий']");
    By claimProsecutorJournalTitle = By.xpath("//h3[text()='Заявления в прокуратуру']");
    By orderNumberSearchField = By.xpath("//div[contains(@class, 'span40')]/div[4]//a"); //поле для поиска по номеру распоряжения

    //=======Административная практика========
    By protocolsJournalTitle = By.xpath("//h3[text()='Протоколы']");
    By apDealJournalTitle = By.xpath("//h3[text()='Дело об АП']");
    By decreeJournalTitle = By.xpath("//h3[text()='Постановления']");
    By adjunctJournalTitle = By.xpath("//h3[text()='Определения']");
    By claimJournalTitle = By.xpath("//h3[text()='Жалобы']");
    By notificationAboutProtocolJournalTitle = By.xpath("//h3[text()='Уведомления о составлении протокола']");
    By lettersToCourtJournalTitle = By.xpath("//h3[text()='Журнал сопроводительных писем в суд']");
    By lettersToSSPJournalTitle = By.xpath("//h3[text()='Сопроводительное письмо в ССП']");
    By registryOfDecisionTitle = By.xpath("//h3[text()='Реестры']");
    By registryOfDealTitle = By.xpath("//h3[text()='Дела об АП, поступившие по подведомственности']");

    By registryJournalTitle = By.xpath("//h3[text()='Реестры']");
    By referencesJournalTitle = By.xpath("//h3[text()='Обращения']");

    By findButton = By.xpath("//button[text()='Искать']");
    By orderNumberInTable = By.xpath("//div[@class='table-wrap']//tbody//td[2]");
    By orderStatusInTable = By.xpath("//div[@class='table-wrap']//tbody//td[8]");
    By tableWithResults = By.xpath("//*[@class='act-panel']/div[2]//table/tbody/tr[1]");
    By tableWithResults2 = By.xpath("//*[@class='act-panel']/div//table/tbody/tr[1]");
    By tableWithResultInAdmPractice = By.xpath("//*[@class='table-wrap']//tbody/tr[1]");


    //=====Ожидания загрузки страниц инспекционных журналов=====
    public void waitForPageInstructionsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(instructionsJournalTitle));
    }

    public void waitForPageActsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(actsJournalTitle));
    }

    public void waitForPagePrescriptionsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(prescriptionsJournalTitle));
    }

    public void waitForPageViewActsJournalTitleLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewActsJournalTitle));
    }

    public void waitForPageCriminalJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(criminalJournalTitle));
    }

    public void waitForPageEventsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventsJournalTitle));
    }

    public void waitForPageClaimProsecutorJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(claimProsecutorJournalTitle));
    }

    //=====Формирование инспекционных журналов
    @Step("Проверяем, сформировался ли журнал распоряжений")
    public boolean isInstructionsJournalFormed(){
        return isJournalFormed(tableWithResults);
    }
    @Step("Проверяем, сформировался ли журнал актов проверок")
    public boolean isActsJournalFormed(){
        return isJournalFormed(tableWithResults);
    }

    @Step("Проверяем, сформировался ли журнал предписаний")
    public boolean isPrescriptionsJournalFormed(){
        return isJournalFormed(tableWithResults);
    }

    @Step("Проверяем, сформировался ли журнал актов осмотра")
    public boolean isViewActsJournalJournalFormed(){
        return isJournalFormed(tableWithResults2);
    }

    @Step("Проверяем, сформировался ли журнал определений об отказе в возбуждении дела")
    public boolean isCriminalJournalFormed(){
        return isJournalFormed(tableWithResults2);
    }

    @Step("Проверяем, сформировался ли журнал мероприятий")
    public boolean isEventsJournalFormed(){
        return isJournalFormed(tableWithResults2);
    }

    @Step("Проверяем, сформировался ли журнал заявлений в прокуратуру")
    public boolean isСlaimProsecutorJournalFormed(){
        return isJournalFormed(tableWithResults);
    }
    //=====Ожидания загрузки страниц административных журналов=====
    public void waitForPageProtocolsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(protocolsJournalTitle));
    }

    public void waitForPageApDealJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(apDealJournalTitle));
    }

    public void waitForPageDecreeJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(decreeJournalTitle));
    }

    public void waitForPageAdjunctJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(adjunctJournalTitle));
    }

    public void waitForPageClaimJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(claimJournalTitle));
    }

    public void waitForPageNotificationAboutProtocolJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(notificationAboutProtocolJournalTitle));
    }

    public void waitForPageLettersToCourtJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lettersToCourtJournalTitle));
    }

    public void waitForPageLettersToSSPJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lettersToSSPJournalTitle));
    }

    public void waitForPageRegistryOfDecisionsJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registryOfDecisionTitle));
    }

    public void waitForPageRegistryOfDealJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registryOfDealTitle));
    }

    //=====Формирование административных журналов
    @Step("Проверяем, сформировался ли журнал протоколов")
    public boolean isProtocolsJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }
    @Step("Проверяем, сформировался ли журнал дел об АП")
    public boolean isApDealJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал постановлений")
    public boolean isDecreeJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал определений")
    public boolean isAdjunctJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал жалоб")
    public boolean isClaimJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал уведомлений о составлении протокола")
    public boolean isNotificationAboutProtocolJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }


    @Step("Проверяем, сформировался ли журнал сопроводительных писем в суд")
    public boolean isLettersToCourtJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал сопроводительных писем в ССП")
    public boolean isLettersToSSPJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал реестры решений")
    public boolean isRegistryOfDecisionsJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    @Step("Проверяем, сформировался ли журнал дел об АП, поступивших по подведомственности")
    public boolean isRegistryOfDealJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    //=====Журнал реестров=====
    public void waitForPageRegistryJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registryJournalTitle));
    }
    @Step("Проверяем, сформировался ли журнал реестров")
    public boolean isRegistryJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }

    //=====Журнал обращений=====
    public void waitForPageReferencesJournalLoaded (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(referencesJournalTitle));
    }

    @Step("Проверяем, сформировался ли журнал обращений")
    public boolean isReferencesJournalFormed(){
        return isJournalFormed(tableWithResultInAdmPractice);
    }


    public void userSetOrderNumber(String number){
        userSelectValue(orderNumberSearchField, number);
    }

    public void userClickFindButton(){
        click(findButton);
    }

    public String userGetFindOrderNumber(){
        return getElementText(orderNumberInTable);
    }

    public String userGetFindOrderStatus(){
        return getElementText(orderStatusInTable);
    }

    public void userSearchOrder(String number){
        userSetOrderNumber(number);
        userClickFindButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberInTable));
    }

    public OrderPage userOpenOrder(){
        int i=0;
        while (i<5) {
            try {
                mouseDoubleClick(driver.findElement(By.xpath("//div[@class='table-wrap']//tbody//td[2]")));
                wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Распоряжение']")));
                break;
            } catch (Exception e){
                i=i+1;
            }
        }
        return new OrderPage(driver);
    }

    public void userFormedJournal(){
        click(findButton);
    }

    public boolean isJournalFormed(By element){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
