package pageObjects;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePOM extends BasePage {
	JavascriptExecutor js;
	WebDriverWait wait;

	// Constructor
	public TravelInsurancePOM(WebDriver driver) {
		super(driver);
	}

	// WebElements

	@FindBy(id = "input-row")
	WebElement Destination_txt;

	@FindBy(xpath = "//input[@id='country']")
	WebElement destinationCountry_txt;

	@FindBy(xpath = "//*[text()=\"United Kingdom\"]")
	WebElement countryUK_txt;

	@FindBy(xpath = "//div[@id='search-country']/ul/li")
	List<WebElement> countries_drpdown;

	@FindBy(className = "travel_main_cta")
	WebElement next_btn;

	@FindBy(xpath = "(//input[contains(@class,\"MuiInputBase-input\")])[1]")
	WebElement startDate_box;

	@FindBy(xpath = "//*[@class=\"MuiPickersCalendar-weekContainer\"]//*[@class=\"MuiPickersDateRangeDay-root\"]")
	List<WebElement> dates_txt;

	@FindBy(id = "traveller_2")
	WebElement noOfPassengers;

	@FindBy(xpath = "//*[@id='divarrow_undefined'][1]")
	WebElement traveller1_dropdown;

	@FindBy(xpath = "(//*[@id='divarrow_undefined'])[2]")
	WebElement traveller2_dropdown;

	@FindBy(id = "22 years_undefined")
	WebElement age_22;

	@FindBy(id = "21 years_undefined")
	WebElement age_21;

	@FindBy(className = "travel_main_cta")
	WebElement next_Travel_btn;

	@FindBy(id = "ped_no")
	WebElement noRadio_btn;

	@FindBy(id = "mobileNumber")
	WebElement mobileNumber_txt;

	@FindBy(xpath = "//*[text()='View plans']")
	WebElement viewPlans_btn;

	@FindBy(id = "studentTrip")
	WebElement studenttrip;

	@FindBy(xpath = "/html/body/section[1]/div/div[2]/div/div[2]/div/div[1]/div[1]/input")
	WebElement Traveller1_checkbox;

	@FindBy(xpath = "/html/body/section[1]/div/div[2]/div/div[2]/div/div[1]/div[2]/input")
	WebElement Traveller2_checkbox;
	@FindBy(xpath = "//input[@id='Traveller_1']")
	WebElement checkTraveller1;

	@FindBy(xpath = "//input[@id='Traveller_2']")
	WebElement checkTraveller2;
	@FindBy(xpath = "//select[@id='feet']")
	WebElement durationdrp;

	@FindBy(id = "//*[@id=\"feet\"]")
	WebElement dropdown;

	@FindBy(xpath = "//*[@id=\"feet\"]/option[2]")
	WebElement typicaltripDuration;

	@FindBy(xpath = "//button[text()=\"Apply\"]")
	WebElement apply;

	@FindBy(xpath = "//section[@class=\"newFilterSection sort\"]//details//summary")
	WebElement sortBy_drpdown;

	@FindBy(id = "17_sort")
	WebElement LowToHigh_checkbox;

	public @FindBy(className = "quotesCard--insurerName")
	List<WebElement> InsuranceCompanyNames_txt;

	public @FindBy(className = "premiumPlanPrice")
	List<WebElement> InsuranceCompanyPrice_txt;

	@FindBy(xpath = "//*[text()=\"Policybazaar\"]")
	WebElement policyBazzar_logo;

	// Actions

	public void selectDestination(String Country) {
		destinationCountry_txt.click();
		int NoOfCountries = countries_drpdown.size();
		for (int i = 0; i < NoOfCountries; i++) {
			String cntry = countries_drpdown.get(i).getText();
			if (cntry.contains(Country)) {
				countries_drpdown.get(i).click();
				break;
			}
		}
	}

	public void clickOnNextBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(next_btn));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", next_btn);

	}

	public void clickOnStartDate() {
		startDate_box.click();
	}

	public void selectDates() {

		LocalDate localDate = LocalDate.now();// For reference
		LocalDate next = localDate.plusDays(19);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formmatedCurrDate = localDate.format(formatter);
		String formattedNextString = next.format(formatter);
		String chekinDate = formmatedCurrDate.substring(0, 2);
		String endDate = formattedNextString.substring(0, 2);
		System.out.println("Checkout Date" + endDate);
		for (WebElement ele : dates_txt) {
			String val = ele.getText();
			if (val.equalsIgnoreCase(chekinDate)) {
				ele.click();				
			}
			if (val.equalsIgnoreCase(endDate)) {
				ele.click();
				break;
			}

		}
	}

	public void clickNoOfPersons() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", noOfPassengers);
		
	}

	public void selectAgeOfTraveller1() {
		traveller1_dropdown.click();
		js.executeScript("arguments[0].click()", age_22);
		
	}

	public void selectAgeOfTraveller2() {
		traveller2_dropdown.click();
		js.executeScript("arguments[0].click()", age_21);
		
	}

	public void clickNextAfterSelectingAge() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", next_btn);
		

	}

	public void setPreExistingMedicalCondition() {
		noRadio_btn.click();
	}

	public void clickOnNextAfterMedicalondition() {
		next_btn.click();
	}

	public void setMobileNummber(String MobileNumber) {
		mobileNumber_txt.sendKeys(MobileNumber);
		viewPlans_btn.click();
	}

	public void setStudentPlans() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(studenttrip));
		js.executeScript("arguments[0].click();", studenttrip);
		js.executeScript("arguments[0].click();", Traveller1_checkbox);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Traveller2_checkbox);
		Thread.sleep(3000);
		if (!Traveller1_checkbox.isSelected()) {
			Traveller1_checkbox.click();
		}
		if (!Traveller2_checkbox.isSelected()) {
			Traveller2_checkbox.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(durationdrp));
		Select menu = new Select(durationdrp);
		menu.selectByIndex(1);
		Thread.sleep(2000);
		apply.click();

	}

	public void sortByLowtoHigh() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sortBy_drpdown);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(LowToHigh_checkbox));
		js.executeScript("arguments[0].click();", LowToHigh_checkbox);
	}

	public void printFirstThreeCompanyNameAndPrice() throws InterruptedException, FileNotFoundException {

		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			System.out.println(InsuranceCompanyNames_txt.get(i).getText() + " and Price "
					+ InsuranceCompanyPrice_txt.get(i).getText());
		}
		
		
	}

}
