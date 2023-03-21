package utilities;





import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetup {
	// Getting driver from user. If driver not found then default driver Chrome has been set...
	private static String browserName = System.getProperty("browser" , "firefox");
	private static final ThreadLocal<WebDriver> LOCAL_DRIVER =  new ThreadLocal<>();
	
	
	// Setter method
	public static void setDriver(WebDriver driver) {
		DriverSetup.LOCAL_DRIVER.set(driver);
	}
	
	// Getter method
	public static WebDriver getDriver() {
		return LOCAL_DRIVER.get();
		
	}
	
	
	// Browser setup method
	public static WebDriver getBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			return new ChromeDriver();
			
		case "firefox":
			return new FirefoxDriver();
		
		case "edge":
			return new EdgeDriver();

		default:
			throw new RuntimeException( browserName + " Browser not found !");
		}
		
	}
	
	
	@BeforeClass
	public static synchronized void setBrowser() {
		
		WebDriver webDriver = getBrowser(browserName);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Selenium wait
		setDriver(webDriver);
		
	}
	
	@AfterClass
	public static synchronized void quitBrowser() {
		getDriver().quit();
		
		
	}
	
}










