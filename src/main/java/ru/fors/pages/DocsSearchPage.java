package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class DocsSearchPage extends MainMenu {
    public DocsSearchPage(WebDriver driver) {
        super(driver);
    }

    By docsSearchPageTitle = By.xpath("//h3[text()='Документы инспекционной деятельности']");
    By searchButton = By.xpath("//button[text()='Искать']");
    By resultsTable = By.xpath("//*[@class='table-wrap']//tbody/tr[1]");

    public void waitForDocsSearchPageLoaded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(docsSearchPageTitle));
    }

    public void userFormedPage(){
        click(searchButton);
    }
    @Step("Проверяем сформировалась ли таблица с результатами")
    public boolean isPageDocsSearchFormed(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTable));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
