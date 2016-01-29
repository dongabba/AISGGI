package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Alexander Zhaleyko on 28.01.2016.
 */
public class NsiForms extends Page{
    public NsiForms(WebDriver driver) {
        super(driver);
    }
    By addSubjectWindowTitle = By.xpath("//h3[text()='Поиск физических лиц']");
    By subjectName = By.cssSelector("input[name*=\"content:form:searchConditionPanel:searchConditionForm:searchConditionTabs:panel:fio\"]");
    By findSubjectButton = By.linkText("Искать");
    By firstSearchResultInAddSubjectWindow = By.xpath("//div[@class='nsi-result-find']//td[2]");
    By selectButton = By.xpath("//div[@class='nsi-buttons-panel']//span[text()='Выбрать']");

    public void userSelectSubject(String name){
        wait.until(ExpectedConditions.presenceOfElementLocated(addSubjectWindowTitle));
        type(subjectName, name);
        click(findSubjectButton);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(firstSearchResultInAddSubjectWindow, name));
        click(firstSearchResultInAddSubjectWindow);
        int i=0;
        while (i<5){
            try{
                click(selectButton);
                wait1.until(ExpectedConditions.invisibilityOfElementLocated(addSubjectWindowTitle));
                break;
            }catch (Exception e){
                i=i+1;
            }
        }
    }
}
