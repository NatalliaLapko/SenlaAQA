package com.JUnitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Locators {


public static final By LOGIN_EMAIL = By.id("session_email");
public static final By LOGIN_PASSWORD = By.id("session_password");
public static final By LOGIN_BUTTON = By.name("commit");
//new address form
 public static final By LINK_ADDRESS = By.linkText("Addresses");
 public static final By LINK_NEW_ADDRESS =By.xpath("//a[@href = '/addresses/new']");
 public static final By FIRST_NAME = By.id("address_first_name");
    public static final By LAST_NAME = By.id("address_last_name");
    public static final By ADDRESS_1 = By.id("address_street_address");
    public static final By ADDRESS_2 = By.id("address_secondary_address");
    public static final By CITY = By.id("address_city");
    public static final By STATE = By.id("address_state");
    public static final By ZIP_CODE = By.id("address_zip_code");
    public static final By RADIO_USA = By.id("address_country_us");
    public static final By RADIO_CANADA = By.id("address_country_canada");
    public static final By BIRTHDAY = By.id("address_birthday");
    public static final By AGE = By.id("address_age");
    public static final By WEBSITE = By.id("address_website");
    public static final By PHONE = By.id("address_phone");
    public static final By NOTE = By.id("address_note");
   public static final By CREATE_ADDRESS_BUTTON = By.xpath("//input [@value ='Create Address']");


   //address editing form

    public static final By EDIT_BUTTON = By.cssSelector("a[href$='edit']");
    public static final By EDIT_ADDRESS_BUTTON = By.xpath("//input[@name = 'commit']");
    public static final By DESTROY = By.linkText("Destroy");

public static final By ACCOUNT_NAME = By.xpath("//span[@class = 'navbar-text']");
public static final By SHOW_LINK = By.xpath("//a[contains(text(),'Show')]");
public static final By FIRST_NAME_TEXT = By.xpath("//span[@data-test = 'first_name' ]");
public static final By LAST_NAME_TEXT = By.xpath("//span[@data-test = 'last_name' ]");

}
