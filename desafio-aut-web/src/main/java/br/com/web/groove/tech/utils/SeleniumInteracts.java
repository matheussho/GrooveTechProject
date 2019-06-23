package br.com.web.groove.tech.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.web.groove.tech.helpers.DriverFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Classe que contem todas as interacoes com os componentes.
 * 
 * Ex. Inputs, Comboboxs, Botoes
 * 
 * @author Matheus
 *
 */
public class SeleniumInteracts {
	@Step("Clica no botao => {1}")
	public static void clickButton(WebElement element, String text) {
		try {
			if (ExplicitWaits.isClickableElement(element)) {
				element.click();
			}
		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}

	}

	@Step("Clica no botao => {1}")
	public static void clickCheckBox(WebElement element, String text) {
		element.click();
	}

	@Step("Preencher Campo => {1}")
	public static void writeInInput(WebElement element, String text) {
		new WebDriverWait(DriverFactory.driver, 35).until(ExpectedConditions.visibilityOf(element));
		if (text != "") {
			element.clear();
			element.sendKeys(text);
		}
	}

	@Step("Preencher Campo => {1}")
	public static void writeInInputMask(WebElement element, String text) {
		ExplicitWaits.waitElementVisibiliy(element);
		if (text != "") {
			while (!element.getAttribute("value").equals(text)) {
				element.clear();
				element.sendKeys(text);
			}
		}
	}

	@Step("Preencher Campo => {1}")
	public static void writeInComboBox(WebElement element, String text) {
		new WebDriverWait(DriverFactory.driver, 35).until(ExpectedConditions.visibilityOf(element));
		if (text != "") {
			element.clear();
			element.sendKeys(text);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element.sendKeys(Keys.TAB);
		}
	}

	@Step("Selecionar o campo Campo => {1}")
	public static void selectElementoByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

}
