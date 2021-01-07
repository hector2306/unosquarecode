package Core;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method {
	
	static WebDriver driver;
	
	public Method() {
		driver = SetUp.GetDriver();
	}
	
	public static WebElement waitElementToBePresent(WebElement element) {
		WebElement Element= (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
		return (WebElement) Element;
	}
	
	public static List <WebElement> waitElementsToBePresent(List <WebElement> element) {
		List <WebElement> Elements= (List<WebElement>) (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElements(element));
		return  Elements;
	}
	
	
	public static WebElement waitElementToBeClickable(WebElement element) {
		WebElement Element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
		return (WebElement) Element;
	}
	
	public static void clickElement(WebElement element) {
		waitElementToBeClickable(element).click();
	}
	
	public static void sendText(WebElement element, String Text) {
		waitElementToBeClickable(element).sendKeys(Text);
	}
	
	public static void sendText(WebElement element, Keys Text) {
		waitElementToBeClickable(element).sendKeys(Text);
	}
	
	public static void elementIsDisplaying(WebElement element) {
		waitElementToBePresent(element);
	}
	
	public static void clearText(WebElement element) {
		waitElementToBeClickable(element).clear();
	}
	
	public static  String getText(WebElement element) {
		return waitElementToBePresent(element).getText();
	}
	
	
	
	

}
