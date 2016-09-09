package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleyko on 12.02.2016.
 */
public class InspectionsPlanPage extends MainMenu{

    public InspectionsPlanPage(WebDriver driver) {
        super(driver);
    }
    By jurAndIpPlanTitle = By.xpath("//h3[text()='Планы проведения проверок']");

    private boolean isPageFormed(By element){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Step("Проверяем открылась ли страница \"Планы проведения проверок\"")
    public boolean isJurAndIpPlanPageFormed(){
        return isPageFormed(jurAndIpPlanTitle);
    }

}
