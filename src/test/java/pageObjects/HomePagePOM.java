package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

public class HomePagePOM extends BasePage{
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	//Constructor
	public HomePagePOM(WebDriver driver) {
		super(driver);
	}
	
	//WebElements
	
	@FindBy(xpath="//div[7]//a[1]//div[1]//div[1]")
	WebElement travelInsurance_logo;
	
	@FindBy(xpath="/html/body/main/div[2]/section/div[4]/a/div[1]/div/i")
	WebElement CarInsurance_logo;
	
	@FindBy(xpath="//*[text()='Insurance Products ']")
	WebElement insuranceProducts_txt;
	
	public @FindBy(xpath="(//div[@class=\"ruby-grid ruby-grid-lined\"]/div[@class=\"ruby-row\"])/div[3]//li")
	List<WebElement>listOfMenuItems_txt;
	
	@FindBy(className="shadowHandlerBox")
	List<WebElement>Insurance_icons;
	
	@FindBy(xpath="//section/div[1]/a/div[1]/p")
	WebElement termLifeInsurance_icon;
	
	@FindBy(xpath="//section/div[2]/a/div[1]/p")
	WebElement healthInsurance_icon;
	
	@FindBy(xpath="//section/div[3]/a/div[1]/p[1]")
	WebElement investmentPlans_icon;
	
	@FindBy(xpath="//div[@class='view-all-products ']//a")
	WebElement viewAllProducts_txt;
	
	@FindBy(xpath="//*[contains(text(),'Personal Insurance')]")
	WebElement personalInsurance_txt;
	
	@FindBy(xpath="//label[contains(text(),'Business Insurance')]")
	WebElement businessInsurance_txt;
	
	@FindBy(id="homeIcons")
	WebElement viewAllProducts_popup;
	
	@FindBy(xpath="//a[@class='desktopview']//img[@alt='policybazaar']")
	WebElement policyBazaar_logo;
	
	//Actions
	//Click on the Travel Insurance
	public void clickOnTravelInsurance() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(travelInsurance_logo));
		travelInsurance_logo.click();
	}
	
	//Click on the Car Insurance
	public void clickOnCarInsurance() {
		CarInsurance_logo.click();
		System.out.println("Clicked on the Car Insurance Icon");
	}
	
	
	//Hover on Insurance Products
	public void hoverOnInsuranceProducts() {
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(insuranceProducts_txt));
		Actions action=new Actions(BaseClass.getDriver());
		action.moveToElement(insuranceProducts_txt);
		insuranceProducts_txt.click();
		
	}
	
	//Print the Menu Items 
	public void printMenuItemsOfHealtInsurance() {
		for(WebElement listItems:listOfMenuItems_txt) {
			System.out.println(listItems.getText());
		}
	}
	
	//Click on the Term Life Insurance
	public void clickOnTermLifeInsurance() throws InterruptedException {
		js=(JavascriptExecutor)BaseClass.getDriver();
		js.executeScript("arguments[0].click();", termLifeInsurance_icon);
		//termLifeInsurance_icon.click();
		Thread.sleep(5000);
	}
	public String titleOfPage() {
		String act_title;
		act_title=BaseClass.getDriver().getTitle();
		return act_title;
	}
	
	public void clickOnHealthInsurance() throws InterruptedException {
		js=(JavascriptExecutor)BaseClass.getDriver();
		js.executeScript("arguments[0].click();", healthInsurance_icon);
	
	}
	
	public void clickOnInvestmentPlans() throws InterruptedException {
		js=(JavascriptExecutor)BaseClass.getDriver();
		js.executeScript("arguments[0].click();", investmentPlans_icon);
		
	
	}
	public void clickOnPolicyBazaarLogo() {
		policyBazaar_logo.click();
	}
	
	public String validateTitleOfPage() throws InterruptedException {	
		String URL_afterNavigatingBack=BaseClass.getDriver().getCurrentUrl();
		return URL_afterNavigatingBack;

	}
	
	public void clickOnViewAllProducts() throws InterruptedException {
		js=(JavascriptExecutor)BaseClass.getDriver();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", viewAllProducts_txt);
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(3000);
	}
	
	public boolean validatePersonalTab() {
		boolean check=personalInsurance_txt.isDisplayed();
		System.out.println(check);
		return check;
	}
	public boolean validateBusinessTab() {
		boolean check=businessInsurance_txt.isDisplayed();
		System.out.println(check);
		return check;
	}
	public boolean validateViewAllProductsPopup() {
		boolean check=viewAllProducts_popup.isDisplayed();
		return check;
	}

}
