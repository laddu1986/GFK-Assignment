package com.controller;

import com.Logger;
import com.model.AutomationPracticePageModel;
import com.utils.ExplicitWaitUtils;
import com.utils.JavascriptUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Laddu shashavali
 */
public class AutomationPracticePageController extends PageBaseMethods {

    private String PASSWORD;
    Logger logger=new Logger(AutomationPracticePageController.class);

    public AutomationPracticePageController(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, AutomationPracticePageModel.class);
    }

    /**
     * Navigating to the portal
     */
    public void PortalIsOpened() {
        logger.writeLog("INFO","The portal is opened");
        navigateToApplication();//(properties.getProperty("PortalUrl"));
    }

    /**************************** AND Methods *************************/
    /**
     * Method to load the portal url
     *
     * @param
     */
    public void loadURL() {
        logger.writeLog("INFO","Opening url .........");
        navigateToApplication();

    }

    /**
     * Method to click on Create an account button
     */
    public void clickOnCreateAnAccountBtn() {
        logger.writeLog("INFO","Clicking on button: " + AutomationPracticePageModel.getBtnCreateAnAcc().getText());
        AutomationPracticePageModel.getBtnCreateAnAcc().click();
    }

    /**
     * Filling YOUR ADDRESS fields
     */
    public void fillYourAddressFields() {
        logger.writeLog("INFO","Filling YOUR ADDRESS fields");
        AutomationPracticePageModel.getTxtBoxCompany().sendKeys(properties.getProperty("Company"));
        AutomationPracticePageModel.getTxtBoxAddress1().sendKeys(properties.getProperty("Address1"));
        AutomationPracticePageModel.getTxtBoxAddress2().sendKeys(properties.getProperty("Address2"));
        AutomationPracticePageModel.getTxtBoxCity().sendKeys(properties.getProperty("City"));
        Select select = new Select(AutomationPracticePageModel.getDrpDwnState());
        select.selectByVisibleText(properties.getProperty("State"));
        AutomationPracticePageModel.getTxtBoxPostCode().sendKeys(properties.getProperty("PostalCode"));
        AutomationPracticePageModel.getTxtBoxAdditionalInfo().sendKeys(properties.getProperty("AdditionalInfo"));
        AutomationPracticePageModel.getTxtBoxPhoneMobile().sendKeys(properties.getProperty("MobilePhone"));
        AutomationPracticePageModel.getTxtBoxAlias().clear();
        AutomationPracticePageModel.getTxtBoxAlias().sendKeys(properties.getProperty("Alias"));
    }

    /**
     * Clicking on Register button
     */
    public void clickOnRegisterBtn() {
        logger.writeLog("INFO","Clciking on Register button");
        AutomationPracticePageModel.getBtnRegister().click();
    }

    /**
     * Verifying the user name
     */
    public void verifyUsername() {
        logger.writeLog("INFO","Correct username is showing at the top");
        assertEquals(AutomationPracticePageModel.getLinkUserName().getText(), properties.getProperty("UserName"));
    }

    /**
     * Verifying the Sign-out link
     */
    public void verifySignoutBtn() {
        logger.writeLog("INFO","Verifying the Sign-out link");
        assertTrue(AutomationPracticePageModel.getLinkSignOut().isDisplayed());
    }

    /**
     * Checking the header MY ACCOUNT
     */
    public void verifyMyAccHeader() {
       logger.writeLog("INFO","MY ACCOUNT header is present");
       assertEquals(AutomationPracticePageModel.getLblMyAccount().getText(), properties.getProperty("HeaderMyAccountText"));
    }

    /**
     * Verifying the welcome message
     */
    public void verifyWelcomeMsg() {
        logger.writeLog("INFO","Welcome message is present");
        assertEquals(AutomationPracticePageModel.getLblSubHeading().getText(), properties.getProperty("WelcomeText"));
        AutomationPracticePageModel.getLinkSignOut().click();
    }

    /**
     * Entering email
     *
     * @param
     */
    public void enterEmailAddr() {
        String EMAIL=generateRandomEmail();
        logger.writeLog("INFO","Entering email " + EMAIL);
        AutomationPracticePageModel.getTxtBoxCreateAcc().sendKeys(EMAIL);
    }

    /**
     * Clicking on the sign-in button below the email/pass fields
     */
    public void clickOnSignInBtnBelowPassField() {
        logger.writeLog("INFO","Sign in button below the passsword field is clicked");
        AutomationPracticePageModel.getBtnSignIn().click();
        if (isElementDisplayed(AutomationPracticePageModel.getLblErrorMsgPanel())) {
            AutomationPracticePageModel.getTxtBoxCreateAcc().sendKeys(generateRandomEmail());
        }else{
            logger.writeLog("INFO","Sign in is successfull");
        }
    }

    /**
     * Entering credentials
     */
    public void enterEmailAndPass() {
        logger.writeLog("INFO","email and password are entered in the fields");
        waitForElementToBeVisible(By.cssSelector("#email"));
        AutomationPracticePageModel.getTxtBoxEmail().sendKeys(properties.getProperty("AlreadyRegisteredEmail"));
        AutomationPracticePageModel.getTxtBoxPassword().sendKeys(properties.getProperty("Password"));
    }

    /**
     * Checking out the desired product in below methods
     */
    public void selectProductWithTitleFadedShort() {
       logger.writeLog("INFO","User is selecting the product");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");
        AutomationPracticePageModel.getLinkFadedShortTShirt().click();
    }

    public void clickOnAddToCartButton() {
        logger.writeLog("INFO","Clicking on add to cart");
        AutomationPracticePageModel.getBtnAddToCart().click();
    }

    public void clickOnProceedToChkOutOnOverlay() {
        logger.writeLog("INFO","Clicking on Proceed to checkout on an overlay");
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(AutomationPracticePageModel.getBtnProceedToCheckout());
        AutomationPracticePageModel.getBtnProceedToCheckout().click();
    }

    public void clickProceedOnShoppingSummaryPage() {
        logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnReviewProceedToCheckout().");
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(AutomationPracticePageModel.getBtnReviewProceedToCheckout());
        AutomationPracticePageModel.getBtnReviewProceedToCheckout().click();
    }

    public void clickProceedOnAddrSection() {
       logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnProcessAddress().");
        JavascriptUtils javascriptUtils=new JavascriptUtils(driver);
        javascriptUtils.scrollToElement(AutomationPracticePageModel.getBtnProcessAddress());
       /* ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(AutomationPracticePageModel.getBtnProcessAddress());
      */  javascriptUtils.actionClick(AutomationPracticePageModel.getBtnProcessAddress());
    }

    public void clickOnIAgreeChkBox() {
        logger.writeLog("INFO","selecting the checkbox terms");
        JavascriptUtils javascriptUtils=new JavascriptUtils(driver);
        javascriptUtils.scrollToElement(AutomationPracticePageModel.getChkBoxIAgree());
        /*ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForElementDisplayed(AutomationPracticePageModel.getChkBoxIAgree(),10);*/
        AutomationPracticePageModel.getChkBoxIAgree().click();
    }

    public void clickOnProceedOnShippingSection() {
        logger.writeLog("INFO","clicking ...AutomationPracticePageModel.getBtnProcessCarrier().");
        JavascriptUtils javascriptUtils=new JavascriptUtils(driver);
        javascriptUtils.scrollToElement(AutomationPracticePageModel.getBtnProcessCarrier());
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForElementDisplayed(AutomationPracticePageModel.getBtnProcessCarrier(),10);
        AutomationPracticePageModel.getBtnProcessCarrier().click();
    }

    public void clickOnPaymentPayByBankWire() {
        logger.writeLog("INFO","clicking on the payment method...");
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForElementDisplayed(AutomationPracticePageModel.getLinkBankWire(),10);
        AutomationPracticePageModel.getLinkBankWire().click();
    }

    public void clickOnBtnIConfirmMyOrder() {
        logger.writeLog("INFO","I confirm ...");
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForElementDisplayed(AutomationPracticePageModel.getBtnIConfirmMyOrder(),10);
        AutomationPracticePageModel.getBtnIConfirmMyOrder().click();
    }

    public void verifyOrderIsComplete() {
        assertEquals(AutomationPracticePageModel.getLblOrderIsComplete().getText(),
                properties.getProperty("OrderIsCompleteTextMsg"));
    }

    public void verifyLastBreadcrumb() {
        assertTrue(AutomationPracticePageModel.getLblPaymentBrdCrmb().getAttribute("class")
                .equals(properties.getProperty("ClassPropertyValue")));
    }

    /**************************** WHEN Methods *************************/
    /**
     * Method to click on Sign in button on Home page
     */
    public void clickSignInOnHomePage() {
        logger.writeLog("INFO","Clicking on Sign in link: " + AutomationPracticePageModel.getLinkSignin().getText());
        //waitForElementToBeVisible(By.cssSelector(".login"));
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(By.cssSelector(".login"));
        AutomationPracticePageModel.getLinkSignin().click();
    }

    /**
     * Method to fill all the fields of user's personal info
     */
    public void fillUserPersonalInfo() {
        logger.writeLog("INFO","Entering personal info");
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(AutomationPracticePageModel.getRdBtnMr());
        AutomationPracticePageModel.getRdBtnMr().click();
        AutomationPracticePageModel.getTxtBoxFirstName().sendKeys(properties.getProperty("FirstName"));
        AutomationPracticePageModel.getTxtBoxLastName().sendKeys(properties.getProperty("LastName"));
        AutomationPracticePageModel.getTxtBoxPassword().sendKeys(properties.getProperty("Password"));
        PASSWORD = AutomationPracticePageModel.getTxtBoxPassword().getAttribute("value");
        Select select = new Select(AutomationPracticePageModel.getDrpDwnDays());
        select.selectByIndex(3);
        select = new Select(AutomationPracticePageModel.getDrpDwnMonths());
        select.selectByIndex(3);
        select = new Select(AutomationPracticePageModel.getDrpDwnYears());
        select.selectByIndex(3);
    }

    /**
     * Clicking on the sign-in button
     */
    public void clickOnTopSignInBtn() {
        ExplicitWaitUtils explicitWaitUtils=new ExplicitWaitUtils(driver);
        explicitWaitUtils.waitForVisibilityOfElement(AutomationPracticePageModel.getLinkSignin());
        AutomationPracticePageModel.getLinkSignin().click();
    }

    /**
     * Selecting the category from top menu: Women
     */
    public void clickOnWomenOption() {
        logger.writeLog("INFO","User is clicking on Women section");
        AutomationPracticePageModel.getLinkWomen().click();
    }

    /**************************** THEN Methods *************************/

    /**
     * Verifying the URL appender
     */
    public void appConfirmationUrl() {
        logger.writeLog("INFO","Appender URL is loaded correctly");
        assertTrue(driver.getCurrentUrl().contains(properties.getProperty("ConfirmationAppUrl")));
    }

    /**
     * Verifying the URL appender
     */
    public void afterLoginUrl() {
        logger.writeLog("INFO","Login is successful");
        boolean afterLoginUrl = driver.getCurrentUrl().contains(properties.getProperty("ConfirmationAppUrl"));
        assertTrue(afterLoginUrl);
    }

    /**
     * Verifying the URL appender
     */
    public void verifyConfirmationUrlForOrder() {
        logger.writeLog("INFO","Verifying the url...");
        assertTrue(driver.getCurrentUrl().contains(properties.getProperty("OrderConfirmUrl")));
    }
}
