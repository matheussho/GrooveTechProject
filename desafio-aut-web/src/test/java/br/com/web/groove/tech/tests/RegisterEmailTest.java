package br.com.web.groove.tech.tests;

import org.junit.Test;

import br.com.web.groove.tech.base.BaseTest;
import br.com.web.groove.tech.data.TestData;
import br.com.web.groove.tech.steps.AuthenticationSteps;
import br.com.web.groove.tech.steps.RegisterSteps;
import br.com.web.groove.tech.utils.Generator;
import br.com.web.groove.tech.utils.ValidationResult;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

@Title("SUITE_002 - REGISTRAR CONTA DE E-MAIL")
@Features("002 - VALIDAR FORMULARIO REGISTRO E-MAIL")
public class RegisterEmailTest extends BaseTest {

	AuthenticationSteps authetication = new AuthenticationSteps();
	RegisterSteps register = new RegisterSteps();

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

}
