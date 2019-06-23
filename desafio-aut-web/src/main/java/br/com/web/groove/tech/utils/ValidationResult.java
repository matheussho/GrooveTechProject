package br.com.web.groove.tech.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.web.groove.tech.helpers.DriverFactory;

/**
 * Classe que contem os asserts pre definidos para os testes.
 * 
 * @author Matheus
 *
 */
public class ValidationResult {
	public static void assertElement(WebElement element) {
		try {
			if (ExplicitWaits.isClickableElement(element)) {
				Utilities.highLightElement(element);
				assertTrue(element.isDisplayed());
			}

		} catch (Exception ex) {
			assertThat(element.getText(), is(element.getText()));
		}
	}

	public static void assertMessageInElement(WebElement element, String mensagem) {
		try {
			new WebDriverWait(DriverFactory.driver, 35)
					.until(ExpectedConditions.textToBePresentInElement(element, mensagem));
			Utilities.highLightElement(element);
			assertTrue(element.getText().contains(mensagem));
			Screenshot.saveImageAttach("Mensagem esperada: " + mensagem + " apareceu !!");
		} catch (Exception ex) {
			Screenshot.saveImageAttach("Erro encontrado: " + mensagem);
			assertThat(element.getText(), is(mensagem));
		}
	}

}
