package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.CreateOrderPage;
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
        CreateOrderPage createOrderPage = mainPage.userCreateOrderP();
        String orderNumb = createOrderPage.userCreateOrderP(dateFormat.format(date), "Глазунов В. М.", "ООО \"УК \"Вишневый сад\"", "Бесхлебнов ", "Раменский район, город Раменское, улица Чугунова, д. 15А");
        assertTrue("Распоряжение с типом Р- не сохранилось", createOrderPage.isOrderCreated());
        System.out.println(orderNumb);
        createOrderPage.userGoToMainPage();
        JournalsPage journalsPage = mainPage.userGoToInstructionsJournal();
        journalsPage.waitForPageInstructionsJournalLoaded();
        journalsPage.userSetOrderNumber(orderNumb);
    }
}
