package br.com.web.groove.tech.utils;

import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.web.groove.tech.helpers.DriverFactory;

/**
 * Classe que contem os metodos de esperas explicitas.
 * 
 * @author Matheus
 *
 */
public class ExplicitWaits {
	public static void waitElementToBeClickable(WebElement element) {
		try {
			new WebDriverWait(DriverFactory.driver, 35).until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}
	}

	public static void waitElementVisibiliy(WebElement element) {
		try {
			new WebDriverWait(DriverFactory.driver, 35).until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException ex) {
			ex.getMessage();
		}
	}

	public static boolean isClickableElement(WebElement element) {
		boolean existeElemento;
		try {
			waitElementToBeClickable(element);
			return true;
		} catch (NoSuchElementException ex) {
			assertTrue(false);
			existeElemento = false;
		}
		return existeElemento;

	}

	public static boolean isElementExists(WebElement element) {
		boolean elementoExiste;
		try {
			new WebDriverWait(DriverFactory.driver, 35).until(ExpectedConditions.elementToBeClickable(element));
			elementoExiste = true;
		} catch (NoSuchElementException ex) {
			elementoExiste = false;
		}
		return elementoExiste;
	}

}
