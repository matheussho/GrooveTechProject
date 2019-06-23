package br.com.web.groove.tech.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.web.groove.tech.helpers.DriverFactory;
import br.com.web.groove.tech.utils.SeleniumInteracts;
import br.com.web.groove.tech.utils.ValidationResult;

/**
 * 
 * Page autenticacao e-mail
 * 
 * @author Matheus
 *
 */
public class AuthenticationPage {

	public AuthenticationPage() {
		PageFactory.initElements(DriverFactory.driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='header_user_info']/a")
	public WebElement btnSignIn;

	@FindBy(how = How.ID, using = "email_create")
	public WebElement txtEmail;

	@FindBy(how = How.ID, using = "SubmitCreate")
	public WebElement btnSubmitCreate;

	@FindBy(how = How.XPATH, using = "//div/h1")
	public WebElement divAuthentication;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
	public WebElement divMsgError;

	public void checkLabel() {
		ValidationResult.assertElement(divAuthentication);
	}

	public void clickSignIn() {
		SeleniumInteracts.clickButton(btnSignIn, btnSignIn.getText());
	}

	public void fillEmail(String email) {
		SeleniumInteracts.writeInInput(txtEmail, email);
	}

	public void clickSubmit() {
		SeleniumInteracts.clickButton(btnSubmitCreate, btnSubmitCreate.getText());
	}

	/**
	 * Metodo que realiza o preenchimento do e-mail.
	 * 
	 * @param email
	 */
	public void authenticateEmail(String email) {
		clickSignIn();
		if (!email.isEmpty()) {
			fillEmail(email);
		}
		clickSubmit();
	}

}
