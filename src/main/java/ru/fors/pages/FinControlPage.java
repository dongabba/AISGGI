package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class FinControlPage extends MainMenu{
    public FinControlPage(WebDriver driver) {
        super(driver);
    }

    By profitTitle = By.xpath("//h3[text()='Начисления']");
    By paymentsTitle = By.xpath("//h3[text()='Платежи']");
    By applicationsForRefundTitle = By.xpath("//h3[text()='Заявки на возврат']");
    By profitAndPaymentsTitle = By.xpath("//h3[text()='Связывание начислений и платежей']");
    By financeTitle = By.xpath("//h3[text()='Финансовые показатели по подразделениям ГЖИ МО (руб)']");
    By findButton = By.xpath("//button[text()='Искать']");
    By resultTable = By.xpath("//*[@class='table-wrap']//tbody/tr[1]");
    By financePageResult = By.xpath("//td[text()='Госжилинспекция Московской области']");

    public void userFormedPage(){
        click(findButton);
    }

    private FinControlPage waitForPageLoaded(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }
    public void waitForProfitPageLoaded(){
        waitForPageLoaded(profitTitle);
    }

    public void waitForPaymentsPageLoaded(){
        waitForPageLoaded(paymentsTitle);
    }

    public void waitForApplicationsForRefundPageLoaded(){
        waitForPageLoaded(applicationsForRefundTitle);
    }

    public void waitForProfitAndPaymentsPageLoaded(){
        waitForPageLoaded(profitAndPaymentsTitle);
    }

    public void waitForFinancePageLoaded(){
        waitForPageLoaded(financeTitle);
    }

    private boolean isPageFormed(By element){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isProfitPageFormed(){
        return isPageFormed(resultTable);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isPaymentsPageFormed(){
        return isPageFormed(resultTable);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isApplicationsForRefundPageFormed(){
        return isPageFormed(resultTable);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isProfitAndPaymentsPageFormed(){
        return isPageFormed(resultTable);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isFinancePageFormed(){
        return isPageFormed(financePageResult);
    }
}
