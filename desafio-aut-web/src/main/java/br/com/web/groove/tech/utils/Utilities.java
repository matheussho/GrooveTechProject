package br.com.web.groove.tech.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.com.web.groove.tech.helpers.DriverFactory;

/**
 * Classe que contem metodos utilitarios para os testes.
 * 
 * @author Matheus
 *
 */
public class Utilities {
	public static void highLightElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.driver;
			js.executeScript("arguments[0].style.border='3px solid blue'", element);
		} catch (Exception e) {

		}
	}
}
