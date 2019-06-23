package br.com.web.groove.tech.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Classe de configuracao para leitura do arquivo config.properties
 * 
 * @author Matheus
 *
 */
public class ConfigUtil {
	private ConfigUtil() {
	}

	/**
	 * Ler a propriedade do arquivo config.properties
	 * 
	 * @param property
	 * @return
	 */
	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));

			value = prop.getProperty(property);

			if (value == null || value.isEmpty()) {
				throw new Exception("Valor nāo definido ou vazio");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

}
