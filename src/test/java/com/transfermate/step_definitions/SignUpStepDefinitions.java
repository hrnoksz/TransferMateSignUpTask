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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpStepDefinitions {

    BasePage page = new BasePage();
    Faker faker = new Faker();
    String emailAddress;


    @Given("user is on signup page")
    public void user_is_on_signup_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("signup_url"));
    }
    @When("user clicks on the Corporate radio button")
    public void user_clicks_on_the_corporate_radio_button() {
        page.corporateRadioBtn.click();
    }
    @When("user selects a country from country dropdown")
    public void user_selects_a_country_from_country_dropdown() {
        Select country = new Select(page.countryDropdown);
        country.selectByVisibleText("Australia");
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

    @When("user enters invalid {string} to email address field")
    public void user_enters_invalid_to_email_address_field(String string) {
        page.email.sendKeys(string);
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

    @Then("verify that user see proper warning message")
    public void verify_that_user_see_proper_warning_message() {
        assertTrue(page.registerEmailErrorMessage.isDisplayed());
    }

    @When("user enters valid email address into email address placeholder")
    public void user_enters_valid_into_email_address_placeholder() {
        emailAddress = faker.internet().emailAddress();
        page.email.sendKeys(emailAddress);
    }

    @Then("verify that user can register as a Corporate successfully")
    public void verify_that_user_can_register_as_a_corporate_successfully() {
        assertTrue(page.checkMessage.isDisplayed());
    }

    @When("user enters already registered email address into email address placeholder")
    public void user_enters_already_registered_email_address_into_email_address_placeholder() {
        page.email.sendKeys("harun.oksuz@yahoo.com");
    }























}
