package com.ui.auto.challenge.views;

import com.ui.auto.challenge.utils.ComponentFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

  @FindBy(css = "input[data-test='username']")
  private WebElement usernameField;

  @FindBy(css = "input[data-test='password']")
  private WebElement passwordField;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "h3[data-test='error']")
  private WebElement errorMessageContainer;

  /**
   * Fill Username field
   *
   * @param username
   */
  public void fillUsernameField(String username) {
    logger.info(String.format("Filling Username field with [%s]", username));
    usernameField.sendKeys(username);
  }

  /**
   * Fill Password field
   *
   * @param password
   */
  public void fillPasswordField(String password) {
    logger.info(String.format("Filling Password field with [%s]", password));
    passwordField.sendKeys(password);
  }

  /**
   * Click Login button
   *
   * @return ProductsPage
   */
  public ProductsPage clickLoginButton() {
    logger.info("Clicking on Login button");
    loginButton.click();

    return ComponentFactory.create(ProductsPage.class);
  }

  /**
   * Get Error Message Container content
   *
   * @return String
   */
  public String getErrorMessage() {
    return errorMessageContainer.getText();
  }
}
