package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.InspectionsPlanPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class InspectionsPlanTests extends TestBase {
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

    @Features("План проведения проверок")
    @Stories("План проверок ЮЛ/ИП")
    @Test
    public void jurAndIpPlanTest() throws InterruptedException {
        System.out.println("Start: jurAndIpPlanTest");
        InspectionsPlanPage inspectionsPlanPage = new InspectionsPlanPage(driver);
        inspectionsPlanPage.userGoToJurAndIpPlanPage();
        assertTrue("Данные не сформировались за 1 минуту", inspectionsPlanPage.isJurAndIpPlanPageFormed());
        System.out.println("Finish: jurAndIpPlanTest");
    }
}
