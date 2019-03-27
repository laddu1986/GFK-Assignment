package com.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains locators for UI tests
 *
 * @author laddu shashavali
 *
 */
public class AutomationPracticePageModel {

    /**
     * Locator for link: "Sign in"
     */
    @FindBy(xpath = "//*[@class='login']")//".login")
    private static WebElement linkSignin;

    /**
     * Locator for textbox: "Create An Account"
     */
    @FindBy(css = "#email_create")
    private static WebElement txtBoxCreateAcc;

    /**
     * Locator for button: "Create an account"
     */
    @FindBy(css = "#SubmitCreate")
    private static WebElement btnCreateAnAcc;

    /**
     * Locator for Radio button: "Mr."
     */
    @FindBy(css = "#id_gender1")
    private static WebElement rdBtnMr;

    /**
     * Locator for Radio button: "Mrs."
     */
    @FindBy(css = "#id_gender2")
    private static WebElement rdBtnMrs;

    /**
     * Locator for Text box: "First Name"
     */
    @FindBy(css = "#customer_firstname")
    private static WebElement txtBoxFirstName;

    /**
     * Locator for Text box: "Last Name"
     */
    @FindBy(css = "#customer_lastname")
    private static WebElement txtBoxLastName;

    /**
     * Locator for Text box: "Password"
     */
    @FindBy(css = "#passwd")
    private static WebElement txtBoxPassword;

    /**
     * Locator for dropdown: "days"
     */
    @FindBy(css = "#days")
    private static WebElement drpDwnDays;

    /**
     * Locator for dropdown: "months"
     */
    @FindBy(css = "#months")
    private static WebElement drpDwnMonths;

    /**
     * Locator for dropdown: "years"
     */
    @FindBy(css = "#years")
    private static WebElement drpDwnYears;

    /**
     * Locator for Text box: "Company"
     */
    @FindBy(css = "#company")
    private static WebElement txtBoxCompany;

    /**
     * Locator for Text box: "Address1"
     */
    @FindBy(css = "#address1")
    private static WebElement txtBoxAddress1;

    /**
     * Locator for Text box: "Address2"
     */
    @FindBy(css = "#address2")
    private static WebElement txtBoxAddress2;

    /**
     * Locator for Text box: "City"
     */
    @FindBy(css = "#city")
    private static WebElement txtBoxCity;

    /**
     * Locator for Dropdown: "State"
     */
    @FindBy(css = "#id_state")
    private static WebElement drpDwnState;

    /**
     * Locator for Text box: "Zip/Postal Code"
     */
    @FindBy(css = "#postcode")
    private static WebElement txtBoxPostCode;

    /**
     * Locator forDropdown: "Country"
     */
    @FindBy(css = "id_country")
    private static WebElement drpDwnCountry;

    /**
     * Locator for Text box: "Additional information"
     */
    @FindBy(xpath = "//*[@class='form-control' and @name='other']")
    private static WebElement txtBoxAdditionalInfo;

    /**
     * Locator for Text box: "Home phone"
     */
    @FindBy(css = "#phone")
    private static WebElement txtBoxHomePhone;

    /**
     * Locator for Text box: "Mobile phone"
     */
    @FindBy(css = "#phone_mobile")
    private static WebElement txtBoxPhoneMobile;

    /**
     * Locator for Text box: "Assign an address alias for future reference."
     */
    @FindBy(css = "#alias")
    private static WebElement txtBoxAlias;

    /**
     * Locator for Button: "Register"
     */
    @FindBy(css = "#submitAccount")
    private static WebElement btnRegister;

    /**
     * Locator for Label: "My Account"
     */
    @FindBy(css = ".page-heading")
    private static WebElement lblMyAccount;

    /**
     * Locator for link: "firstname lastname"
     */
    @FindBy(css = ".account")
    private static WebElement linkUserName;

    /**
     * Locator for Label: "Welcome to your account. Here you can manage all of
     * your personal information and orders."
     */
    @FindBy(css = ".info-account")
    private static WebElement lblSubHeading;

