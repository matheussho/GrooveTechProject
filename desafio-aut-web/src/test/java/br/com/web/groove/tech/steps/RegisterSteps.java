package br.com.web.groove.tech.steps;

import org.openqa.selenium.WebElement;

import br.com.web.groove.tech.page.RegisterPage;
import br.com.web.groove.tech.utils.ValidationResult;

public class RegisterSteps {

	RegisterPage registerPage = new RegisterPage();
	
	public WebElement divMsgError = registerPage.divMsgError;
	public WebElement h1MyAccount = registerPage.h1MyAccount;

	public void checkAlert() {
		ValidationResult.assertElement(registerPage.divMsgError);
	}

	/**
	 * Metodo de preenchimento do formulario.
	 * 
	 * @param name
	 * @param last
	 * @param password
	 * @param day
	 * @param month
	 * @param year
	 * @param company
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param postCode
	 * @param other
	 * @param phone
	 * @param mobilePhone
	 * @param alias
	 */
	public void registerUser(String name, String last, String password, String day, String month, String year,
			String company, String address1, String address2, String city, String state, String postCode, String other,
			String phone, String mobilePhone, String alias) {
		registerPage.clickTitle();
		if (!name.isEmpty()) {
			registerPage.fillFirstName1(name);
		}
		if (!last.isEmpty()) {
			registerPage.fillLastName1(last);
		}
		if (!name.isEmpty()) {
			registerPage.fillFirstName1(name);
		}
		if (!name.isEmpty()) {
			registerPage.fillPassword(password);
		}

		if (!day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
			registerPage.selectDate(day, month, year);
		}
		registerPage.clickCheckBox();

		if (!company.isEmpty()) {
			registerPage.fillCompany(company);
		}

		if (!address1.isEmpty() && !address2.isEmpty()) {
			registerPage.fillAddress(address1, address2);
		}

		if (!city.isEmpty()) {
			registerPage.fillCity(city);
		}

		if (!state.isEmpty()) {
			registerPage.fillState(state);
		}
		if (!postCode.isEmpty()) {
			registerPage.fillPostCode(postCode);
		}
		if (!other.isEmpty()) {
			registerPage.fillAdditionalInformation(other);
		}

		if (!phone.isEmpty() && !mobilePhone.isEmpty()) {
			registerPage.fillPhones(phone, mobilePhone);
		}
		if (!alias.isEmpty()) {
			registerPage.fillAlias(alias);
		}
		registerPage.clickSubmit();

	}

}
