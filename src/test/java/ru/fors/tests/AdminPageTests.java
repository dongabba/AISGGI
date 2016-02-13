package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.AdminPage;
import ru.fors.pages.ReportsPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by gabba on 13.02.16.
 */
public class AdminPageTests extends TestBase{
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

    @Features("Администрирование")
    @Stories("Страница \"Справочная информация\"")
    @Test
    public void dataOfDocEnteredReportTest() {
        AdminPage adminPage = new AdminPage(driver);
        adminPage.userGoToHelpInfoPage();
        adminPage.waitForHelpInfoPageLoaded();
        assertTrue("Страница \"Справочная информация\" не открылась", adminPage.isHelpPageFormed());
    }
}
