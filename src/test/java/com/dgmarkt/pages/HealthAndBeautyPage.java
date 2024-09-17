package com.dgmarkt.pages;

import com.dgmarkt.utilities.BrowserUtils;
import com.dgmarkt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HealthAndBeautyPage extends BasePage{


    @FindBy(xpath = "//div[@class='alert alert-fix alert-success alert-dismissible']")
    public WebElement alertMessage;

    @FindBy(xpath = "//a[@id='wishlist-total']")
    public WebElement wishListButton;


    public void productAddToWishList(String productName) {
        String product1 = "//a[text()='"+productName+"']/../../../..//button[2]";
        Driver.getDriver().findElement(By.xpath(product1)).click();
    }

    public void verifyAlertMessage(String alertMessage) {
        this.alertMessage.getText().contains(alertMessage);
    }

    @FindBy(css = "[alt='Fitbit Aria Air Smart Bathroom Scale']")
    public WebElement product_FitBit;
    @FindBy(xpath = "//button[@id='button-cart']")
    public WebElement product_AddToCart;



    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
    public WebElement priceSliderHandleHealthAndBeauty;

    @FindBy(xpath = "(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]")
    public WebElement minSliderHandle;

    @FindBy(xpath = "(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]")
    public WebElement maxSliderHandle;

    @FindBy(xpath = "//div[@class='slider-values']//span[1]")
    public WebElement minPriceOfSlider;

    @FindBy(xpath = "//div[@class='slider-values']//span[2]")
    public WebElement maxPriceOfSlider;

    @FindBy(xpath = "//div[@class='product-item']//span[contains(@class,'price')]")
    public List <WebElement> pricesOfProducts;

    @FindBy(xpath = "//div[@class='slider-values']//input[@id='price-to']/@value")
    public WebElement  minPrice;

    @FindBy(xpath = "//div[@class='slider-values']//input[@id='price-to']/@value")
    public WebElement  maxPrice;

    public void resetSliders() {
        minSliderHandle.sendKeys("200");
        maxSliderHandle.sendKeys("300");
    }
    public void getAllProductPrices(int minPrice) {
        for (WebElement productPriceElement : pricesOfProducts) {
            String priceText = productPriceElement.getText().replaceAll("[^0-9]", "");
            int price = Integer.parseInt(priceText);
            Assert.assertTrue("Ürün fiyatı minimum fiyatın altında!", price >= minPrice);
        }
    }

    public int getSliderOffsetForPrice(int price) {
        int sliderRange = 485 - 102;
        int sliderWidth = priceSliderHandleHealthAndBeauty.getSize().getWidth();
        return (int) ((price-102) * 1.0 / sliderRange * sliderWidth);
    }

}
