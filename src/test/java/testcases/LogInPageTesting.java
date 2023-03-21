package testcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.DarazLogInPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class LogInPageTesting extends DriverSetup {
	
	DarazLogInPage logInPage = new DarazLogInPage();
	
	
	
	
	
	//For invalid Username ----------------	
	
	@Test (description = "Login page testing with invalid username credential !")
	public void testLogInWithInValidCredentialUserName() throws InterruptedException {
		getDriver().get(logInPage.LOGINPAGE_URL);
		logInPage.doLogIn("121212121", "123srb456");
		assertEquals(logInPage.getElementText(logInPage.ERROR_MESSAGE), logInPage.ERROR_MESSAGE_Phone_Number_TEXT);
		
		Thread.sleep(2000);
		
		
	}
	
	//For invalid password----------------	
	@Test (description = "Login page testing with invalid password credential !")
	public void testLogInWithInValidCredentialPassword() throws InterruptedException {
		getDriver().get(logInPage.LOGINPAGE_URL);
		logInPage.doLogIn("wearhanger016@gmail.com", "4566546");
		assertEquals(logInPage.getElementText(logInPage.ERROR_MESSAGE), logInPage.ERROR_MESSAGE_PASSWORD_TEXT);
		
		Thread.sleep(2000);
		
		
	}
	
	@Test (dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
	public void testLogInWithInValidCredentialUsingDataProvider(String username, String password, String message) throws InterruptedException {
		getDriver().get(logInPage.LOGINPAGE_URL);
		logInPage.doLogIn(username, password);
		assertEquals(logInPage.getElementText(logInPage.ERROR_MESSAGE), message);
		
		Thread.sleep(2000);
	}
	
	
	@Test (description = "Login page testing with valid credential !")
	@Description ("Login page testing with valid credential from allure...!")
	public void testLogInWithValidCredential() throws InterruptedException {
		getDriver().get(logInPage.LOGINPAGE_URL);
		logInPage.doLogIn("wearhanger016@gmail.com", "123srb456");
		
		Thread.sleep(2000);
		
		
	}

}










































