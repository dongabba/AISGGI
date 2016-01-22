package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.OrderPage;
import ru.fors.pages.JournalsPage;
import ru.fors.pages.LoginPage;
import ru.fors.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleyko on 20.01.2016.
 */
public class CreateOrderTests extends TestBase{
    @BeforeMethod
    @Parameters({"username", "password"})
    public void testStatus(String username, String password){
        if (driver == null){
            init();
            userLogin(username, password);
        }
    }

    @Features("Распоряжение")
    @Stories("Вход/Выход из системы")
    @Test
    @Parameters({"username", "password"})
    public void createOrderPTest(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.userLogin(username, password);
        OrderPage orderPage = mainPage.userCreateOrderP();
        orderPage.waitForOrderPageLoaded();
        String orderNumb = orderPage.userCreateOrderP(dateFormat.format(date), "Глазунов В. М.", "ООО \"УК \"Вишневый сад\"", "Бесхлебнов", "Чеховский район, город Чехов, улица Вишневая, д. 2");
        assertTrue("Распоряжение с типом Р- не сохранилось", orderPage.isOrderCreated());
        orderPage.userGoToMainPage();
        JournalsPage journalsPage = mainPage.userGoToInstructionsJournal();
        journalsPage.waitForPageInstructionsJournalLoaded();
        journalsPage.userSearchOrder(orderNumb);
        assertTrue("Распоряжение не найдено", journalsPage.userGetFindOrderNumber().equals(orderNumb));
        journalsPage.userOpenOrder();
        orderPage.waitForOrderPageLoaded();
        orderPage.userChangeOrderStatusToTransfToWork();
        orderPage.userCloseOrder();
        journalsPage.waitForPageInstructionsJournalLoaded();
        assertTrue("Не изменился статус", journalsPage.userGetFindOrderStatus().equals("В работе"));
    }
}
