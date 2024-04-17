Feature: Smoke Testing on Policy Bazaar website

  @smoke
  Scenario: Validation of user navigate to Term Life Insurance page on clicking Term Life Iinsurance icon in Homepage of Policy Bazzar website
    Given the user navigate to policy bazaar website
    When the user click on the Term life insurance icon
    Then the user navigates to Term Life Insurance Page and validate the title of the page

  @smoke
  Scenario: Validation of user navigate to Health Insurance page on clicking Health Insurance icon in Homepage of Policy Bazzar website
    Given the user navigate to policy bazaar website
    When the user click on the Health Insurance icon
    Then the user navigates to Health Insurance Page and validate the title of the page

  @smoke
  Scenario: Validation of user navigate to Investment Plans and navigate back to HomePage on clicking policy bazaar logo
    Given the user navigate to policy bazaar website
    When the user click on the Investment Plans icon
    When the user click on the policy bazaar icon and navigates back to HomePage
    Then validate the title of the Page

  @smoke
  Scenario: Validation of displaying the Personal Insurance and Business Insurance tabs on clicking view all products
    Given the user navigate to policy bazaar website
    When the user click on the view all products
    Then validate the displaying of Personal Insurance Tab and Business Insurance Tab
