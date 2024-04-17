package stepDefinitions;




import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePagePOM;
import pageObjects.TravelInsurancePOM;

public class SmokeTesting {
	TravelInsurancePOM travelInsurance;
	HomePagePOM homePage;
	@When("the user click on the Term life insurance icon")
	public void the_user_click_on_the_term_life_insurance_icon() throws InterruptedException {
		homePage=new HomePagePOM(BaseClass.getDriver());
		homePage.clickOnTermLifeInsurance();	
	}

	@Then("the user navigates to Term Life Insurance Page and validate the title of the page")
	public void the_user_navigates_to_term_life_insurance_page_and_validate_the_title_of_the_page() throws IOException {
		
		Assert.assertEquals(homePage.titleOfPage(), BaseClass.getProperties().getProperty("termLifeInsurance_title"));
	}

	@When("the user click on the Health Insurance icon")
	public void the_user_click_on_the_health_insurance_icon() throws InterruptedException {
		homePage=new HomePagePOM(BaseClass.getDriver());
	    homePage.clickOnHealthInsurance();
	}

	@Then("the user navigates to Health Insurance Page and validate the title of the page")
	public void the_user_navigates_to_health_insurance_page_and_validate_the_title_of_the_page() {
		homePage.titleOfPage();
	}
	
	@When("the user click on the Investment Plans icon")
	public void the_user_click_on_the_investment_plans_icon() throws InterruptedException {
		homePage=new HomePagePOM(BaseClass.getDriver());
		homePage.clickOnInvestmentPlans();
	}

	@When("the user click on the policy bazaar icon and navigates back to HomePage")
	public void the_user_click_on_the_policy_bazaar_icon_and_navigates_back_to_home_page() {
		homePage.clickOnPolicyBazaarLogo();
	}

	@Then("validate the title of the Page")
	public void validate_the_title_of_the_page() throws InterruptedException, IOException {
	   Assert.assertEquals(homePage.validateTitleOfPage(), BaseClass.getProperties().getProperty("URL"));;
	}
	
	@When("the user click on the view all products")
	public void the_user_click_on_the_view_all_products() throws InterruptedException {
		homePage=new HomePagePOM(BaseClass.getDriver());
		homePage.clickOnViewAllProducts();

	}

	@Then("validate the displaying of Personal Insurance Tab and Business Insurance Tab")
	public void validate_the_displaying_of_personal_insurance_tab_and_business_insurance_tab() {
		Assert.assertEquals(homePage.validateViewAllProductsPopup(), true);
	}


}
