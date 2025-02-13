package com.dgmarkt.step_definitions;

import com.dgmarkt.pages.MainPage;
import com.dgmarkt.pages.ShoppingCartPage;
import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MainPage_Step_Defs {

    MainPage mainPage = new MainPage();

    @When("user clicks My Account on the main page")
    public void user_clicks_my_account_on_the_main_page() throws InterruptedException {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(mainPage.myAccountButton);
    }

    @When("user clicks My Account from Dropdown menu")
    public void user_clicks_my_account_from_dropdown_menu() {
        mainPage.myAccount2Button.click();
    }

    @When("user clicks Register on My Account")
    public void user_clicks_register_on_my_account() {
        mainPage.accountRegisterButton.click();
    }

    @When("The user clicks {string} header")
    public void the_user_clicks_header(String headerText) {
        mainPage.getHeader(headerText).click();
    }

    @Then("The user should be able to see the {string} page")
    public void the_user_should_be_able_to_see_the_page(String expectedPage) {
        String actualPage = mainPage.getPage().getText();
        BrowserUtils.waitForVisibility(mainPage.getPage(), 2);
        Assert.assertEquals(expectedPage,actualPage);
    }

    @When("The user hover over the Category header on the main page")
    public void the_user_hover_over_the_category_header_on_the_main_page() {
        BrowserUtils.waitFor(1);
        BrowserUtils.hover(mainPage.getHeader("Category"));
    }

    @Then("The user should be able to see on the submenu-header submenus")
    public void the_user_should_be_able_to_see_on_the_submenu_header_submenus() {
        Assert.assertTrue(mainPage.healthAndBeauty.isDisplayed());
    }

    @When("The user clicks Health & Beauty submenu")
    public void the_user_clicks_health_beauty_submenu() {
        BrowserUtils.clickWithJS(mainPage.healthAndBeauty);
    }

    @When("The user clicks Category module on main page")
    public void the_user_clicks_category_module_on_main_page() {
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(mainPage.categoryButtonOnMainPage);
    }

    @When("The user clicks on a subcategory {string}")
    public void the_user_clicks_on_a_subcategory(String subCategoryMenu) {
        mainPage.getSubCategoryMenu(subCategoryMenu);
    }

    @When("The user clicks on a Tv Accessories")
    public void the_user_clicks_on_a_tv_accessories() {
       mainPage.getSubCategoryMenu("TV Accessories");
    }

    @And("The user clicks on Order History button")
    public void the_user_clicks_on_order_history_button() {
        mainPage.orderHistoryButton.click();
    }

    @Then("The user should be able to see the {string} of My Account")
    public void the_user_should_be_able_to_see_the_of_my_account(String submenuList) {
       String menuList = Driver.getDriver().findElement(By.xpath("(//li[.='"+submenuList+"'])[1]")).getText();
       Assert.assertEquals(submenuList,menuList);
    }
    @Then("The user should be in {string} page")
    public void the_user_should_be_in_page(String subCategoryName) {
        String expectedSubcategory = subCategoryName;
        String actualSubCategory = mainPage.subcategoryHeader.getText();
        Assert.assertEquals(expectedSubcategory, actualSubCategory);
    }

}

