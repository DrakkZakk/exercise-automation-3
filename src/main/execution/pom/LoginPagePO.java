package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.ConfigJSONReader;
import framework.CreateBrowser;

public class LoginPagePO extends CreateBrowser {
	
	ConfigJSONReader configFile;
	
	@FindBy(how = How.NAME, using = "email")
	WebElement userInput;
	
	@FindBy(how = How.ID, using = "continue")
	WebElement continueBtn;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement userPwd;
	
	@FindBy(how = How.ID, using = "signInSubmit")
	
	WebElement loginBtn;
	
	public LoginPagePO() {
		super();
		configFile = new ConfigJSONReader();
		PageFactory.initElements(driver, this);
	}
	
	public LoginPagePO enterEmail() {
		String username = configFile.readJSON().get(1);
		setup.sendText(userInput, username);
		setup.clickElement(continueBtn);
		return this;
	}
	
	public LoginPagePO enterPassword() {
		String password = configFile.readJSON().get(2);
		setup.sendText(userPwd, password);
		setup.clickElement(loginBtn);
		return this;
	}
	
}
