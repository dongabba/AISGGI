package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.CreateOrderPage;
import ru.fors.pages.LoginPage;
import ru.fors.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

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
        createOrderPage.userCreateOrderP(dateFormat.format(date), "Глазунов В. М.", "Веста-комфорт", "Бесхлебнов ", "Раменский район, город Раменское, улица Чугунова, д. 15А");
    }
}
