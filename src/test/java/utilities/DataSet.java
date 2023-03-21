package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
	
	
	@DataProvider (name="invalidCredentials")
	public static Object logindataset() {
		Object[][] objects = {{"121212121", "123srb456","Please enter a valid phone number."},
		                     {"wearhanger016@gmail.com", "4566546", "Incorrect username or password."}
								};
		return objects;
	}

}
