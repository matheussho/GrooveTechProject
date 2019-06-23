package br.com.web.groove.tech.tests;

import org.junit.Test;

import br.com.web.groove.tech.data.TestData;
import br.com.web.groove.tech.steps.AuthenticationSteps;
import br.com.web.groove.tech.utils.ValidationResult;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

@Title("SUITE_001 - AUTENTICAR CONTA DE E-MAIL")
@Features("001 - VALIDAR E-MAIL")
public class AuthenticateEmailTest {
	
	AuthenticationSteps authetication = new AuthenticationSteps();

	@Test
	@Title("[SMOKETEST - 001] - Verificar E-mail ja cadastrado na base")
	public void testVerificarEmailExistente() {
		authetication.authenticateEmail(TestData.emailIsExists);
		// Verifica se o alert apareceu na tela.
		ValidationResult.assertMessageInElement(authetication.divMsgError,
				"An account using this email address has already been registered. Please enter a valid password or request a new one");
	}
	
	@Test
	@Title("[SMOKETEST - 002] - Verificar se o sistema aceita E-mail em branco")
	public void testVerificarEmailEmBranco() {
		String emailNull = "";
		authetication.authenticateEmail(emailNull);
		// Verifica se o alert apareceu na tela.
		ValidationResult.assertMessageInElement(authetication.divMsgError,
				"Invalid email address.");
	}
	
	@Test
	@Title("[SMOKETEST - 003] - Verificar se o sistema aceita E-mail invalido")
	public void testVerificarEmailInvalido() {
		String emailInvalid = "teste.com.br";
		authetication.authenticateEmail(emailInvalid);
		// Verifica se o alert apareceu na tela.
		ValidationResult.assertMessageInElement(authetication.divMsgError,
				"Invalid email address.");
	}

}
