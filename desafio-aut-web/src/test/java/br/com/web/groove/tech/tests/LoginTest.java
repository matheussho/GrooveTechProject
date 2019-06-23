package br.com.web.groove.tech.tests;

import org.junit.Test;

import br.com.web.groove.tech.base.BaseTest;
import br.com.web.groove.tech.data.TestData;
import br.com.web.groove.tech.page.AuthenticationPage;
import br.com.web.groove.tech.page.RegisterPage;
import br.com.web.groove.tech.utils.Generator;
import br.com.web.groove.tech.utils.ValidationResult;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

@Title("SUITE_001 - REGISTRAR CONTA DE E-MAIL")
@Features("001 - REGISTRAR CONTA E-MAIL COM SUCESSO")
public class LoginTest extends BaseTest {

	AuthenticationPage authetication = new AuthenticationPage();
	RegisterPage register = new RegisterPage();

	@Test
	@Title("[SMOKETEST - 001] - Registrar conta e-mail com sucesso")
	public void testRealizarCadastroComSucesso() {
		authetication.authenticateEmail(TestData.email);
		register.registerUser(TestData.firstName, TestData.lastName, TestData.password, TestData.day, TestData.month,
				TestData.year, TestData.company, TestData.address1, TestData.address2, TestData.city, TestData.state,
				TestData.postalCode, TestData.informationAdditional, TestData.homePhone, TestData.mobilePhone,
				TestData.alias);
		// Verifica se o My Account apareceu na tela.
		ValidationResult.assertElement(register.h1MyAccount);
	}

	@Test
	@Title("[SMOKETEST - 002] - Verificar Obrigatoriedade Password")
	public void testVerificarObrigatoriedadePassword() {
		String passwordIsEmpty = "";
		authetication.authenticateEmail(Generator.gerarStringAleatoria() + "@gmail.com");
		register.registerUser(TestData.firstName, TestData.lastName, passwordIsEmpty, TestData.day, TestData.month,
				TestData.year, TestData.company, TestData.address1, TestData.address2, TestData.city, TestData.state,
				TestData.postalCode, TestData.informationAdditional, TestData.homePhone, TestData.mobilePhone,
				TestData.alias);
		// Verifica se o alert apareceu na tela.
		ValidationResult.assertMessageInElement(register.divMsgError, "passwd is required.");
	}

	@Test
	@Title("[SMOKETEST - 003] - Verificar E-mail ja cadastrado na base")
	public void testVerificarEmailExistente() {
		authetication.authenticateEmail(TestData.emailIsExists);
		// Verifica se o alert apareceu na tela.
		ValidationResult.assertMessageInElement(authetication.divMsgError,
				"An account using this email address has already been registered. Please enter a valid password or request a new one");
	}

}
