package execution;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.LoginPagePO;
import pom.SearchDevicePO;

public class TestCase {
	
	HomePage home;
	LoginPagePO login;
	SearchDevicePO search;

	 @BeforeTest
	public void beforeTest() {
		home = new HomePage();
		login = new LoginPagePO();
		search = new SearchDevicePO();
	}
	 
	 @Test
	 public void testCase() {
		 home.GoToHomePage();
		 login.enterEmail();
		 login.enterPassword();
		 search.searchDevice("Samsung S21");
		 search.selectDevice();
		 search.compareDetailedPrices();
		 search.addToCart();
		 search.compareLastPrice();
		 search.verifyShopCar();
		 
		 search.searchDevice("Alienware AW2518HF");
		 search.selectDevice();
		 search.addToCart();
		 search.verifyShopCar();
	 }
	 
	 @AfterTest
	 public void afterTest() {
		 
	 }
}
