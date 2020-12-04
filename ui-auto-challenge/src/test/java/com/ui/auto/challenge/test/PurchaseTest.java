package com.ui.auto.challenge.test;

import com.ui.auto.challenge.data.Constants;
import com.ui.auto.challenge.helpers.LoginHelper;
import com.ui.auto.challenge.utils.ComponentFactory;
import com.ui.auto.challenge.views.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

  @Test
  public void purchaseAllTheTShirtsTest() {
    logger.info("TEST. Purchase all the T-Shirts");

    logger.info("STEP. The user is at Login page");
    LoginPage loginPage =
        ComponentFactory.create(BasePage.class).navigateToLanding(LoginPage.class);

    logger.info("STEP. The user performs login as Standard User");
    ProductsPage productsPage =
        LoginHelper.login(
            loginPage,
            Constants.TestData.LOGIN_STANDARD_USER_USERNAME,
            Constants.TestData.LOGIN_STANDARD_USER_PASSWORD);

    logger.info("STEP. The user adds all the T-Shirts to the shopping cart");
    productsPage.addAllTShirtsToCart();

    // Store total count of T-Shirts for further validation
    Integer totalTShirtsCount = productsPage.getTotalTShirtsCount();

    // Store total price of T-Shirts for further validation
    Double totalTShirtsPrice = productsPage.getTotalTShirtsPrice();

    logger.info("VERIFY. Shopping Cart Badge should count the total number of T-Shirts");
    Assert.assertEquals(
        productsPage.getShoppingCartBadgeValue(),
        totalTShirtsCount,
        "Shopping Cart Badge should count the total number of T-Shirts");

    logger.info("STEP. The user clicks on Shopping Cart link");
    ShoppingCartPage shoppingCartPage = productsPage.clickShoppingCartLink();

    logger.info("VERIFY. Shopping Cart items should count the total number of T-shirts added");
    Assert.assertEquals(
        shoppingCartPage.getTotalCartItemsCount(),
        totalTShirtsCount,
        "Shopping Cart items should count the total number of T-Shirts added");

    logger.info("STEP. The user clicks on Checkout button");
    CheckoutYourInformationPage checkoutYourInformationPage =
        shoppingCartPage.clickCheckoutButton();

    logger.info("STEP. The user fills the First Name field");
    checkoutYourInformationPage.fillFirstNameField(
        Constants.TestData.CHECKOUT_YOUR_INFORMATION_FIRST_NAME);

    logger.info("STEP. The user fills the Last Name field");
    checkoutYourInformationPage.fillLastNameField(
        Constants.TestData.CHECKOUT_YOUR_INFORMATION_LAST_NAME);

    logger.info("STEP. The user fills the Postal Code field");
    checkoutYourInformationPage.fillPostalCodeField(
        Constants.TestData.CHECKOUT_YOUR_INFORMATION_POSTAL_CODE);

    logger.info("STEP. The user clicks on Continue button");
    CheckoutOverviewPage checkoutOverviewPage = checkoutYourInformationPage.clickContinueButton();

    logger.info("VERIFY. Order subtotal value should match the sum of the added T-Shirts price");
    Assert.assertEquals(
        checkoutOverviewPage.getOrderSubtotal(),
        totalTShirtsPrice,
        "Order subtotal value should match the sum of the added T-Shirts price");

    logger.info("STEP. The user clicks on Finish button");
    CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();

    logger.info("VERIFY. Order Confirmation message is displayed");
    Assert.assertTrue(
        checkoutCompletePage.isOrderConfirmationContainerDisplayed(),
        "Order Confirmation message is displayed");
  }
}
