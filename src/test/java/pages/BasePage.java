package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;

import static utilities.DriverSetup.getDriver;

import java.io.ByteArrayInputStream;

public class BasePage {
	
	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
	}
	
	public void clickOnElement(By locator) {
		getElement(locator).click();
		
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}
	
	public void writeTextOnElement(By locator, String text) {
		getElement(locator).sendKeys(text);
		
	}
	
	public void takeScreenShot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES) ));
	}

}
