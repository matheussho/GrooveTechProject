package br.com.web.groove.tech.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.web.groove.tech.helpers.DriverFactory;
import br.com.web.groove.tech.utils.SeleniumInteracts;

public class RegisterPage {
	public RegisterPage() {
		PageFactory.initElements(DriverFactory.driver, this);
	}

	@FindBy(how = How.ID, using = "id_gender1")
	public WebElement rdBtnMr;

	@FindBy(how = How.ID, using = "id_gender2")
	public WebElement rdBtnMrs;

	@FindBy(how = How.ID, using = "customer_firstname")
	public WebElement txtFirstName;

	@FindBy(how = How.ID, using = "customer_lastname")
	public WebElement txtLastName;

	@FindBy(how = How.ID, using = "passwd")
	public WebElement txtPassword;

	@FindBy(how = How.ID, using = "days")
	public WebElement slcDay;

	@FindBy(how = How.ID, using = "months")
	public WebElement slcMonth;

	@FindBy(how = How.ID, using = "years")
	public WebElement slcYear;

	@FindBy(how = How.XPATH, using = "//div/span/input[@id='newsletter']")
	public WebElement chkNewsLetter;

	@FindBy(how = How.ID, using = "optin")
	public WebElement chkOptin;

	@FindBy(how = How.ID, using = "company")
	public WebElement txtCompany;

	@FindBy(how = How.ID, using = "address1")
	public WebElement txtAddress1;

	@FindBy(how = How.ID, using = "address2")
	public WebElement txtAddress2;

	@FindBy(how = How.ID, using = "city")
	public WebElement txtCity;

	@FindBy(how = How.ID, using = "id_state")
	public WebElement slcState;

	@FindBy(how = How.ID, using = "postcode")
	public WebElement txtPostcode;

	@FindBy(how = How.ID, using = "id_country")
	public WebElement slcCountry;

	@FindBy(how = How.ID, using = "other")
	public WebElement txtOther;

	@FindBy(how = How.ID, using = "phone")
	public WebElement txtHomePhone;

	@FindBy(how = How.ID, using = "phone_mobile")
	public WebElement txtMobilePhone;

	@FindBy(how = How.ID, using = "alias")
	public WebElement txtAlias;

	@FindBy(how = How.ID, using = "submitAccount")
	public WebElement btnSubmitAccount;

	@FindBy(how = How.XPATH, using = "//h1")
	public WebElement h1MyAccount;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
	public WebElement divMsgError;

	public void clickTitle() {
		SeleniumInteracts.clickButton(rdBtnMr, rdBtnMr.getText());
	}

	public void fillFirstName1(String name) {
		SeleniumInteracts.writeInInput(txtFirstName, name);
	}

	public void fillLastName1(String name) {
		SeleniumInteracts.writeInInput(txtLastName, name);
	}

	public void fillPassword(String password) {
		SeleniumInteracts.writeInInput(txtPassword, password);
	}

	public void selectDate(String day, String month, String year) {
		SeleniumInteracts.selectElementoByValue(slcDay, day);
		SeleniumInteracts.selectElementoByValue(slcMonth, month);
		SeleniumInteracts.selectElementoByValue(slcYear, year);
	}

	public void clickCheckBox() {
		SeleniumInteracts.clickCheckBox(chkNewsLetter, chkNewsLetter.getText());
		SeleniumInteracts.clickCheckBox(chkOptin, chkOptin.getText());
	}

	public void fillCompany(String company) {
		SeleniumInteracts.writeInInput(txtCompany, company);
	}

	public void fillAddress(String address1, String address2) {
		SeleniumInteracts.writeInInput(txtAddress1, address1);
		SeleniumInteracts.writeInInput(txtAddress2, address2);
	}

	public void fillCity(String city) {
		SeleniumInteracts.writeInInput(txtCity, city);
	}

	public void fillState(String state) {
		SeleniumInteracts.selectElementoByValue(slcState, state);
	}

	public void fillPostCode(String postCode) {
		SeleniumInteracts.writeInInput(txtPostcode, postCode);
	}

	public void fillAdditionalInformation(String other) {
		SeleniumInteracts.writeInInput(txtOther, other);
	}

	public void fillPhones(String phone, String mobilePhone) {
		SeleniumInteracts.writeInInput(txtHomePhone, phone);
		SeleniumInteracts.writeInInput(txtMobilePhone, mobilePhone);
	}

	public void fillAlias(String alias) {
		SeleniumInteracts.writeInInput(txtAlias, alias);
	}

	public void clickSubmit() {
		SeleniumInteracts.clickButton(btnSubmitAccount, btnSubmitAccount.getText());
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
		clickTitle();
		if (!name.isEmpty()) {
			fillFirstName1(name);
		}
		if (!last.isEmpty()) {
			fillLastName1(last);
		}
		if (!name.isEmpty()) {
			fillFirstName1(name);
		}
		if (!name.isEmpty()) {
			fillPassword(password);
		}

		if (!day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
			selectDate(day, month, year);
		}
		clickCheckBox();

		if (!company.isEmpty()) {
			fillCompany(company);
		}

		if (!address1.isEmpty() && !address2.isEmpty()) {
			fillAddress(address1, address2);
		}

		if (!city.isEmpty()) {
			fillCity(city);
		}

		if (!state.isEmpty()) {
			fillState(state);
		}
		if (!postCode.isEmpty()) {
			fillPostCode(postCode);
		}
		if (!other.isEmpty()) {
			fillAdditionalInformation(other);
		}

		if (!phone.isEmpty() && !mobilePhone.isEmpty()) {
			fillPhones(phone, mobilePhone);
		}
		if (!alias.isEmpty()) {
			fillAlias(alias);
		}
		clickSubmit();

	}

}
