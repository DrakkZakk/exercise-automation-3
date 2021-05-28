package framework;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUp {
	
	WebDriver driver;
	ConfigJSONReader configFile;
	String price;
	ArrayList<String> list;
	int num = 1;

	public WebDriver setUpBrowser() {
		configFile = new ConfigJSONReader();
		String url = configFile.readJSON().get(0);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public void clickElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void sendText(WebElement element, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);
		}catch(StaleElementReferenceException e) {
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void setPrice(WebElement element) {
		this.price = element.getText();
		list = new ArrayList<String>();
		list.add(price);
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void comparePrices(WebElement element) {
		String secondPrice = element.getText();
		String[] temp = secondPrice.split("\\$|\\.");
		Assert.assertEquals(list.get(0), temp[1]);
	}
	
	public void validateShopCar(WebElement element) {
		String expected = Integer.toString(num);
		Assert.assertEquals(expected, element.getText());
		num++;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
}
