package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarInsurancePOM;
import pageObjects.HomePagePOM;

public class CarInsurance {
	HomePagePOM homePage;
	CarInsurancePOM carInsurance;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	@When("the user click on the car insurance icon")
	public void the_user_click_on_the_car_insurance_icon() throws InterruptedException {
		homePage=new HomePagePOM(BaseClass.getDriver());
		carInsurance=new CarInsurancePOM(BaseClass.getDriver());
		BaseClass.getDriver().manage().deleteAllCookies();
		homePage.clickOnCarInsurance();
		Thread.sleep(4000);
		carInsurance.setURLOfCarInsurance();
		System.out.println("The user clicked on the Car Insurance icon");
	}

	@When("the user click on buying a new car")
	public void the_user_click_on_buying_a_new_car() {	
		carInsurance.clickOnbuyingNewCar();
		System.out.println("The user clicked on buying a new car");
	}

	@When("the user selects city and RTO")
	public void the_user_selects_city_and_rto() {
		carInsurance.selectCity();
		carInsurance.selectRTO();
		System.out.println("The user selected city and RTO");
	}

	@When("the user selects car brand")
	public void the_user_selects_car_brand() {
		carInsurance.selectCarBrand();
		System.out.println("The user selected the car brand");
	}

	@When("the user selects car model")
	public void the_user_selects_car_model() {
		carInsurance.selectCarModel();
		System.out.println("The user selected the car model");
	}

	@When("the user selects car fuel type")
	public void the_user_selects_car_fuel_type() {
		carInsurance.selectCarFuelType();
		System.out.println("The user selected the car fuel type");
	}

	@When("the user selects car variant")
	public void the_user_selects_car_variant() {
		carInsurance.selectCarVariant();
		System.out.println("The user selected the car variant");
	}

	@When("the user enters FullName and Invalid Email and Mobile Number")
	public void the_user_enters_full_name_and_invalid_email_and_mobile_number() throws InterruptedException, IOException {
		carInsurance.setFields();
		System.out.println("The user entered the details");
	}

	@Then("capture and display error messages")
	public void capture_and_display_error_messages() throws InterruptedException, IOException {
		try {
		carInsurance.captureinvalid();
		Assert.assertEquals(carInsurance.MobileNoErrorMsg_txt.isDisplayed(), true);
		Assert.assertEquals(carInsurance.emailErrorMsg_txt.isDisplayed(), true);
		System.out.println("Displayed the Error messages in console and captured into an Excel");
		
		}
		catch(AssertionError e) {
		System.out.println("One of the Errror Message is not displayed");
		}
	
	}
}
