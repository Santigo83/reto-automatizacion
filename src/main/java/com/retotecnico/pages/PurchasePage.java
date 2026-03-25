package com.retotecnico.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends BasePage {

    private static final By COMPUTERS_CATEGORY_LINK = By.xpath("//div[contains(@class,'block-category-navigation')]//a[@href='/computers']");
    private static final By NOTEBOOKS_SUBCATEGORY_LINK = By.xpath("//div[contains(@class,'sub-category-grid')]//a[@href='/notebooks']");
    private static final By NOTEBOOK_PRODUCT_LINK = By.xpath("//div[@data-productid='31']//a[@href='/141-inch-laptop']");
    private static final By NOTEBOOK_ADD_TO_CART_BUTTON = By.id("add-to-cart-button-31");
    private static final By CART_LINK = By.className("ico-cart");
    private static final By CART_QUANTITY = By.className("cart-qty");
    private static final By TERMS_OF_SERVICE_CHECKBOX = By.id("termsofservice");
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    private static final By COUNTRY_DROPDOWN = By.id("BillingNewAddress_CountryId");
    private static final By CITY_INPUT = By.id("BillingNewAddress_City");
    private static final By ADDRESS_INPUT = By.id("BillingNewAddress_Address1");
    private static final By ZIP_CODE_INPUT = By.id("BillingNewAddress_ZipPostalCode");
    private static final By PHONE_INPUT = By.id("BillingNewAddress_PhoneNumber");
    private static final By BILLING_CONTINUE_BUTTON = By.xpath("//div[@id='billing-buttons-container']//input[@type='button']");
    private static final By SHIPPING_ADDRESS_CONTINUE_BUTTON = By.xpath("//div[@id='shipping-buttons-container']//input[@type='button']");
    private static final By SHIPPING_METHOD_CONTINUE_BUTTON = By.xpath("//div[@id='shipping-method-buttons-container']//input[@type='button']");
    private static final By CREDIT_CARD_PAYMENT_METHOD = By.xpath("//label[contains(normalize-space(),'Credit Card')]/preceding-sibling::input[@type='radio']");
    private static final By PAYMENT_METHOD_CONTINUE_BUTTON = By.xpath("//div[@id='payment-method-buttons-container']//input[@type='button']");
    private static final By CREDIT_CARD_TYPE_DROPDOWN = By.id("CreditCardType");
    private static final By CARDHOLDER_NAME_INPUT = By.id("CardholderName");
    private static final By CARD_NUMBER_INPUT = By.id("CardNumber");
    private static final By EXPIRE_MONTH_DROPDOWN = By.id("ExpireMonth");
    private static final By EXPIRE_YEAR_DROPDOWN = By.id("ExpireYear");
    private static final By CARD_CODE_INPUT = By.id("CardCode");
    private static final By PAYMENT_INFO_CONTINUE_BUTTON = By.xpath("//div[@id='payment-info-buttons-container']//input[@type='button']");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//div[@id='confirm-order-buttons-container']//input[@type='button']");
    private static final By ORDER_SUCCESS_MESSAGE = By.xpath("//div[contains(@class,'order-completed')]//strong");

    public PurchasePage() {
    }

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToProduct() {
        click(COMPUTERS_CATEGORY_LINK);
        click(NOTEBOOKS_SUBCATEGORY_LINK);
        click(NOTEBOOK_PRODUCT_LINK);
    }

    public void addProductToCart() {
        click(NOTEBOOK_ADD_TO_CART_BUTTON);
        waitForCartToContainProducts();
    }

    public void openCart() {
        click(CART_LINK);
    }

    public void proceedToCheckout() {
        click(TERMS_OF_SERVICE_CHECKBOX);
        click(CHECKOUT_BUTTON);
    }

    public void completeBillingAddress(String country, String city, String address, String zipCode, String phone) {
        if (isVisible(COUNTRY_DROPDOWN)) {
            selectByVisibleText(COUNTRY_DROPDOWN, country);
            type(CITY_INPUT, city);
            type(ADDRESS_INPUT, address);
            type(ZIP_CODE_INPUT, zipCode);
            type(PHONE_INPUT, phone);
        }
        click(BILLING_CONTINUE_BUTTON);
    }

    public void continueShippingAddressIfRequired() {
        clickIfVisible(SHIPPING_ADDRESS_CONTINUE_BUTTON);
    }

    public void continueShippingMethod() {
        click(SHIPPING_METHOD_CONTINUE_BUTTON);
    }

    public void selectCreditCardPaymentMethod() {
        click(CREDIT_CARD_PAYMENT_METHOD);
        click(PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    public void completePaymentInformation() {
        selectByVisibleText(CREDIT_CARD_TYPE_DROPDOWN, "Visa");
        type(CARDHOLDER_NAME_INPUT, "Barbara Gordon");
        type(CARD_NUMBER_INPUT, "4485564059489345");
        selectByVisibleText(EXPIRE_MONTH_DROPDOWN, "04");
        selectByVisibleText(EXPIRE_YEAR_DROPDOWN, "2039");
        type(CARD_CODE_INPUT, "123");
        click(PAYMENT_INFO_CONTINUE_BUTTON);
    }

    public void confirmOrder() {
        click(CONFIRM_ORDER_BUTTON);
    }

    public String getOrderSuccessMessage() {
        return readText(ORDER_SUCCESS_MESSAGE);
    }

    private void waitForCartToContainProducts() {
        findVisibleElement(CART_QUANTITY);
        waitForCondition().until(webDriver -> !readText(CART_QUANTITY).contains("(0)"));
    }
}
