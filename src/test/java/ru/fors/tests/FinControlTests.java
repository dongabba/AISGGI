package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.FinControlPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class FinControlTests extends TestBase{
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

    @Features("Финансовый контроль")
    @Stories("Начисления")
    @Test
    public void profitTest() throws InterruptedException {
        System.out.println("Start: profitTest");
        FinControlPage finControlPage = new FinControlPage(driver);
        finControlPage.userGoToProfitPage();
        finControlPage.waitForProfitPageLoaded();
        finControlPage.userFormedPage();
        assertTrue("Данные не сформировались за 1 минуту", finControlPage.isProfitPageFormed());
        System.out.println("Finish: profitTest");
    }

    @Features("Финансовый контроль")
    @Stories("Платежи")
    @Test
    public void paymentsTest() throws InterruptedException {
        System.out.println("Start: paymentsTest");
        FinControlPage finControlPage = new FinControlPage(driver);
        finControlPage.userGoToPaymentsPage();
        finControlPage.waitForPaymentsPageLoaded();
        finControlPage.userFormedPage();
        assertTrue("Данные не сформировались за 1 минуту", finControlPage.isPaymentsPageFormed());
        System.out.println("Finish: paymentsTest");
    }

    @Features("Финансовый контроль")
    @Stories("Заявки на возврат")
    @Test
    public void applicationsForRefundTest() throws InterruptedException {
        System.out.println("Start: applicationsForRefundTest");
        FinControlPage finControlPage = new FinControlPage(driver);
        finControlPage.userGoToApplicationsForRefundPage();
        finControlPage.waitForApplicationsForRefundPageLoaded();
        finControlPage.userFormedPage();
        assertTrue("Данные не сформировались за 1 минуту", finControlPage.isApplicationsForRefundPageFormed());
        System.out.println("Finish: applicationsForRefundTest");
    }

    @Features("Финансовый контроль")
    @Stories("Связывание начислений и платежей")
    @Test
    public void profitAndPaymentsTest() throws InterruptedException {
        System.out.println("Start: profitAndPaymentsTest");
        FinControlPage finControlPage = new FinControlPage(driver);
        finControlPage.userGoToProfitAndPaymentsPage();
        finControlPage.waitForProfitAndPaymentsPageLoaded();
        finControlPage.userFormedPage();
        assertTrue("Данные не сформировались за 1 минуту", finControlPage.isProfitAndPaymentsPageFormed());
        System.out.println("Finish: profitAndPaymentsTest");
    }

    @Features("Финансовый контроль")
    @Stories("Финансовые показатели")
    @Test
    public void financeTest() throws InterruptedException {
        System.out.println("Start: financeTest");
        FinControlPage finControlPage = new FinControlPage(driver);
        finControlPage.userGoToFinancePage();
        finControlPage.waitForFinancePageLoaded();
        assertTrue("Данные не сформировались за 1 минуту", finControlPage.isFinancePageFormed());
        System.out.println("Finish: financeTest");
    }
}

