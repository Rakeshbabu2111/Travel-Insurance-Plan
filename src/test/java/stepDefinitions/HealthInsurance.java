package stepDefinitions;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePOM;
import utilities.ExcelUtility;

public class HealthInsurance {
	HomePagePOM homepage;
	
	@When("the user hover on insurance products")
	public void the_user_hover_on_insurance_products() {
	   homepage=new HomePagePOM(BaseClass.getDriver());
	   homepage.hoverOnInsuranceProducts();
	   System.out.println("The user hovered on the Insurance Products");
	}

	@Then("the user prints health insurance products menu items")
	public void the_user_prints_health_insurance_products_menu_items() throws IOException {
		homepage.printMenuItemsOfHealtInsurance();
		ExcelUtility excel = new ExcelUtility();
		excel.captureHealthInsuranceMenuItems();
		System.out.println("Displayed the Health Insurance Products menu items in console and captured into an Excel");
	}

}
