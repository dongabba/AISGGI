package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends Page {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	By userRole = By.cssSelector(".page-title__arm");
	By logoutLink = By.linkText("Выход");
	By createOrderP = By.linkText("  Создать распоряжение Р-");

	//=======Меню Журналы и реестры========
	By journalsAnrRegistryLink = By.linkText("Журналы и реестры");

	//=======Инспекционные журналы=======
	By inspJourlalsLink = By.linkText("Инспекционные журналы");
	By instructionsJournal = By.linkText("Журнал распоряжений");

	public MainPage waitForPageLoaded(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(userRole));
		return this;
	}
	@Step("Проверяем роль пользователя")
	public String getUserRole(){
		waitForPageLoaded();
		return getElementText(userRole);
	}
	
	@Step("Пользователь выходит из системы")
	public LoginPage userLogOut(){
		click(logoutLink);
		return new LoginPage(driver);
	}

	@Step("Переходим к странице создания распоряжения Р-")
	public OrderPage userCreateOrderP(){
		waitForPageLoaded();
		click(createOrderP);
		return new OrderPage(driver);
	}

	//Журнал распоряжений
	@Step("Переходим на страницу \"Журнал распоряжений\"")
	public JournalsPage userGoToInstructionsJournal(){
		clickOn3Link(journalsAnrRegistryLink, inspJourlalsLink, instructionsJournal);
		return new JournalsPage(driver);
	}
}
