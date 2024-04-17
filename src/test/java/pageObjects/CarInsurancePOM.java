package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import utilities.ExcelUtility;

public class CarInsurancePOM extends BasePage{
	JavascriptExecutor js;
	
//	Constructor
	public CarInsurancePOM(WebDriver driver) {
		super(driver);
		
	}
	
//	WebElements
	@FindBy(xpath="//a[@class='btn-proceed']")
	WebElement clickHere_link;

	@FindBy (xpath="//span[@id='spn1']")
	WebElement city_txt;

	@FindBy (xpath="//span[contains(text(),'KA01')]")
	WebElement RTO_txt;
		
	@FindBy (xpath="//span[contains(@class,'tata')]")
	WebElement carBrand_txt;
		
	@FindBy (xpath="//b[contains(text(),'ALTROZ')]")
	WebElement carModel_txt;
	
	
	@FindBy (xpath="//b[contains(text(),'CNG')]")
	WebElement carFuelType_txt;

	@FindBy (xpath="//b[contains(text(),'XE CNG (1199 cc)')]")
	WebElement carVariant_txt;
			
	@FindBy (xpath="//label[contains(text(),'Full Name')]")
	WebElement fullName_txt;
		
	@FindBy (xpath="//input[@id='name']")
	WebElement fullName_input;
	
	@FindBy (xpath="//label[contains(text(),'Email')]")
	WebElement email_txt;
	
	@FindBy (xpath="//input[@id='email']")
	WebElement email_input;
	
	@FindBy (xpath="//label[contains(text(),'Mobile No.')]")
	WebElement mobilenumber_txt;
	
	@FindBy (xpath="//input[@id='mobileNo']")
	WebElement mobilenumber_input;
	
	public @FindBy(xpath="//div[@class='msg-error show']|div[text()='Please enter a valid e-mail ID.']")
	WebElement emailErrorMsg_txt;
	
	public @FindBy(xpath="//div[@class='msg-error show' and text()='Please enter a valid 10-digit mobile number.']")
	WebElement MobileNoErrorMsg_txt;
	
	@FindBy(id="btnLeadDetails")
	WebElement viewPrices_btn;
	
	@FindBy (xpath="//a[@class='pb-logo']")
	WebElement policyBazzar_logo;
	
	@FindBy (xpath="(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")
	WebElement carinss;
	
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg car-insurance'])[2]")
	WebElement carins;

	
	@FindBy (xpath="//h3/span[2]")
	WebElement cartitles;
	
	
	//Actions 
	public String titlevalidations1() {
		String textt=cartitles.getText();
		return textt;
	}
	
	public String titlechecks() {
		String text = driver.getTitle();
		return text;
	}
	
	public void choosecarinsurance() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",carins);
		carins.click();
	}
	
	public void clickOnbuyingNewCar() {
		clickHere_link.click();
	}
	
	public void selectCity() {
		city_txt.click();
	}
	
	public void selectRTO() {
		RTO_txt.click();
	}
	
	public void selectCarBrand() {
		carBrand_txt.click();
	}
	
	public void selectCarModel() {
		carModel_txt.click();
	}
	
	public void selectCarFuelType() {
		carFuelType_txt.click();
	}
	
	public void selectCarVariant() {
		carVariant_txt.click();
	}
	
	public void carbuttoncheck() {
		WebElement button3 = carinss;
        boolean valuees = button3.isEnabled();
        System.out.println("is the Car Insurance button Enabled ? " +valuees); 
	}
	
	public void setFields() throws InterruptedException, IOException {
		js= (JavascriptExecutor)BaseClass.getDriver();
		fullName_txt.click();
		ExcelUtility excel=new ExcelUtility();
		String filepath=".\\ExcelData\\ContactDetail_CI.xlsx";
		String Name=excel.getCellDataContactDetails(filepath, "Sheet1", 1, 0);
		String Email=excel.getCellDataContactDetails(filepath, "Sheet1", 2, 0);
		String PhoneNumber=excel.getCellDataContactDetails(filepath, "Sheet1", 3, 0);
		Thread.sleep(3000);
		fullName_input.sendKeys(Name);
		email_txt.click();
		email_input.sendKeys(Email);
		mobilenumber_txt.click();
		mobilenumber_input.sendKeys(PhoneNumber);
		js.executeScript("arguments[0].click();", viewPrices_btn);
		Thread.sleep(4000);
	}
	
	public void captureinvalid() throws IOException {
		
		try {
			System.out.println(emailErrorMsg_txt.getText());
			System.out.println(MobileNoErrorMsg_txt.getText());
			ExcelUtility.setCellData();
			
		}catch(NoSuchElementException e) {
			System.out.println("No such element Exception-Email/MobileNumber Error Message");
		}
	
	}
	public void car_homepage() {
		policyBazzar_logo.click();
	}
	
	public void setURLOfCarInsurance() {
		if(driver.getCurrentUrl().equalsIgnoreCase("https://ci.policybazaar.com/v1?utm_content=home_v11")) {
			driver.get("https://ci.policybazaar.com/?utm_content=home_v11");
		}
	}
	

}
