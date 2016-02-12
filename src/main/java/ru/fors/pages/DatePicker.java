package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexander Zhaleyko on 27.01.2016.
 */
public class DatePicker extends Page{

    public DatePicker(WebDriver driver) {
        super(driver);
    }
    List<String> monthList = Arrays.asList("Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь");
    boolean dateNotFound;
    WebElement datePicker;
    List<WebElement> noOfColumns;

    public void userSetDate(By calendarIcon, By calheader, By nextMonthButton, By prevMonthButton, By calendar, String date) {
        dateNotFound = true;
        String calMonth = null;
        String calYear = null;
        int i=0;
        while (i<5){
            try{
                click(calendarIcon);
                wait1.until(ExpectedConditions.elementToBeClickable(calheader));
                break;
            }catch (Exception e){
                i=i+1;
            }
        }
        String expDate = date.substring(0, 2);
        int expMonth = Integer.parseInt(date.substring(3, 5));
        int expYear = Integer.parseInt(date.substring(6, date.length()));
        while (dateNotFound) {

            calMonth = getElementText(calheader).substring(getElementText(calheader).indexOf("\n")+1, getElementText(calheader).indexOf(" ",getElementText(calheader).indexOf("\n")));
            System.out.println("calMonth: " + calMonth);
            calYear = (getElementText(calheader).substring(getElementText(calheader).indexOf(" ", getElementText(calheader).indexOf("\n"))+1, getElementText(calheader).indexOf(" ", getElementText(calheader).indexOf("\n"))+5));
            System.out.println("calYear: " + calYear);
            if (monthList.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
                selectDate(expDate, calendar);
                dateNotFound = false;
            } else if (monthList.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))) {
                click(nextMonthButton);
            } else if (monthList.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))) {
                click(prevMonthButton);
            }
        }
    }

    private void selectDate(String expDate, By calendar) {
        datePicker = driver.findElement(calendar);
        noOfColumns = datePicker.findElements(By.cssSelector("td[class*='selectable']"));

        for (WebElement cell : noOfColumns){
            System.out.println(cell.getText());
            if(cell.getText().equals(expDate)){
                        cell.findElement(By.linkText(expDate)).click();
                        break;
                    }
                }

            }
        }