    /**
     * Locator for Link: "Sign out"
     */
    @FindBy(css = ".logout")
    private static WebElement linkSignOut;

    /**
     * Locator for Text box: "Email address"
     */
    @FindBy(css = "#email")
    private static WebElement txtBoxEmail;

    /**
     * Locator for Button: "Sign in"
     */
    @FindBy(css = "#SubmitLogin")
    private static WebElement btnSignIn;

    /**
     * Locator for Menu Link: "Women"
     */
    @FindBy(linkText = "Women")
    private static WebElement linkWomen;

    /**
     * Locator for Link block: "Faded Short Sleeve T-shirts"
     */
    @FindBy(css = ".product_list.grid.row>li:first-child .right-block .product-name")
    private static WebElement LinkFadedShortTShirt;

    /**
     * Locator for Button: "Add to Cart"
     */
    @FindBy(css = "[name='Submit']")
    private static WebElement BtnAddToCart;

    /**
     * Locator for Button: "Proceed To Checkout"
     */
    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private static WebElement btnProceedToCheckout;

    /**
     * Locator for Button on review order: "Proceed to checkout"
     */
    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private static WebElement btnReviewProceedToCheckout;

    /**
     * Locator for Button - processAddress: "Proceed to checkout"
     */
    //*[@name='processAddress' and @type='submit']//*[text()='Proceed to checkout']
    @FindBy(xpath = "//*[@name='processAddress' and @type='submit']/span[text()='Proceed to checkout']")
    private static WebElement btnProcessAddress;

    /**
     * Locator for Checkbox: "I agree to the terms of service and will adhere to
     * them unconditionally. (Read the Terms of Service)"
     */
    @FindBy(xpath = "//*[@name='cgv' and @id='cgv']")
    private static WebElement chkBoxIAgree;

    /**
     * Locator for Button: "Proceed to checkout"
     */
    @FindBy(css = "[name='processCarrier']")
    private static WebElement btnProcessCarrier;

    /**
     * Locator for Link: "Pay by bank wire"
     */
    @FindBy(css = ".bankwire")
    private static WebElement LinkBankWire;

    /**
     * Locator for Button: "I confirm my order"
     */
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private static WebElement btnIConfirmMyOrder;

    /**
     * Locator for Breadcrumb: "Shipping"
     */
    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private static WebElement LinkShippingBrdCrmb;

    /**
     * Locator for Breadcrumb: "Payment"
     */
    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private static WebElement linkPaymentBrdCrmb;

    /**
     * Locator for label message: "Your order on My Store is complete."
     */
    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private static WebElement lblOrderIsComplete;

    /**
     * Locator for label error message: "An account using this email address has already been registered. Please enter a valid password or request a new one."
     */
    @FindBy(css = "#create_account_error")
    private static WebElement lblErrorMsgPanel;

    /**
     * Locator for button: "Add to cart"
     */
    @FindBy(css = ".button-container>span")
    private static WebElement btnAddToCartOnMouseAction;

    /**
     * Locator for label: "Payment"
     */
    @FindBy(css = ".step_current.last")
    private static WebElement lblPaymentBrdCrmb;

    // --------------Getters----------------

    /**
     * Locator for label: "Payment"
     * @return lblPaymentBrdCrmb
     */
    public static WebElement getLblPaymentBrdCrmb() {
        return lblPaymentBrdCrmb;
    }

    /**
     * Locator for button: "Add to cart"
     * @return btnAddToCartOnMouseAction
     */
    public static WebElement getBtnAddToCartOnMouseAction() {
        return btnAddToCartOnMouseAction;
    }

    /**
     * Locator for label error message: "An account using this email address has already been registered. Please enter a valid password or request a new one."
     * @return lblErrorMsgPanel
     */
    public  static WebElement getLblErrorMsgPanel() {
        return lblErrorMsgPanel;
    }

    /**
     * Locator for label message: "Your order on My Store is complete."
     *
     * @return lblOrderIsComplete
     */
    public static WebElement getLblOrderIsComplete() {
        return lblOrderIsComplete;
    }

