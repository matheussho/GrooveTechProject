package br.com.web.groove.tech.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.web.groove.tech.helpers.DriverFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Classe que contem os metodos de screenshot para o report Allure.
 * 
 * @author Matheus
 *
 */
public class Screenshot {
	@Attachment(value = "{0}", type = "image/png")
	public static byte[] saveImageAttach(String attachName) {
		try {
			File imageFile = (File) ((TakesScreenshot) DriverFactory.driver).getScreenshotAs(OutputType.FILE);
			return toByteArray(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new byte[0];
	}

	private static byte[] toByteArray(File file) throws IOException {
		return Files.readAllBytes(Paths.get(file.getPath()));
	}
}
