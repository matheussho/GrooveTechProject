package br.com.web.groove.tech.helpers;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * Classe que navega para a url parametrizada no arquivo config.properties do
 * projeto.
 * 
 * @author Matheus
 *
 */
public class Navigate {

	@Step("Ir para a pagina => {0}")
	public static void navigateToUrl(String url) {
		DriverFactory.driver.navigate().to(url);
	}
}
