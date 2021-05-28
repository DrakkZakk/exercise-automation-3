package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateBrowser {
	
	protected static SetUp setup;
	protected static WebDriver driver;
	
	public CreateBrowser() {
		if(driver == null) {
			setup = new SetUp();
			driver = setup.setUpBrowser();
			PageFactory.initElements(driver, this);
		}
	}
}
