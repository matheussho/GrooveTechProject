package br.com.web.groove.tech.base;

import org.junit.Before;

import br.com.web.groove.tech.helpers.DriverFactory;
import br.com.web.groove.tech.helpers.Navigate;
import br.com.web.groove.tech.utils.ConfigUtil;

/**
 * Classe base para todos os testes
 * 
 * @author Matheus
 *
 */
public class BaseTest {
	public BaseTest() {
		if (DriverFactory.driver == null) {
			DriverFactory.iniciarNavegador(ConfigUtil.readProperty("chrome"));
		}
	}

	@Before
	public void setUp() {
		DriverFactory.driver.manage().deleteAllCookies();
		openPage();
	}

	// @AfterClass
	// public static void tearDown() {
	// DriverFactory.driver.quit();
	// }

	public void openPage() {
		Navigate.navigateToUrl(DriverFactory.baseUrl);
	}
}
