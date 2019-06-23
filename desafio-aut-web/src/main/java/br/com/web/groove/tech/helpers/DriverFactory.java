package br.com.web.groove.tech.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.web.groove.tech.utils.ConfigUtil;

/**
 * Classe que contem o driver e a inicializacao do navegador.
 * 
 * @author Matheus
 *
 */
public class DriverFactory {
	public static WebDriver driver;

	public DriverFactory() {
		driver = null;
	}

	public static String getBaseUrl() {
		return baseUrl;
	}

	public static void setBaseUrl(String baseUrl) {
		DriverFactory.baseUrl = baseUrl;
	}

	public static String baseUrl;

	public static void iniciarNavegador(String browser) {
		if ("chrome".equalsIgnoreCase(browser)) {
			// System.setProperty("webdriver.chrome.driver",
			// ConfigUtil.readProperty("chrome.driver"));
			driver = getChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.gecko.driver", ConfigUtil.readProperty("firefox.driver"));
			driver = new FirefoxDriver();
		}
		baseUrl = ConfigUtil.readProperty("url");

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	private static WebDriver getChromeDriver() {
		WebDriver driver = new ChromeDriver(getChromeOptions());
		return driver;
	}

	private static ChromeOptions getChromeOptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("window-size=1024,768", "--no-sandbox");
		return option;
	}
}