    /**
     * Locator for Breadcrumb: "Payment"
     *
     * @return linkPaymentBrdCrmb
     */
    public static WebElement getLinkPaymentBrdCrmb() {
        return linkPaymentBrdCrmb;
    }

    /**
     * Locator for Breadcrumb: "Shipping"
     *
     * @return LinkShippingBrdCrmb
     */
    public static WebElement getLinkShippingBrdCrmb() {
        return LinkShippingBrdCrmb;
    }

    /**
     * Locator for Button: "I confirm my order"
     *
     * @return btnIConfirmMyOrder
     */
    public static WebElement getBtnIConfirmMyOrder() {
        return btnIConfirmMyOrder;
    }

    /**
     * Locator for Link: "Pay by bank wire"
     *
     * @return LinkBankWire
     */
    public static WebElement getLinkBankWire() {
        return LinkBankWire;
    }

    /**
     * Locator for Button: "Proceed to checkout"
     *
     * @return btnProcessCarrier
     */
    public static WebElement getBtnProcessCarrier() {
        return btnProcessCarrier;
    }

    /**
     * Locator for Checkbox: "I agree to the terms of service and will adhere to
     * them unconditionally. (Read the Terms of Service)"
     *
     * @return chkBoxIAgree
     */
    public static WebElement getChkBoxIAgree() {
        return chkBoxIAgree;
    }

    /**
     * Locator for Button - processAddress: "Proceed to checkout"
     *
     * @return btnProcessAddress
     */
    public static WebElement getBtnProcessAddress() {
        return btnProcessAddress;
    }

    /**
     * Locator for Button on review order: "Proceed to checkout"
     *
     * @return btnReviewProceedToCheckout
     */
    public static WebElement getBtnReviewProceedToCheckout() {
        return btnReviewProceedToCheckout;
    }

    /**
     * Locator for Button: "Proceed To Checkout"
     *
     * @return btnProceedToCheckout
     */
    public static WebElement getBtnProceedToCheckout() {

        return btnProceedToCheckout;
    }

    /**
     * Locator for Button: "Add to Cart"
     *
     * @return BtnAddToCart
     */
    public static WebElement getBtnAddToCart() {
        return BtnAddToCart;
    }

    /**
     * Locator for Link block: "Faded Short Sleeve T-shirts"
     *
     * @return LinkFadedShortTShirt
     */
    public static WebElement getLinkFadedShortTShirt() {
        return LinkFadedShortTShirt;
    }

    /**
     * Locator for Menu Link: "Women"
     *
     * @return linkWomen
     */
    public static WebElement getLinkWomen() {
        return linkWomen;
    }

    /**
     * Locator for Button: "Sign in"
     *
     * @return btnSignIn
     */
    public static WebElement getBtnSignIn() {
        return btnSignIn;
    }

    /**
     * Locator for Text box: "Email address"
     *
     * @return txtBoxEmail
     */
    public static WebElement getTxtBoxEmail() {
        return txtBoxEmail;
    }

    /**
     * Locator for Link: "Sign out"
     *
     * @return linkSignOut
     */
    public static WebElement getLinkSignOut() {
        return linkSignOut;
    }

    /**
     * Locator for Label: "Welcome to your account. Here you can manage all of
     * your personal information and orders."
     *
     * @return lblSubHeading
     */
    public static WebElement getLblSubHeading() {
        return lblSubHeading;
    }

    /**
     * Locator for link: "firstname lastname"
     *
     * @return linkUserName
     */
    public static WebElement getLinkUserName() {
        return linkUserName;
    }

    /**
     * Locator for Label: "My Account"
     *
     * @return lblMyAccount
     */
    public static WebElement getLblMyAccount() {
        return lblMyAccount;
    }

    /**
     * Locator for Button: "Register"
     *
     * @return btnRegister
     */
    public static WebElement getBtnRegister() {
        return btnRegister;
    }

    /**
     * Locator for Text box: "Assign an address alias for future reference."
     *
     * @return txtBoxAlias
     */
    public static WebElement getTxtBoxAlias() {
        return txtBoxAlias;
    }

