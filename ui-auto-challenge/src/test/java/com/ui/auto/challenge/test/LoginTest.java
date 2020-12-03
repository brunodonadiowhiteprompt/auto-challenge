package com.ui.auto.challenge.test;

import com.ui.auto.challenge.data.Constants;
import com.ui.auto.challenge.utils.ComponentFactory;
import com.ui.auto.challenge.views.BasePage;
import com.ui.auto.challenge.views.LoginPage;
import com.ui.auto.challenge.views.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test
  public void standardUserLoginTest() {
    logger.info("TEST. Standard User Login");

    logger.info("STEP. The user is at Login page");
    LoginPage loginPage = ComponentFactory.create(BasePage.class).navigateToLanding(LoginPage.class);

    logger.info("STEP. The user fills the Username field");
    loginPage.fillUsernameField(Constants.TestData.LOGIN_STANDARD_USER_USERNAME);

    logger.info("STEP. The user fills the Password field");
    loginPage.fillPasswordField(Constants.TestData.LOGIN_STANDARD_USER_PASSWORD);

    logger.info("STEP. The user clicks on Continue button");
    ProductsPage productsPage = loginPage.clickLoginButton();

    logger.info("VERIFY. The user should be authenticated");
    Assert.assertTrue(
        productsPage.isHeaderContainerDisplayed(), "The user should be authenticated");
  }
}
