package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_0']")
	private WebElement microsoft365btn;
	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_1']")
	private WebElement Officebtn;
	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_2']")
	private WebElement windowsbtn;
	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_3']")
	private WebElement surfacebtn;
	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_4']")
	private WebElement xboxbtn;
	
	@FindBy(how=How.XPATH,using="//a[@id='shellmenu_5']")
	private WebElement dealsbtn;
	
	@FindBy(how=How.XPATH,using="//a[@id='l1_support']")
	private WebElement supportbtn;
	
	@FindBy(how=How.XPATH,using="//button[@id='c-shellmenu_54']")
	private WebElement windows10btn;
	
	@FindBy(how=How.XPATH,using="//button[@id='c-shellmenu_54']/following-sibling::ul//li")
	private List <WebElement> windows10list;
	
	@FindBy(how=How.ID, using="search")
	private WebElement searchbtn;
	
	@FindBy(how=How.ID, using="cli_shellHeaderSearchInput")
	private WebElement searchfield;
	
	@FindBy(how=How.XPATH,using="//div[contains(@aria-label,'software')]//span[@itemprop='price']")
	private List <WebElement> softwarepriceList;
	

	@FindBy(how=How.XPATH, using="//button[@class='c-glyph glyph-cancel']")
	private WebElement closePopUp;
	
	@FindBy(how=How.XPATH, using="//div[@class='pi-price-text']/span")
	private WebElement detailsPrice;
	
	@FindBy(how=How.XPATH, using="//button[@aria-label='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Total')]//span[@itemprop='price']")
	private WebElement cartPrice;
	
	
	@FindBy(how=How.XPATH, using="//select")
	private WebElement selectQuantity;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	public WebElement GetSoftwarePriceByPosition(int position) {
		List<WebElement> Elements = softwarepriceList;
		return Elements.get(position);
	
	}
	
	public void printSoftwarePrices(int n) {
		for(int i=0; i<n; i++) {
		System.out.println(GetSoftwarePriceByPosition(i).getText());
		}
		
	}
	
	
	public void printwindows10List() {
		List<WebElement> Elements = windows10list;
		for(WebElement element : waitElementsToBePresent(Elements)) {
			System.out.println(element.getText());
		}
	}
	
	public void search(String  query) {
		sendText(searchfield, query);
		sendText(searchfield,Keys.ENTER);
		dismissPopUp();
		
	}
	
	public void dismissPopUp()
	{
		clickElement(closePopUp);
	}
	
	public void clickSearchButton() {
		clickElement(searchbtn);
	}
	
	public void clickMicrosoft365btn() {
		clickElement(microsoft365btn);
	}
	
	public void clickwindows10btn() {
		clickElement(windows10btn);
	}
	
	public void clickWindowsbtn() {
		clickElement(windowsbtn);
	}
	
	
	public void allElementsPresent() {
		waitElementToBePresent(microsoft365btn);
		waitElementToBePresent(Officebtn);
		waitElementToBePresent(windowsbtn);
		waitElementToBePresent(surfacebtn);
		waitElementToBePresent(xboxbtn);
		waitElementToBePresent(dealsbtn);
		waitElementToBePresent(supportbtn);
		
	}


	public void clickSoftware(int i) {
		clickElement(GetSoftwarePriceByPosition(i));
	}
	
	public String getDetailsPrice()
	{
		dismissPopUp();
		return waitElementToBePresent(detailsPrice).getText();
		
	}
	
	public void addSoftwareToCart()
	{
		clickElement(addToCart);
	}
	
	public String getCartPrice()
	{
		return waitElementToBePresent(cartPrice).getText();
	}


	public void selectCopies(int i) {
		
		Select dropdown = new Select(waitElementToBePresent(selectQuantity));
		dropdown.selectByIndex(i-1);
		
	}
	
}