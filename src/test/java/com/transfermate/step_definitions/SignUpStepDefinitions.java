package com.transfermate.step_definitions;

import com.github.javafaker.Faker;
import com.transfermate.pages.BasePage;
import com.transfermate.utilities.BrowserUtils;
import com.transfermate.utilities.ConfigurationReader;
import com.transfermate.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpStepDefinitions {

    BasePage page = new BasePage();
    Faker faker = new Faker();

    String emailAddress = faker.internet().emailAddress();


    @Given("user is on signup page")
    public void user_is_on_signup_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("signup_url"));
    }

    @When("user clicks Corporate, selects country, enters valid first and last name")
    public void user_clicks_corporate_selects_country_enters_valid_first_and_last_name() {
        page.corporateRadioBtn.click();
        Select countryOne = new Select(page.countryDropdown);
        countryOne.selectByVisibleText("Australia");
        page.firstName.sendKeys(faker.name().firstName());
        page.lastName.sendKeys(faker.name().lastName());
    }

    @When("user enters invalid {string} to email address field")
    public void user_enters_invalid_to_email_address_field(String string) {
        page.email.sendKeys(string);
    }

    @When("user selects country code and enters phone number, clicks on terms of Use check box, enters captcha, and click my free account button")
    public void user_selects_country_code_and_enters_phone_number_clicks_on_terms_of_use_check_box_enters_captcha_and_click_my_free_account_button() {
        Select countryCode = new Select(page.countryCodeDropdown);
        countryCode.selectByVisibleText("Australia +61");
        page.mobilePhone.sendKeys(faker.numerify("#######"));
        page.termsOfUseCheckBox.click();
        BrowserUtils.captchaVerification(page.mathQuestionValue);
        BrowserUtils.clickWithJS(page.subscribeBtn);
    }

    @Then("verify that user see proper warning message")
    public void verify_that_user_see_proper_warning_message() {
        assertTrue(page.registerEmailErrorMessage.isDisplayed());
    }

    @When("user clicks on the Corporate radio button")
    public void user_clicks_on_the_corporate_radio_button() {
        page.corporateRadioBtn.click();
    }

    @When("user selects a {string} from country dropdown")
    public void user_selects_a_from_country_dropdown(String country) {
        Select countryOne = new Select(page.countryDropdown);
        countryOne.selectByVisibleText("Australia");
    }

    @When("user enters valid first name into first name placeholder")
    public void user_enters_valid_first_name_into_first_name_placeholder() {
        page.firstName.clear();
        page.firstName.sendKeys(faker.name().firstName());
    }

    @When("user enters valid last name into last name placeholder")
    public void user_enters_valid_last_name_into_last_name_placeholder() {
        page.lastName.clear();
        page.lastName.sendKeys(faker.name().lastName());
    }

    @When("user enters valid email address into email address placeholder")
    public void user_enters_valid_into_email_address_placeholder() {
        page.email.sendKeys(emailAddress);
        System.out.println("emailAddress = " + emailAddress);
    }

    @When("user selects a country code from country code dropdown")
    public void user_selects_a_country_code_from_country_code_dropdown() {
        Select countryCode = new Select(page.countryCodeDropdown);
        countryCode.selectByVisibleText("Australia +61");
    }

    @When("user enters valid mobile phone number into mobile phone place holder")
    public void user_enters_valid_mobile_phone_number_into_mobile_phone_place_holder() {
        page.mobilePhone.clear();
        page.mobilePhone.sendKeys(faker.numerify("#######"));
    }

    @When("user clicks on Terms of Use and Privacy Policy check box")
    public void user_clicks_on_terms_of_use_and_privacy_policy_check_box() {
        page.termsOfUseCheckBox.click();
    }

    @When("user enters the result inside captcha")
    public void user_enters_the_result_inside_captcha() {
        BrowserUtils.captchaVerification(page.mathQuestionValue);
    }

    @When("user clicks on open my free account button")
    public void user_clicks_on_open_my_free_account_button() {
        BrowserUtils.clickWithJS(page.subscribeBtn);
    }

    @Then("verify that user can register as a Corporate successfully")
    public void verify_that_user_can_register_as_a_corporate_successfully() {
        Driver.getDriver().navigate().forward();
        assertTrue(page.checkMessage.isDisplayed());
    }

    @When("user enters the registered email into email address field")
    public void user_enters_the_registered_email_into_email_address_field() {

        page.email.sendKeys(emailAddress);
        System.out.println("emailAddress1 = " + emailAddress);
    }


}
