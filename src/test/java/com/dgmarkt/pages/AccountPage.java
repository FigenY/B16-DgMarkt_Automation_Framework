package com.dgmarkt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//*[text()='Edit Account']")
    public WebElement editAccount;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement messageForEdit;

    @FindBy(xpath = "//a[text()='Address Book']")
    public WebElement addressBook;

    @FindBy(xpath = "/*[text()='Password']")
    public WebElement passwordBtnMyAccount;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id='input-confirm']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessagePaswordChange;

    @FindBy(xpath = "//div[@class='text-danger']")
    public WebElement warningMessagePaswordNotChange;



}
