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

    logger.info("STEP. The user adds all the products to the shopping cart");
    productsPage.addAllProductsToCart();

    // Store total count of products for further validation
    Integer totalProductsCount = productsPage.getTotalProductsCount();

    // Store total price of products for further validation
    Double totalProductsPrice = productsPage.getTotalProductsPrice();

    logger.info("VERIFY. Shopping Cart Badge should count the total number of products");
    Assert.assertEquals(
        productsPage.getShoppingCartBadgeValue(),
        totalProductsCount,
        "Shopping Cart Badge should count the total number of products");

    logger.info("STEP. The user clicks on Shopping Cart link");
    ShoppingCartPage shoppingCartPage = productsPage.clickShoppingCartLink();

    logger.info("VERIFY. Shopping Cart items should count the total number of products added");
    Assert.assertEquals(
        shoppingCartPage.getTotalCartItemsCount(),
        totalProductsCount,
        "Shopping Cart items should count the total number of products added");

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

    logger.info("VERIFY. Order subtotal value should match the sum of the added products price");
    Assert.assertEquals(
        checkoutOverviewPage.getOrderSubtotal(),
        totalProductsPrice,
        "Order subtotal value should match the sum of the added products price");

    logger.info("STEP. The user clicks on Finish button");
    CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();

    logger.info("VERIFY. Order Confirmation message is displayed");
    Assert.assertTrue(
        checkoutCompletePage.isOrderConfirmationContainerDisplayed(),
        "Order Confirmation message is displayed");
  }
}
