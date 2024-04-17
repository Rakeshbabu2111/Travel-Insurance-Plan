package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePOM;
import pageObjects.TravelInsurancePOM;
import utilities.ExcelUtility;

public class TravelInsurance {

	TravelInsurancePOM travelInsurance;
	HomePagePOM homePage;

	@Given("the user navigate to policy bazaar website")
	public void the_user_navigate_to_policy_bazzar_website() throws IOException {
		travelInsurance = new TravelInsurancePOM(BaseClass.getDriver());
		System.out.println("The user navigated to Policy Bazaar HomePage");
	}

	@When("the user click on the travel insurance icon")
	public void the_user_click_on_the_travel_insurance_icon() {
		homePage = new HomePagePOM(BaseClass.getDriver());
		homePage.clickOnTravelInsurance();
		System.out.println("The user clicked on the Travel Insurance Icon");
	}

	@When("the user selects the destination {string}")
	public void the_user_selects_the_destination(String Destination) {
		travelInsurance.selectDestination(Destination);
		travelInsurance.clickOnNextBtn();
		System.out.println("The user selected the destination as " + Destination + " and clicked on the next button");

	}

	@When("the user selects the trip duration")
	public void the_user_selects_the_trip_duration() throws InterruptedException {
		travelInsurance.clickOnStartDate();
		travelInsurance.selectDates();
		Thread.sleep(5000);
		travelInsurance.clickOnNextBtn();
		System.out.println("The user selected the start and end dates, and clicked on the next button ");
	}

	@When("the user selects the no of travellers and age of travellers")
	public void the_user_selects_the_no_of_travellers_and_age_of_travellers() {
		travelInsurance.clickNoOfPersons();
		travelInsurance.selectAgeOfTraveller1();
		travelInsurance.selectAgeOfTraveller2();
		travelInsurance.clickNextAfterSelectingAge();
		System.out.println("The user selected the No of passengers and age of passengers");

	}

	@When("the user selects pre-existing medical condition")
	public void the_user_selects_pre_existing_medical_condition() {
		travelInsurance.setPreExistingMedicalCondition();
		travelInsurance.clickNextAfterSelectingAge();
		System.out.println("The user selected pre-medical condition as No");

	}

	@When("the user enter the mobile number {string}")
	public void the_user_enter_the_mobile_number(String MobileNumber) {
		travelInsurance.setMobileNummber(MobileNumber);
		System.out.println("The user entered the mobile number and clicked on next button");

	}

	@When("the user selects the student plans and enters the student travel information")
	public void the_user_selects_the_student_plans_and_enters_the_student_travel_information()
			throws InterruptedException {
		travelInsurance.setStudentPlans();
		System.out.println("The user selected the student plans and entered the student travel information");
	}

	@When("the user sort the plans from low to high")
	public void the_user_sort_the_plans_from_low_to_high() throws InterruptedException {
		Thread.sleep(3000);
		travelInsurance.sortByLowtoHigh();
		System.out.println("The user clicked on the sort by low to high");
	}

	@Then("display three lowest international travel insurance plan with amount and insurance provider company")
	public void display_three_lowest_international_travel_insurance_plan_with_amount_and_insurance_provider_company()
			throws InterruptedException, IOException {
		travelInsurance.printFirstThreeCompanyNameAndPrice();
		Thread.sleep(5000);
		ExcelUtility excel = new ExcelUtility();
		excel.captureInsuranceDetails();
		System.out.println(
				"First three Company Names and total premium amount is displayed in console and captured into Excel");
	}

}
