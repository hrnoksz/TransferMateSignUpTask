package com.transfermate.pages;

import com.transfermate.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "(//label[@class='check-radio-label'])[3]")
    public WebElement corporateRadioBtn;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//select[@id='__pin_mobile_number_international_dialing_code']")
    public WebElement countryCodeDropdown;

    @FindBy(xpath = "//input[@id='__pin_mobile_number_mobile_phone']")
    public WebElement mobilePhone;

    @FindBy(xpath = "//div[@id='register_terms_of_use_agree_form_input']")
    public WebElement termsOfUseCheckBox;


    @FindBy(xpath = "//div[@id='cal_captcha_f10_question']")
    public WebElement mathQuestionValue;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement subscribeBtn;

    @FindBy(xpath = "//h2[@class='font-weight-normal mb-3']")
    public WebElement checkMessage;

    @FindBy(xpath = "//div[@id='register_email_error']")
    public WebElement registerEmailErrorMessage;
/*
    @FindBy(xpath = "//div[contains(@id,'error')][@class='err'][contains(.,'Already exists!')]")
    public WebElement alreadyExistMessage;

 */

}
