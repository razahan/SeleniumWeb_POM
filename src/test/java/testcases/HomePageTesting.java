package testcases;

import static org.testng.Assert.assertEquals;

//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.DarazHomePage;
import pages.DarazLogInPage;
import utilities.DriverSetup;

public class HomePageTesting extends DriverSetup {
	
	DarazHomePage darazHomePage = new DarazHomePage();
	DarazLogInPage darazLogInPage =  new DarazLogInPage();
	
	
	@Test (description = "Homepage testing with credential")
	@Description ("Homepage testing with credential from allure...!")
	public void TestHomePageTitle() throws InterruptedException {
		
		getDriver().get("https://www.daraz.com.bd/");
		assertEquals(getDriver().getTitle(), darazHomePage.HOMEPAGE_TITLE);
//		WebElement loginbtn = darazHomePage.getElement(darazHomePage.SIGNUP_LOGIN_BUTTON);
//		loginbtn.click();
		System.out.println(darazHomePage.getElementText(darazHomePage.SIGNUP_LOGIN_BUTTON));
		darazHomePage.takeScreenShot("HomePage");  // ScreenShot with allure tools
		darazHomePage.clickOnElement(darazHomePage.SIGNUP_LOGIN_BUTTON);
		darazLogInPage.doLogIn("01770959081", "13234961");
		darazHomePage.takeScreenShot("HomePageLogIn");   // ScreenShot with allure tools
		
		
		
		Thread.sleep(2000);
		
	}
	
	

}










































