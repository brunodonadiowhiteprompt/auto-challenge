package com.ui.auto.challenge.helpers;

import com.ui.auto.challenge.views.LoginPage;
import com.ui.auto.challenge.views.ProductsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginHelper {

  protected static final Logger logger = LogManager.getLogger();

  /**
   * Perform user login
   *
   * @return ProductsPage
   */
  public static ProductsPage login(LoginPage signInPage, String username, String password) {
    logger.info("STEP. The user fills the Username field");
    signInPage.fillUsernameField(username);

    logger.info("STEP. The user fills the Password field");
    signInPage.fillPasswordField(password);

    logger.info("STEP. The user clicks on Login button");
    return signInPage.clickLoginButton();
  }
}
