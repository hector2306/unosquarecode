package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Core.Method;

public class BasePage extends Method {
	
	private WebDriver driver;
	
	public BasePage (WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	

}
