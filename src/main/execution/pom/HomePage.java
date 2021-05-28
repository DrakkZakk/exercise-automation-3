package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.CreateBrowser;

public class HomePage extends CreateBrowser {
	
	@FindBy(how = How.ID, using = "nav-link-accountList")
	WebElement loginBtn;
	
	public HomePage() {
		super();
	}
	
	public HomePage GoToHomePage() {
		setup.clickElement(loginBtn);
		return this;
	}
	
}
