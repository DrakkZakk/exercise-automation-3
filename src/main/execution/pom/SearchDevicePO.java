package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.CreateBrowser;

public class SearchDevicePO extends CreateBrowser {
	
	String firstPrice;
	
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(how = How.CSS, using = "div.nav-search-submit.nav-sprite")
	WebElement clickSearchBtn;
	
	@FindBy(how = How.XPATH, using = "//div[starts-with(@data-asin, 'B0')]//child::img[@data-image-index='1']")
	WebElement device;
	
	@FindBy(how = How.XPATH, using = "//div[starts-with(@data-asin, 'B0') and @data-cel-widget = 'search_result_0' or @data-cel-widget = 'search_result_1' ]//span[@class='a-price-whole']")
	WebElement price;
	
	@FindBy(how = How.ID, using = "priceblock_ourprice")
	WebElement detailPrice;
	
	@FindBy(how = How.ID, using = "add-to-cart-button")
	WebElement addToCartBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='hlb-subcart']//*[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	WebElement lastPrice;
	
	@FindBy(how = How.ID, using = "nav-cart-count")
	WebElement shopCar;
	
	public SearchDevicePO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public SearchDevicePO searchDevice(String device) {
		setup.sendText(searchBar, device);
		setup.clickElement(clickSearchBtn);
		return this;
	}
	
	public SearchDevicePO selectDevice() {
		setup.setPrice(price);
		setup.clickElement(device);
		return this;
	}
	
	public SearchDevicePO compareDetailedPrices() {
		setup.comparePrices(detailPrice);
		return this;
	}
	
	public SearchDevicePO addToCart() {
		setup.clickElement(addToCartBtn);
		return this;
	}
	
	public SearchDevicePO compareLastPrice() {
		setup.comparePrices(lastPrice);
		return this;
	}
	
	public SearchDevicePO verifyShopCar() {
		setup.validateShopCar(shopCar);
		return this;
	}
	
	public SearchDevicePO quitBrowser() {
		setup.closeBrowser();
		return this;
	}
	
}