    /**
     * Locator for Text box: "Mobile phone"
     *
     * @return txtBoxPhoneMobile
     */
    public static WebElement getTxtBoxPhoneMobile() {
        return txtBoxPhoneMobile;
    }

    /**
     * Locator for Text box: "Home phone"
     *
     * @return txtBoxHomePhone
     */
    public static WebElement getTxtBoxHomePhone() {
        return txtBoxHomePhone;
    }

    /**
     * Locator for Text box: "Additional information"
     *
     * @return txtBoxAdditionalInfo
     */
    public static WebElement getTxtBoxAdditionalInfo() {
        return txtBoxAdditionalInfo;
    }

    /**
     * Locator forDropdown: "Country"
     *
     * @return drpDwnCountry
     */
    public static WebElement getDrpDwnCountry() {
        return drpDwnCountry;
    }

    /**
     * Locator for Text box: "Zip/Postal Code"
     *
     * @return txtBoxPostCode
     */
    public static WebElement getTxtBoxPostCode() {
        return txtBoxPostCode;
    }

    /**
     * Locator for Dropdown: "State"
     *
     * @return drpDwnState
     */
    public static WebElement getDrpDwnState() {
        return drpDwnState;
    }

    /**
     * Locator for Text box: "City"
     *
     * @return txtBoxCity
     */
    public static WebElement getTxtBoxCity() {
        return txtBoxCity;
    }

    /**
     * Locator for Text box: "Address2"
     *
     * @return txtBoxAddress2
     */
    public static WebElement getTxtBoxAddress2() {
        return txtBoxAddress2;
    }

    /**
     * Locator for Text box: "Address1"
     *
     * @return txtBoxAddress1
     */
    public static WebElement getTxtBoxAddress1() {
        return txtBoxAddress1;
    }

    /**
     * Locator for Text box: "Company"
     *
     * @return txtBoxCompany
     */
    public static WebElement getTxtBoxCompany() {
        return txtBoxCompany;
    }

    /**
     * Locator for dropdown: "years"
     *
     * @return drpDwnYears
     */
    public static WebElement getDrpDwnYears() {
        return drpDwnYears;
    }

    /**
     * Locator for dropdown: "months"
     *
     * @return drpDwnMonths
     */
    public static WebElement getDrpDwnMonths() {
        return drpDwnMonths;
    }

    /**
     * Locator for dropdown: "days"
     *
     * @return drpDwnDays
     */
    public static WebElement getDrpDwnDays() {
        return drpDwnDays;
    }

    /**
     * Locator for Text box: "Password"
     *
     * @return txtBoxPassword
     */
    public static WebElement getTxtBoxPassword() {
        return txtBoxPassword;
    }

    /**
     * Locator for Text box: "Last Name"
     *
     * @return txtBoxLastName
     */
    public static WebElement getTxtBoxLastName() {
        return txtBoxLastName;
    }

    /**
     * Locator for Text box: "First Name"
     *
     * @return txtBoxFirstName
     */
    public static WebElement getTxtBoxFirstName() {
        return txtBoxFirstName;
    }

    /**
     * Locator for Radio button: "Mrs."
     *
     * @return rdBtnMrs
     */
    public static WebElement getRdBtnMrs() {
        return rdBtnMrs;
    }

    /**
     * Locator for Radio button: "Mr."
     *
     * @return rdBtnMr
     */
    public static WebElement getRdBtnMr() {
        return rdBtnMr;
    }

    /**
     * Locator for button: "Create an account"
     *
     * @return btnCreateAnAcc
     */
    public static WebElement getBtnCreateAnAcc() {
        return btnCreateAnAcc;
    }

    /**
     * Locator for textbox: "Create An Account"
     *
     * @return txtBoxCreateAcc
     */
    public static WebElement getTxtBoxCreateAcc() {
        return txtBoxCreateAcc;
    }

    /**
     * Locator for link: "Sign in"
     *
     * @return linkSignin
     */
    public static WebElement getLinkSignin() {
        return linkSignin;
    }

}
