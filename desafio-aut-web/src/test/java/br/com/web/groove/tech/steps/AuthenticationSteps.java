package br.com.web.groove.tech.steps;

import br.com.web.groove.tech.page.AuthenticationPage;

public class AuthenticationSteps {

	AuthenticationPage authenticationPage = new AuthenticationPage();
	
	/**
	 * Metodo que realiza o preenchimento do e-mail.
	 * @param email
	 */
	public void authenticateEmail(String email) {
		authenticationPage.clickSignIn();
		if (!email.isEmpty()) {
			authenticationPage.fillEmail(email);
		}
		authenticationPage.clickSubmit();
	}
}
